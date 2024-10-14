module com.javafx_aromart.aromamartjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.javafx_aromart.aromamartjavafx to javafx.fxml;
    exports com.javafx_aromart.aromamartjavafx;
}