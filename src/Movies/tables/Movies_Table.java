
package Movies.tables;

public class Movies_Table {
    String movie_id, title, director, rating, genre_name;

    public Movies_Table(String movie_id, String title, String director, String rating, String genre_name) {
        this.movie_id = movie_id;
        this.title = title;
        this.director = director;
        this.rating = rating;
        this.genre_name = genre_name;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id)
    {
        this.movie_id = movie_id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }
    
    
}
