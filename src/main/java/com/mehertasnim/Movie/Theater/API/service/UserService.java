package com.mehertasnim.Movie.Theater.API.service;

import com.mehertasnim.Movie.Theater.API.model.Show;
import com.mehertasnim.Movie.Theater.API.model.User;
import com.mehertasnim.Movie.Theater.API.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with the id: " + userId));
    }

    public List<Show> getShowsWatchedByUser(Long userId) {
        User user = getUserById(userId);
        return user.getWatchedShows();
    }

    public User addWatchedShow(Long userId, Show show) {
        User user = getUserById(userId);
        user.getWatchedShows().add(show);
        return userRepository.save(user);
    }
}
