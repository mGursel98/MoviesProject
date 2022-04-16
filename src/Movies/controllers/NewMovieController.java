
package Movies.controllers;

import Movies.util.ConnectDB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
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


public class NewMovieController implements Initializable {

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
    private JFXTextField txt_title;

    @FXML
    private JFXComboBox<String> txt_genre;

    @FXML
    private JFXTextField txt_director;

    @FXML
    private JFXTextField txt_rating;

    @FXML
    private Label lbl_title1;

    @FXML
    private JFXButton btn_save;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    private Label lblStatus;

    PreparedStatement preparedStatement;
    Connection connection;

    @FXML
    private void NewMovieAction(ActionEvent event) {
        if (event.getSource() == btn_save) {
            saveData();
        }
        if (event.getSource() == btn_cancel) {
            clearFields();

        }
    }
     public NewMovieController() throws SQLException {
        connection = (Connection) ConnectDB.conDB();
    }
    

    /**
     * Initializes the controller class.
     */
    private void clearFields() {
        txt_title.clear();
        txt_director.clear();
        txt_rating.clear();
    }

    String genre;

    private void saveData() {
        try {
            //category
            switch (txt_genre.getValue().toString()) {
                case "Анимация":
                    genre = "1";
                    break;
                case "Екшън":
                    genre = "2";
                    break;
                case "Драма":
                    genre = "3";
                    break;
                case "Приключенски":
                    genre = "4";
                    break;
                case "Комедия":
                    genre = "5";
                    break;
                case "Крими":
                    genre = "6";
                    break;
                case "Ужаси":
                    genre = "7";
                    break;
                case "Романтичен":
                    genre = "8";
                    break;
                case "Фентъзи":
                    genre = "9";
                    break;
//PIE CHART

            }

            String st = "INSERT INTO movies VALUES (null,?,?,?,?)";

            preparedStatement = (PreparedStatement) connection.prepareStatement(st);

            preparedStatement.setString(1, txt_title.getText());
            preparedStatement.setString(2, txt_director.getText());
            preparedStatement.setString(3, txt_rating.getText());
            preparedStatement.setString(4, genre);

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
    public void NewMovieTime() {
        Date date = new Date();
        do {
            showTime.setText(date.toString());
        } while (0 == 0);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txt_genre.getItems().addAll("Анимация", "Екшън", "Драма","Приключенски", "Комедия",
                "Крими","Ужаси", "Романтичен", "Фентъзи");
        txt_genre.getSelectionModel().select("Анимация");
        
         //CLOCK
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            int second = LocalDateTime.now().getSecond();
            int minute = LocalDateTime.now().getMinute();
            int hour = LocalDateTime.now().getHour();
            showTime.setText(hour + ":" + (minute) + ":" + second);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    
     @FXML
    private void NewMovieMenu(ActionEvent event) {

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
        //Movies
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

        //Genres
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
