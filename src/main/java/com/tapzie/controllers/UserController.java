package com.tapzie.controllers;

import com.tapzie.commands.TapForm;
import com.tapzie.commands.UserForm;
import com.tapzie.converters.UserToUserForm;
import com.tapzie.entities.Tap;
import com.tapzie.entities.User;
import com.tapzie.services.StorageService;
import com.tapzie.services.TapService;
import com.tapzie.services.UserService;
import com.tapzie.utilities.AuthKey;
import com.tapzie.utilities.Hash256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
@Controller
class UserController {
    @Value("${img.cdn}")
    private String imgCDNPath;

    private UserService userService;

    private TapService tapService;

    private UserToUserForm userToUserForm;


    private final StorageService storageService;

    @Autowired
    public UserController(StorageService storageService) {
        this.storageService = storageService;
    }


    @Autowired
    public void setUserToUserForm(UserToUserForm userToUserForm) {
        this.userToUserForm = userToUserForm;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTapService(TapService tapService) {
        this.tapService = tapService;
    }

    public Boolean isUUID(String id) {
        try {
            UUID.fromString(id).toString().equals(id);
            return true;
        } catch (IllegalArgumentException | NullPointerException ex) {
            return false;
        }
    }

    @RequestMapping({"/", "/home"})
    public String index(@CookieValue(value = "AuthKey", defaultValue = "0") String authKey, Model model){
        if(userService.userCountByAuthKey(authKey) == 0) {
            return "index/home";
        } else {
            User user = userService.findByAuthKey(authKey);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("firstName", user.getFirstName());
            model.addAttribute("lastName", user.getLastName());
            return "user/home";
        }
    }

    @RequestMapping({"/user/list", "/user"})
    public String listusers(Model model){
        model.addAttribute("users", userService.listAll());
        return "user/list";
    }


    @RequestMapping("/signup")
    public String newUser(@CookieValue(value = "AuthKey", defaultValue = "0") String authKey, Model model){
        if(userService.userCountByAuthKey(authKey) == 0) {
            model.addAttribute("userForm", new User());
            return "user/signup";
        } else {
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletResponse response) throws NoSuchAlgorithmException {


        // Set user auth key
        Cookie cookie = new Cookie("AuthKey", "" + 0);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String saveOrUpdateUser(HttpServletResponse response, @Valid UserForm userForm, BindingResult bindingResult, @RequestParam(value = "file") MultipartFile image) throws NoSuchAlgorithmException {
        if(bindingResult.hasErrors()){
            return "user/login";
        }

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail(userForm.getEmail());
        user.setPassword(Hash256.convert(userForm.getPassword()));
        user.setUsername(userForm.getUsername());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());

        UUID fileNameUUID = UUID.randomUUID();
        storageService.uploadFile(image, fileNameUUID + image.getOriginalFilename());
        user.setProfilePicture(imgCDNPath + fileNameUUID + image.getOriginalFilename());
        userService.saveOrUpdate(user);
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String loginView(@CookieValue(value = "AuthKey", defaultValue = "0") String authKey, Model model){
        if(userService.userCountByAuthKey(authKey) == 0) {
            model.addAttribute("userForm", new User());
            return "user/login";
        } else {
            return "redirect:/home";
        }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(HttpServletResponse response, @CookieValue(value = "AuthKey", defaultValue = "0") String authKey, @Valid UserForm userForm, BindingResult bindingResult) throws NoSuchAlgorithmException {

        // Any binding errors?
        if(bindingResult.hasErrors()){
            return "user/login";
        }

        if(userService.userCountByAuthKey(authKey) == 0) {

            // Get user row count by email and password parameter (post)
            Integer emailCount = userService.userCountByEmail(userForm.getEmail());
            Integer passwordCount = userService.userCountByPassword(Hash256.convert(userForm.getPassword()));

            // Check if count == 0
            if (emailCount == 0) {
                System.out.println("[Tapzie] Failed log in. (Email not found)");
                return "redirect:/login";
            } else {
                System.out.println("[Tapzie] Email found");
                if (passwordCount == 0) {
                    return "redirect:/login";
                } else {
                    UUID userId = userService.userIdByEmail(userForm.getEmail());
                    String authkey = AuthKey.create();



                    User user = userService.getById(userId);
                    user.setAuthKey(authkey);
                    userService.saveOrUpdate(user);

                    Cookie cookie = new Cookie("AuthKey", authkey);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    return "redirect:/home";
                }
            }
        } else {
            return "redirect:/home";
        }
    }

    @RequestMapping("/user/delete/{id}")
    public String delete(@PathVariable String id){
        userService.delete(UUID.fromString(id));
        return "redirect:/user/list";
    }

    @RequestMapping({"/user/{id}", "/u/{id}"})
    public String viewUserProfile(@PathVariable String id, @CookieValue(value = "AuthKey", defaultValue = "0") String authKey, Model model, @Valid TapForm tapCreateForm, BindingResult bindingResult){
        if(isUUID(id)) {
            User user = userService.findByAuthKey(authKey);
            User profile = userService.getById(UUID.fromString(id));

            model.addAttribute("user", user);
            model.addAttribute("profile", profile);
            model.addAttribute("tapCreateForm", tapCreateForm);

            model.addAttribute("taps", tapService.findByUserId(profile.getId()));
            return "user/profile";
        } else {
            User user = userService.findByAuthKey(authKey);
            model.addAttribute("user", user);
            model.addAttribute("profile", user);
            model.addAttribute("tapCreateForm", tapCreateForm);

            model.addAttribute("taps", tapService.findByUserId(user.getId()));
            return "user/profile";
        }
    }

    @RequestMapping({"/profile", "/me", "/account"})
    public String viewOwnProfile(@CookieValue(value = "AuthKey", defaultValue = "0") String authKey, Model model, @Valid TapForm tapCreateForm, BindingResult bindingResult){
        User user = userService.findByAuthKey(authKey);
        model.addAttribute("user", user);
        model.addAttribute("profile", user);
        model.addAttribute("tapCreateForm", tapCreateForm);

        model.addAttribute("taps", tapService.findByUserId(user.getId()));
        return "user/profile";
    }

    @RequestMapping(value = "/create/tap", method = RequestMethod.POST)
    public String createNewTap(@CookieValue(value = "AuthKey", defaultValue = "0") String authKey, HttpServletResponse response, @Valid TapForm tapForm, BindingResult bindingResult) throws NoSuchAlgorithmException {
        User profile = userService.findByAuthKey(authKey);

        Tap tap = new Tap();
        tap.setId(UUID.randomUUID());
        tap.setContent(tapForm.getContent());
        tap.setUserID(profile.getId());
        tap.setCreatedDate(new Date());
        tapService.save(tap);
        return "redirect:/user/" + profile.getId();
    }

    /* Edit Profile */
    @RequestMapping(value="/profile/edit", method = RequestMethod.POST)
    public String editUser(@CookieValue(value = "AuthKey", defaultValue = "0") String authKey, HttpServletResponse response, @Valid UserForm userForm, BindingResult bindingResult, @RequestParam(value = "file") MultipartFile image) throws NoSuchAlgorithmException {
        if(bindingResult.hasErrors()){
            return "user/login";
        }

        User user = userService.findByAuthKey(authKey);
        user.setEmail(userForm.getEmail());
        user.setUsername(userForm.getUsername());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());

        // Check if user uploads new profile picture
        if(!image.isEmpty()){
            UUID fileNameUUID = UUID.randomUUID();
            storageService.uploadFile(image, fileNameUUID + image.getOriginalFilename());
            user.setProfilePicture(imgCDNPath + fileNameUUID + image.getOriginalFilename());
        }

        userService.saveOrUpdate(user);
        return "redirect:/profile";
    }

    @RequestMapping("/profile/edit")
    public String editProfileView(@CookieValue(value = "AuthKey", defaultValue = "0") String authKey, Model model){
        if(userService.userCountByAuthKey(authKey) == 0) {
            return "redirect:/login";
        } else {
            User user = userService.findByAuthKey(authKey);
            model.addAttribute("user", user);
            model.addAttribute("userForm", new User());
            return "user/edit_profile";
        }
    }



}
