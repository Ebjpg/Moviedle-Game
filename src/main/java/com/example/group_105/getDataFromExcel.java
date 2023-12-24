package com.example.group_105;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class getDataFromExcel extends Application {

    public static String[][] data;
    public static String[][] Movies = new String[251][8];
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        int row = 0;

        FileChooser fileChooser = new FileChooser(); // Open file picker to select excel file
        fileChooser.setTitle("Choose The Excel File");
        File excelFile = fileChooser.showOpenDialog(primaryStage);

        if (excelFile != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(excelFile), StandardCharsets.ISO_8859_1))) { //The charset we use to provide ISO-8859-1 Language Support
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(";");
                    if (data == null) {
                        data = new String[251][8];
                    }
                    //It collects the data taken from Excel into an array named data
                    System.arraycopy(values, 0, data[row], 0, values.length);
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Movies = data; //We copied the series Data into Movies in order to be easy to use and comply with Object-Oriented Programming principles.
        }}}
