module com.example.projectof_1030510319_1030510263 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.group_105 to javafx.fxml;
    exports com.example.group_105;
}