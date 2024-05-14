package com.example.lenaapi.controllers;

import com.example.lenaapi.entites.User;
import com.example.lenaapi.exceptions.user.NoSuchUserException;
import com.example.lenaapi.exceptions.user.SuchUserAlreadyExistsException;
import com.example.lenaapi.exceptions.user.UserIsBlockedException;
import com.example.lenaapi.models.CredentialsModel;
import com.example.lenaapi.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Long registerUser(@RequestBody @Valid CredentialsModel credentialsModel) throws SuchUserAlreadyExistsException {
        return userService.registerUser(credentialsModel).getId();
    }

    @PutMapping("/block")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody int changeUserBlockStatus(@RequestParam String login, @RequestParam boolean isBlocked) throws NoSuchUserException {
        return userService.updateBlockUser(login, isBlocked);
    }

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody User authUser(@RequestBody @Valid CredentialsModel credentialsModel) throws NoSuchUserException, UserIsBlockedException {
        return userService.authUser(credentialsModel);
    }

    @PostMapping("/change")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody long changeUserCredentials(@RequestBody @Valid CredentialsModel credentialsModel, @RequestParam Long id) throws SuchUserAlreadyExistsException, NoSuchUserException {
        return userService.changeUserCredentials(credentialsModel, id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
