package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
    private final StringProperty title; // Название
    private final StringProperty genre; // Жанр

    public Book() {
        this(null, null);
    }

    public Book(String title, String genre) {
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public StringProperty genreProperty() {
        return genre;
    }
}
