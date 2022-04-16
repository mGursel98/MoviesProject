
package Movies.controllers;

import Movies.util.ConnectDB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class NewActorController implements Initializable {
 @FXML
    private JFXButton btn1;

    @FXML
    private JFXButton btn2;

    @FXML
    private JFXButton btn3;

    @FXML
    private JFXButton btn4;

    @FXML
    private JFXButton btn5;

    @FXML
    private JFXButton btn_home;

    @FXML
    private Label lbl_title;

    @FXML
    private Pane top_green;

    @FXML
    private Label showTime;

    @FXML
    private Label lblStatus;
    
    @FXML
    private Button btn_close;

    @FXML
    private JFXTextField txt_first_name;

    @FXML
    private JFXTextField txt_last_name;

    @FXML
    private JFXComboBox<String> txt_gender;

    @FXML
    private JFXDatePicker txt_dob;

    @FXML
    private JFXTextField txt_address;

    @FXML
    private JFXTextField txt_phone_number;

    @FXML
    private JFXTextField txt_country;

    @FXML
    private Label lbl_title1;

    @FXML
    private JFXButton btn_save;

    @FXML
    private JFXButton btn_cancel;
    
     PreparedStatement preparedStatement;
    Connection connection;

    
    @FXML
    private void NewActorAction(ActionEvent event) {
        if (event.getSource() == btn_save) {
            saveData();
        }
        if (event.getSource() == btn_cancel) {
            clearFields();
           
        }
    }
    /**
     * Initializes the controller class.
     */
    private void clearFields() {
     
        txt_first_name.clear();
        txt_last_name.clear();
        txt_address.clear();
        txt_phone_number.clear();
        txt_country.clear();
            }
    
      public NewActorController() throws SQLException {
        connection = (Connection) ConnectDB.conDB();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         txt_gender.getItems().addAll("Жена", "Мъж", "Други");
        txt_gender.getSelectionModel().select("Мъж");
    }    
    
    
    
    //Save Data
    private void saveData() {
        try {
            String st = "INSERT INTO Actors VALUES (null,?,?,?,?,?,?,?)";

            preparedStatement = (PreparedStatement) connection.prepareStatement(st);

            preparedStatement.setString(1, txt_first_name.getText());
            preparedStatement.setString(2, txt_last_name.getText());
            preparedStatement.setString(3, txt_gender.getValue().toString());
            preparedStatement.setString(4, txt_dob.getValue().toString());
            preparedStatement.setString(5, txt_address.getText());
            preparedStatement.setString(6, txt_phone_number.getText());
            preparedStatement.setString(7, txt_country.getText());


            preparedStatement.executeUpdate();
            lblStatus.setTextFill(Color.GREEN);
            lblStatus.setText("Успешно добавен");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText(ex.getMessage());

        }
    }
    
     @FXML
    private void NewActorMenu(ActionEvent event) {

        if (event.getSource() == btn_close) {
           System.exit(0);
        }
        
        if (event.getSource() == btn_home) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Movies/fxml/home.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        //Books
        if (event.getSource() == btn1) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Movies/fxml/Movies.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        //Actors
        if (event.getSource() == btn3) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Movies/fxml/Actors.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        //Categories
        if (event.getSource() == btn2) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Movies/fxml/Genre.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        //Borrows
        if (event.getSource() == btn4) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Movies/fxml/Borrows.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

    }
}
