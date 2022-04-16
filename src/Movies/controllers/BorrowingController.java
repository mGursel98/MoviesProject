
package Movies.controllers;

import Movies.util.ConnectDB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
//import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;


public class BorrowingController implements Initializable {

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
    private Button btn_close;

    @FXML
    private JFXTextField txt_movie_id;

    @FXML
    private JFXDatePicker txt_date;

    @FXML
    private JFXTextField txt_actor_id;

    @FXML
    private JFXTextField txt_time;

    @FXML
    private Label lbl_title1;

    @FXML
    private JFXButton btn_save;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    private Label lblStatus;

    /**
     * Initializes the controller class.
     */
    public static final LocalDate NOW_LOCAL_DATE() {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    public void TimeDisplay() {
        Date date = new Date();
        do {
            showTime.setText(date.toString());
        } while (0 == 0);
    }

    PreparedStatement preparedStatement;
    Connection connection;

    @FXML
    private void BorrowingAction(ActionEvent event) {
        if (event.getSource() == btn_save) {
            saveData();
            UpdateQuantity();
        }
        if (event.getSource() == btn_cancel) {
            clearFields();

        }
    }

    public BorrowingController() throws SQLException {
        connection = (Connection) ConnectDB.conDB();
    }

    /**
     * Initializes the controller class.
     */
    private void clearFields() {
        txt_actor_id.clear();
        txt_movie_id.clear();
        lblStatus.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TimeDisplay();
        txt_date.setValue(NOW_LOCAL_DATE());

        //CLOCK
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            int second = LocalDateTime.now().getSecond();
            int minute = LocalDateTime.now().getMinute();
            int hour = LocalDateTime.now().getHour();
            showTime.setText(hour + ":" + (minute) + ":" + second);
            txt_time.setText(hour + ":" + (minute) + ":" + second);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    String startDate;

    private void saveData() {
        try {

            startDate = txt_date.getValue().toString() + " " + txt_time.getText();

            String st = "INSERT INTO borrows VALUES (null,?,?,?,null)";

            preparedStatement = (PreparedStatement) connection.prepareStatement(st);

            preparedStatement.setString(1, txt_actor_id.getText());
            preparedStatement.setString(2, txt_movie_id.getText());
            preparedStatement.setString(3, startDate);

            preparedStatement.executeUpdate();
            lblStatus.setTextFill(Color.GREEN);
            lblStatus.setText("Успешно добавяне");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText(ex.getMessage());

        }
    }
    
     private void UpdateQuantity() {
        try {

            String st = "UPDATE  movies\n"
                    + "set rating= rating-1"
                    + " where Movie_id =?"   ;
            
         PreparedStatement   preparedStatementUp = (PreparedStatement) connection.prepareStatement(st);

           preparedStatementUp.setString(1, txt_movie_id.getText());
            
            preparedStatementUp.executeUpdate();
            //lblStatus.setTextFill(Color.GREEN);
            //lblStatus.setText("Added Successfully");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           // lblStatus.setTextFill(Color.TOMATO);
           // lblStatus.setText(ex.getMessage());

        }
    }
     
      @FXML
    private void BorrowingMenu(ActionEvent event) {

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

        //Students
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
