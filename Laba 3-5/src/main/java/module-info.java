module ch.makery.address.laba {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens ch.makery.address to javafx.fxml;

    exports ch.makery.address.view;
    opens ch.makery.address.view to javafx.fxml;
    exports ch.makery.address;
}