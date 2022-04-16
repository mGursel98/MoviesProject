package Movies.controllers;

import Movies.tables.Borrows_Table;
import Movies.util.ConnectDB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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


public class BorrowsController implements Initializable {

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
    private JFXButton btn_add_borrow;
    @FXML
    private JFXButton btn_add_return;

    @FXML
    private TableView tblData;

    @FXML
    private TableColumn<Borrows_Table, String> col_Actor_id;

    @FXML
    private TableColumn<Borrows_Table, String> col_first_name;

    @FXML
    private TableColumn<Borrows_Table, String> col_Last_name;

    @FXML
    private TableColumn<Borrows_Table, String> col_Title;

    @FXML
    private TableColumn<Borrows_Table, String> col_Director;

    @FXML
    private TableColumn<Borrows_Table, String> col_Start_date;

    @FXML
    private TableColumn<Borrows_Table, String> col_End_date;
    @FXML
    private TableColumn<Borrows_Table, String> col_Borrow_id;

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement;
    Connection connection;

    public BorrowsController() throws SQLException {
        connection = (Connection) ConnectDB.conDB();
    }

    public void BorSTimeDisplay() {
        Date date = new Date();
        do {
            showTime.setText(date.toString());
        } while (0 == 0);

    }

    /**
     * Initializes the controller class.
     */
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
        // Actor_id , First_name , Last_name , Title, Director, Start_date, End_date

        tblData.setEditable(true);

        FilteredList<Borrows_Table> flBorrows = new FilteredList(data, p -> true);//Pass the data to a filtered list
        tblData.setItems(flBorrows);//Set the table's items using the filtered list

        choiceBox.getItems().addAll("Actor id", "First name", "Last name", "Title",
                "Director", "Start date", "End date");
        choiceBox.setValue("First name");

        textField.setOnKeyReleased(keyEvent -> {
            switch (choiceBox.getValue())//Switch on choiceBox value
            {
                case "Actor id":
                    flBorrows.setPredicate(p -> p.getActor_id().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "First name":
                    flBorrows.setPredicate(p -> p.getFirst_name().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Last name":
                    flBorrows.setPredicate(p -> p.getLast_name().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Title":
                    flBorrows.setPredicate(p -> p.getTitle().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Director":
                    flBorrows.setPredicate(p -> p.getDirector().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Start date":
                    flBorrows.setPredicate(p -> p.getStart_date().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "End date":
                    flBorrows.setPredicate(p -> p.getEnd_date().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;

            }

        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                -> {//reset table and textfield when new choice is selected
            if (newVal != null) {
                textField.setText("");
                flBorrows.setPredicate(null);
            }
        });

        col_Actor_id.setCellValueFactory(new PropertyValueFactory<>("Actor_id"));
        col_first_name.setCellValueFactory(new PropertyValueFactory<>("First_name"));
        col_Last_name.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
        col_Title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        col_Director.setCellValueFactory(new PropertyValueFactory<>("Director"));
        col_Start_date.setCellValueFactory(new PropertyValueFactory<>("Start_date"));
        col_End_date.setCellValueFactory(new PropertyValueFactory<>("End_date"));
        col_Borrow_id.setCellValueFactory(new PropertyValueFactory<>("Borrow_id"));

        display();
        //table.setItems(data);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                -> {//reset table and textfield when new choice is selected
            if (newVal != null) {
                textField.setText("");
                flBorrows.setPredicate(null);
            }
        });
    }

    ObservableList<Borrows_Table> data = FXCollections.observableArrayList();

    String SQL = " SELECT actors.Actor_id , actors.First_name , actors.Last_name , \n"
            + "movies.Title, movies.Director, borrows.Start_date, borrows.End_date, borrows.Borrow_id\n"
            + "from actors JOIN borrows ON borrows.Actor_id=actors.Actor_id\n"
            + "JOIN movies ON movies.Movie_id=borrows.Movie_id ";

    private void display() {
        try {
            con = ConnectDB.conDB();

            Class.forName("com.mysql.cj.jdbc.Driver");

            rs = con.createStatement().executeQuery(SQL);

            while (rs.next()) {
                data.add(new Borrows_Table(rs.getString("Actor_id"), rs.getString("First_name"),
                        rs.getString("Last_name"), rs.getString("Title"), rs.getString("Director"), rs.getString("Start_date"), rs.getString("End_date"), rs.getString("Borrow_id")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MoviesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MoviesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BorrowsAction(ActionEvent event) {

        //Books
        if (event.getSource() == btn_add_borrow) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Movies/fxml/Borrowing.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
          //Books
        if (event.getSource() == btn_add_return) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Movies/fxml/Returning.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
     @FXML
    private void BorrowsMenu(ActionEvent event) {

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
