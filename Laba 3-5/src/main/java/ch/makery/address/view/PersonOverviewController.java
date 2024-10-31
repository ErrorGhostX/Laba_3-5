package ch.makery.address.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Person;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameAuthor; // Ф.И.О.
    @FXML
    private TableColumn<Person, String> number; // Телефон
    @FXML
    private TableColumn<Person, String> email; // E-mail
    @FXML
    private TableColumn<Person, String> rating; // Рейтинг

    @FXML
    private Label nameBook; // Название
    @FXML
    private Label binding; // Переплет
    @FXML
    private Label publishing; // Издательство
    @FXML
    private Label yearOfPublication; // Год издания
    @FXML
    private Label genre; // Жанр

    private MainApp mainApp;

    public PersonOverviewController() {
    }

    @FXML
    private void initialize() {

        nameAuthor.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        number.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        email.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        rating.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getRating())));


        showBookDetails(null);


        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        personTable.setItems(mainApp.getPersonData());
    }

    private void showBookDetails(Person person) {
        if (person != null) {

            nameBook.setText(person.getBookTitle());
            binding.setText(person.getBinding());
            publishing.setText(person.getPublishing());
            yearOfPublication.setText(Integer.toString(person.getYearOfPublication()));
            genre.setText(person.getGenre());
        } else {

            nameBook.setText("");
            binding.setText("");
            publishing.setText("");
            yearOfPublication.setText("");
            genre.setText("");
        }
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {

            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Нет выбора");
            alert.setHeaderText("Ничто не выбрано");
            alert.setContentText("Пожалуйста, выберите человека в таблице.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showBookDetails(selectedPerson);
            }
        } else {

            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Нет выбора");
            alert.setHeaderText("Ничто не выбрано");
            alert.setContentText("Пожалуйста, выберите человека в таблице.");

            alert.showAndWait();
        }
    }
}
