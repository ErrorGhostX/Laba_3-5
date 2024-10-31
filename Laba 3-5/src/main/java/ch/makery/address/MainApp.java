package ch.makery.address;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ch.makery.address.model.Person;
import ch.makery.address.view.PersonEditDialogController;
import ch.makery.address.view.PersonOverviewController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;


    private ObservableList<Person> personData = FXCollections.observableArrayList();


    public MainApp() {
        // Добавление тестовых данных
        personData.add(new Person("Александр Пушкин", "1234567890", "pushkin@example.com", 5, "Евгений Онегин", "Твердый переплет", "Издательство А", 1837, "Роман"));
        personData.add(new Person("Лев Толстой", "0987654321", "tolstoy@example.com", 4, "Война и мир", "Мягкий переплет", "Издательство Б", 1869, "Роман"));
        personData.add(new Person("Фёдор Достоевский", "1122334455", "dostoevsky@example.com", 3, "Преступление и наказание", "Электронная книга", "Издательство В", 1866, "Роман"));
        personData.add(new Person("Антон Чехов", "2233445566", "chekhov@example.com", 4, "Чайка", "Твердый переплет", "Издательство Г", 1896, "Пьеса"));
        personData.add(new Person("Иван Тургенев", "3344556677", "turgenev@example.com", 2, "Отцы и дети", "Мягкий переплет", "Издательство Д", 1862, "Роман"));
        personData.add(new Person("Максим Горький", "4455667788", "gorky@example.com", 5, "На дне", "Электронная книга", "Издательство Е", 1902, "Пьеса"));
        personData.add(new Person("Михаил Булгаков", "5566778899", "bulgakov@example.com", 4, "Мастер и Маргарита", "Твердый переплет", "Издательство Ж", 1967, "Роман"));
        personData.add(new Person("Корней Чуковский", "6677889900", "chukovsky@example.com", 3, "Айболит", "Мягкий переплет", "Издательство З", 1938, "Детская литература"));
        personData.add(new Person("Даниил Хармс", "7788990011", "kharms@example.com", 5, "Старуха", "Электронная книга", "Издательство И", 1938, "Проза"));
    }



    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BookApp");

        // Устанавливаем иконку приложения.
        this.primaryStage.getIcons().add(new Image("file:resources/images/book.png"));
        initRootLayout();

        showPersonOverview();
    }


    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/RootLayout.fxml"));

            rootLayout = (BorderPane) loader.load();

            // Подключение CSS стилей
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showPersonOverview() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/PersonOverview.fxml"));

            AnchorPane personOverview = (AnchorPane) loader.load();


            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean showPersonEditDialog(Person person) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/PersonEditDialog.fxml"));

            AnchorPane page = (AnchorPane) loader.load();


            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
