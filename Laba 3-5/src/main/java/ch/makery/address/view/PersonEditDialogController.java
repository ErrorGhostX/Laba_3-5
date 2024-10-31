package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.makery.address.model.Person;


public class PersonEditDialogController {

    @FXML
    private TextField nameAuthorField;          // Ф.И.О. автора
    @FXML
    private TextField numberField;               // Телефон
    @FXML
    private TextField emailField;                // E-mail
    @FXML
    private TextField ratingField;               // Рейтинг
    @FXML
    private TextField nameBookField;             // Название книги
    @FXML
    private TextField bindingField;               // Переплет
    @FXML
    private TextField publishingField;           // Издательство
    @FXML
    private TextField yearOfPublicationField;    // Год издания
    @FXML
    private TextField genreField;                 // Жанр

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;


    @FXML
    private void initialize() {
        // Установить стиль для полей ввода
        nameAuthorField.getStyleClass().add("text-field");
        numberField.getStyleClass().add("text-field");
        emailField.getStyleClass().add("text-field");
        ratingField.getStyleClass().add("text-field");
        nameBookField.getStyleClass().add("text-field");
        bindingField.getStyleClass().add("text-field");
        publishingField.getStyleClass().add("text-field");
        yearOfPublicationField.getStyleClass().add("text-field");
        genreField.getStyleClass().add("text-field");
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void setPerson(Person person) {
        this.person = person;

        nameAuthorField.setText(person.getName());
        numberField.setText(person.getPhone());
        emailField.setText(person.getEmail());
        ratingField.setText(Integer.toString(person.getRating()));
        // Здесь можно установить остальные поля, если у вас есть аналогичная модель для книг
    }


    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setName(nameAuthorField.getText());
            person.setPhone(numberField.getText());
            person.setEmail(emailField.getText());
            person.setRating(Integer.parseInt(ratingField.getText()));


            String ratingText = ratingField.getText();
            System.out.println("Рейтинг: " + ratingText); // Отладочный вывод
            person.setRating(Integer.parseInt(ratingText));

            // Установка информации о книге
            person.setBookTitle(nameBookField.getText());
            person.setBinding(bindingField.getText());
            person.setPublishing(publishingField.getText());
            person.setYearOfPublication(Integer.parseInt(yearOfPublicationField.getText()));
            person.setGenre(genreField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }


    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameAuthorField.getText() == null || nameAuthorField.getText().length() == 0) {
            errorMessage += "No valid author name!\n";
        }
        if (numberField.getText() == null || numberField.getText().length() == 0) {
            errorMessage += "No valid phone number!\n";
        }
        if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "No valid email!\n";
        }
        if (ratingField.getText() == null || ratingField.getText().length() == 0) {
            errorMessage += "No valid rating!\n";
        } else {
            // try to parse the rating into an int.
            try {
                Integer.parseInt(ratingField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid rating (must be an integer)!\n";
            }
        }
        if (nameBookField.getText() == null || nameBookField.getText().length() == 0) {
            errorMessage += "No valid book title!\n";
        }
        if (bindingField.getText() == null || bindingField.getText().length() == 0) {
            errorMessage += "No valid binding!\n";
        }
        if (publishingField.getText() == null || publishingField.getText().length() == 0) {
            errorMessage += "No valid publishing!\n";
        }
        if (yearOfPublicationField.getText() == null || yearOfPublicationField.getText().length() == 0) {
            errorMessage += "No valid year of publication!\n";
        } else {
            // try to parse the year of publication into an int.
            try {
                Integer.parseInt(yearOfPublicationField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid year of publication (must be an integer)!\n";
            }
        }
        if (genreField.getText() == null || genreField.getText().length() == 0) {
            errorMessage += "No valid genre!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
