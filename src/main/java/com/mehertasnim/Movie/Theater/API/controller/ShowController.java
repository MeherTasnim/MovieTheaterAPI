package com.mehertasnim.Movie.Theater.API.controller;

import com.mehertasnim.Movie.Theater.API.model.Show;
import com.mehertasnim.Movie.Theater.API.service.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<Show> getAllShows() {

        return showService.getAllShows();
    }

    @GetMapping("/{showId}")
    public ResponseEntity<Show> getShowById(@PathVariable Long showId) {
        Show show = showService.getShowById(showId);
        return ResponseEntity.ok(show);
    }

    @GetMapping("/genre/{genre}")
    public List<Show> getShowsByGenre(@PathVariable String genre) {
        return showService.getShowsByGenre(genre);
    }

    @PutMapping("/{showId}/rating")
    public ResponseEntity<String> updateShowRating(
            @PathVariable Long showId,
            @RequestParam("rating") String rating
    ) {
        try {
            // Validate rating field
            if (rating == null || rating.trim().isEmpty() || rating.contains(" ")) {
                throw new IllegalArgumentException("Rating field cannot be empty or contain whitespace");
            }
            showService.updateShowRating(showId, rating);
            return ResponseEntity.ok("Show rating has been updated successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{showId}/status")
    public ResponseEntity<String> updateShowStatus(
            @PathVariable Long showId,
            @RequestParam("status") String status
    ) {
        try {
            // Validate status field
            if (status == null || status.trim().isEmpty() || status.contains(" ")) {
                throw new IllegalArgumentException("Status field cannot be empty or contain whitespace");
            }
            if (status.length() < 5 || status.length() > 25) {
                throw new IllegalArgumentException("Status field must be between 5 and 25 characters");
            }
            showService.updateShowStatus(showId, status);
            return ResponseEntity.ok("Show status has been updated successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{showId}")
    public ResponseEntity<String> deleteShow(@PathVariable Long showId) {
        showService.deleteShow(showId);
        return ResponseEntity.ok("Show has been deleted!");
    }
}
