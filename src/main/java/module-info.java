module com.mycompany.bismikaa {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.bismikaa to javafx.fxml;
    exports com.mycompany.bismikaa;
}
