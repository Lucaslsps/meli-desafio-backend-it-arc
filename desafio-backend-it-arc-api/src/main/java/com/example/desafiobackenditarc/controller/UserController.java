package com.example.desafiobackenditarc.controller;

import com.example.desafiobackenditarc.exception.EntityNotFoundException;
import com.example.desafiobackenditarc.service.UserPreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserPreferencesService userPreferencesService;

    @PatchMapping("/optout/{userId}")
    public ResponseEntity optOutUser(@PathVariable("userId") final Integer userId)
            throws EntityNotFoundException {
        userPreferencesService.changeUserAllowNotificationSetting(userId, false);
        return ResponseEntity.ok("OK");
    }

    @PatchMapping("/optin/{userId}")
    public ResponseEntity optInUser(@PathVariable("userId") final Integer userId)
            throws EntityNotFoundException {
        userPreferencesService.changeUserAllowNotificationSetting(userId, true);
        return ResponseEntity.ok("OK");
    }
}
