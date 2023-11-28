module com.rupizza {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.rupizza to javafx.fxml;
    exports com.rupizza;
}