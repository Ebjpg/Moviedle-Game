package com.example.group_105;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Run extends Application {
    @Override

    public void start(Stage stage) throws IOException {

        getDataFromExcel Excel = new getDataFromExcel();
        Excel.start(stage);
        System.out.println((getDataFromExcel.Movies[Controller.correctRow][1])); //Code that prints to console to ensure correct movie control
        FXMLLoader fxmlLoader = new FXMLLoader(Run.class.getResource("design.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Moviedle");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}