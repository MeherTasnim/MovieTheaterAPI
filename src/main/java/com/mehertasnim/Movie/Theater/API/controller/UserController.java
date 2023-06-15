package com.mehertasnim.Movie.Theater.API.controller;

import com.mehertasnim.Movie.Theater.API.model.Show;
import com.mehertasnim.Movie.Theater.API.model.User;
import com.mehertasnim.Movie.Theater.API.service.ShowService;
import com.mehertasnim.Movie.Theater.API.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ShowService showService;

    public UserController(UserService userService, ShowService showService) {
        this.userService = userService;
        this.showService = showService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}/shows")
    public List<Show> getAllShowsWatchedByUser(@PathVariable Long userId) {
        return userService.getAllShowsWatchedByUser(userId);
    }

    @PutMapping("/{userId}/shows/{showId}")
    public ResponseEntity<User> addWatchedShow(
            @PathVariable Long userId,
            @PathVariable Long showId
    ) {
        Show show = showService.getShowById(showId);
        User updatedUser = userService.addWatchedShow(userId, show);
        return ResponseEntity.ok(updatedUser);
    }
}