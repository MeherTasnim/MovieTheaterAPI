package com.mehertasnim.Movie.Theater.API.service;

import com.mehertasnim.Movie.Theater.API.model.Show;
import com.mehertasnim.Movie.Theater.API.repository.ShowRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> getAllShows() {

        return showRepository.findAll();
    }

    public Show getShowById(Long showId) {
        return showRepository.findById(showId)
                .orElseThrow(() -> new EntityNotFoundException("Show not found with the id: " + showId));
    }

    public List<Show> getShowsByGenre(String genre) {

        return showRepository.findByGenre(genre);
    }

    public Show updateShowRating(Long showId, String rating) {
        Show show = getShowById(showId);
        show.setRating(rating);
        return showRepository.save(show);
    }

    public Show updateShowStatus(Long showId, String status) {
        Show show = getShowById(showId);
        show.setStatus(status);
        return showRepository.save(show);
    }

    public void deleteShow(Long showId) {
        Show show = getShowById(showId);
        showRepository.delete(show);
    }

}
