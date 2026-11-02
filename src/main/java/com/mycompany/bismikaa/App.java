package com.mycompany.bismikaa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Atur FXML dan ukuran default jendela (misal: lebar 800px, tinggi 500px)
        scene = new Scene(loadFXML("primary"), 800, 500); 
        stage.setScene(scene);
        stage.setTitle("Kalkulator BMI");

        // MEMATIKAN FITUR RESIZE (KUNCI UKURAN JENDELA)
        stage.setResizable(false);

        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}