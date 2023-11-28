package com.rupizza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * initializes the actual controller application.
 * @author Karthik Gangireddy, Vineal Sunkara
 */
public class ruPizzaMain extends Application {
    /**
     * Main method that starts everything.
     * @param stage stage that begins the project.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ruPizzaMain.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("RU Pizza");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main method
     * @param args command line.
     */
    public static void main(String[] args) {
        launch();
    }
}