package com.mehertasnim.Movie.Theater.API.model;
import jakarta.persistence.*;

@Entity
@Table(name = "show")
public class Show {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(name = "title", nullable = false)
     private String title;

     @Column(name = "genre", nullable = false)
     private String genre;

     @Column(name = "rating")
     private String rating;

     @Column(name = "status")
     private String status;

     public Show() {
     }

     public Show(Long id, String title, String genre, String rating, String status) {
          this.id = id;
          this.title = title;
          this.genre = genre;
          this.rating = rating;
          this.status = status;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getGenre() {
          return genre;
     }

     public void setGenre(String genre) {
          this.genre = genre;
     }

     public String getRating() {
          return rating;
     }

     public void setRating(String rating) {
          this.rating = rating;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }
}
