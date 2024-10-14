package com.javafx_aromart.aromamartjavafx;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField tname;

    public PasswordField tpass;

    public Button btnCon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      btnCon.setOnAction(actionEvent ->login());
     
    }
    public void login(){
        PreparedStatement st = null;
        ResultSet rs=null;
        Connection connection = ConnectionDB.getConnection();
        try {
            st = connection.prepareStatement("Select * from test.user WHERE USERNAME=? AND PASSWORD=? ");
            st.setString(1,tname.getText());
            st.setString(2,tpass.getText());
            rs= st.executeQuery();
            if(rs.next()){

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"login successfully", ButtonType.OK);
                alert.show();

            }
            else {

                Alert alert = new Alert(Alert.AlertType.WARNING,"LOGIN ERROR ",ButtonType.OK);
                 alert.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
