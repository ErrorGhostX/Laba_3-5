package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;


public class Person {

    private final StringProperty name;             // Ф.И.О. автора
    private final StringProperty phone;            // Телефон
    private final StringProperty email;            // E-mail
    private final IntegerProperty rating;          // Рейтинг
    private final StringProperty bookTitle;        // Название книги
    private final StringProperty binding;           // Переплет
    private final StringProperty publishing;        // Издательство
    private final IntegerProperty yearOfPublication; // Год издания
    private final StringProperty genre;             // Жанр

    public Person() {
        this(null, null, null, 0, null, null, null, 0, null);
    }


    public Person(String name, String phone, String email, int rating, String bookTitle,
                  String binding, String publishing, int yearOfPublication, String genre) {
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.rating = new SimpleIntegerProperty(rating);
        this.bookTitle = new SimpleStringProperty(bookTitle);
        this.binding = new SimpleStringProperty(binding);
        this.publishing = new SimpleStringProperty(publishing);
        this.yearOfPublication = new SimpleIntegerProperty(yearOfPublication);
        this.genre = new SimpleStringProperty(genre);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public int getRating() {
        return rating.get();
    }

    public void setRating(int rating) {
        this.rating.set(rating);
    }

    public IntegerProperty ratingProperty() {
        return rating;
    }

    public String getBookTitle() {
        return bookTitle.get();
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle.set(bookTitle);
    }

    public StringProperty bookTitleProperty() {
        return bookTitle;
    }

    public String getBinding() {
        return binding.get();
    }

    public void setBinding(String binding) {
        this.binding.set(binding);
    }

    public StringProperty bindingProperty() {
        return binding;
    }

    public String getPublishing() {
        return publishing.get();
    }

    public void setPublishing(String publishing) {
        this.publishing.set(publishing);
    }

    public StringProperty publishingProperty() {
        return publishing;
    }

    public int getYearOfPublication() {
        return yearOfPublication.get();
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication.set(yearOfPublication);
    }

    public IntegerProperty yearOfPublicationProperty() {
        return yearOfPublication;
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
