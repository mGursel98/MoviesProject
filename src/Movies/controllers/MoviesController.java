
package Movies.controllers;

import Movies.tables.Movies_Table;
import Movies.util.ConnectDB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MoviesController implements Initializable {

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
    private JFXButton btn_add_movie;

    @FXML
    private Label lbl_title;

    @FXML
    private Pane top_pane;

    @FXML
    private JFXComboBox<String> choiceBox;

    @FXML
    private JFXTextField textField;

    @FXML
    private Label showTime;

    @FXML
    private Button btn_close;

    @FXML
    private TableView tblData;

    @FXML
    private TableColumn<Movies_Table, String> col_Movie_id;

    @FXML
    private TableColumn<Movies_Table, String> col_title;

    @FXML
    private TableColumn<Movies_Table, String> col_Director;

    @FXML
    private TableColumn<Movies_Table, String> col_Rating;

    @FXML
    private TableColumn<Movies_Table, String> col_Genre;

    
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement;
    Connection connection;

    public MoviesController() throws SQLException {
        connection = (Connection) ConnectDB.conDB();
    }

    public void BTimeDisplay() {
        Date date = new Date();
        do {
            showTime.setText(date.toString());
        } while (0 == 0);

    }
 @FXML
    private void MoviesAction(ActionEvent event) {
        if (event.getSource() == btn_add_movie) {
            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Movies/fxml/NewMovie.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    //
    //movie_id, title, director, rating, genre_name
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        
        
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

        display();
        tblData.setEditable(true);

        FilteredList<Movies_Table> flMovies = new FilteredList(data, p -> true);//Pass the data to a filtered list
        tblData.setItems(flMovies);//Set the table's items using the filtered list

        choiceBox.getItems().addAll("Movie_id", "Title", "Director", "Genre_name");
        choiceBox.setValue("Title");

        textField.setOnKeyReleased(keyEvent -> {
            switch (choiceBox.getValue())//Switch on choiceBox value
            {
                case "Movie_id":
                    flMovies.setPredicate(p -> p.getMovie_id().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Title":
                    flMovies.setPredicate(p -> p.getTitle().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Director":
                    flMovies.setPredicate(p -> p.getDirector().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Rating":
                    flMovies.setPredicate(p -> p.getRating().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Genre_name":
                    flMovies.setPredicate(p -> p.getGenre_name().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;

            }

        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                -> {//reset table and textfield when new choice is selected
            if (newVal != null) {
                textField.setText("");
                flMovies.setPredicate(null);
            }
        });
        col_Movie_id.setCellValueFactory(new PropertyValueFactory<>("Movie_id"));
        col_title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        col_Director.setCellValueFactory(new PropertyValueFactory<>("Director"));
        col_Rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));
        col_Genre.setCellValueFactory(new PropertyValueFactory<>("Genre_name"));

        //table.setItems(data);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                -> {//reset table and textfield when new choice is selected
            if (newVal != null) {
                textField.setText("");
                flMovies.setPredicate(null);
            }
        });
    }
    
    
    
        ObservableList<Movies_Table> data = FXCollections.observableArrayList();;

        String SQL = "select movies.Movie_id, movies.title, movies.director, movies.rating, genres.genre_name "
                + " from movies join genres on movies.genre_id=genres.Genre_id";

    private void display() {
        try {
            con = ConnectDB.conDB();

            Class.forName("com.mysql.cj.jdbc.Driver");

            rs = con.createStatement().executeQuery(SQL);

            while (rs.next()) {
                data.add(new Movies_Table(rs.getString("Movie_id"), rs.getString("Title"),
                        rs.getString("Director"), rs.getString("Rating"), rs.getString("Genre_name")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MoviesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MoviesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  @FXML
    private void MoviesMenu(ActionEvent event) {

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
