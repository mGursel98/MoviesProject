/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movies.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @authors Muhammed , Sinan and Todor
 */
public class GenreController implements Initializable {

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
    private Label showTime;

    @FXML
    private Button btn_close;

    @FXML
    private ColumnConstraints Cat_grid;

    @FXML
    private JFXButton btn_Genre1;

    @FXML
    private JFXButton btn_Genre4;

    @FXML
    private JFXButton btn_Genre2;

    @FXML
    private JFXButton btn_Genre5;

    @FXML
    private JFXButton btn_Genre3;

    @FXML
    private JFXButton btn_Genre7;

    @FXML
    private JFXButton btn_Genre8;

    @FXML
    private JFXButton btn_Genre6;

    @FXML
    private JFXButton btn_Genre9;

    //  int genre_id = 1;
    /**
     * Initializes the controller class.
     */
    public void CatgTimeDisplay() {
        Date date = new Date();
        do {
            showTime.setText(date.toString());
        } while (0 == 0);

    }
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
    }

    @FXML
    private void GenresAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("/Movies/fxml/Genre_view.fxml")));

        try {
            loader.load();

        } catch (IOException ex2) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex2);
        }
        Genre_viewController display = loader.<Genre_viewController>getController();
        //loader.getController();

        display.setText(1);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();

    }

    @FXML
    private void GenresAction2(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("/Movies/fxml/Genre_view.fxml")));

        try {
            loader.load();

        } catch (IOException ex2) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex2);
        }
        Genre_viewController display = loader.<Genre_viewController>getController();
        //loader.getController();
        display.setText(2);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();

    }

    @FXML
    private void GenresAction3(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("/Movies/fxml/Genre_view.fxml")));

        try {
            loader.load();

        } catch (IOException ex2) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex2);
        }
        Genre_viewController display = loader.<Genre_viewController>getController();
        //loader.getController();
        display.setText(3);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();

    }

    @FXML
    private void GenresAction4(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("/Movies/fxml/Genre_view.fxml")));

        try {
            loader.load();

        } catch (IOException ex2) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex2);
        }
        Genre_viewController display = loader.<Genre_viewController>getController();
        //loader.getController();
        display.setText(4);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();

    }

    @FXML
    private void GenresAction5(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("/Movies/fxml/Genre_view.fxml")));

        try {
            loader.load();

        } catch (IOException ex2) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex2);
        }
        Genre_viewController display = loader.<Genre_viewController>getController();
        //loader.getController();
        display.setText(5);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();

    }

    @FXML
    private void GenresAction6(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("/Movies/fxml/Genre_view.fxml")));

        try {
            loader.load();

        } catch (IOException ex2) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex2);
        }
        Genre_viewController display = loader.<Genre_viewController>getController();
        //loader.getController();
        display.setText(6);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();

    }

    @FXML
    private void GenresAction7(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("/Movies/fxml/Genre_view.fxml")));

        try {
            loader.load();

        } catch (IOException ex2) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex2);
        }
        Genre_viewController display = loader.<Genre_viewController>getController();
        //loader.getController();
        display.setText(7);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();

    }

    @FXML
    private void GenresAction8(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("/Movies/fxml/Genre_view.fxml")));

        try {
            loader.load();

        } catch (IOException ex2) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex2);
        }
        Genre_viewController display = loader.<Genre_viewController>getController();
        //loader.getController();
        display.setText(8);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();

    }

    @FXML
    private void GenresAction9(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("/Movies/fxml/Genre_view.fxml")));

        try {
            loader.load();

        } catch (IOException ex2) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex2);
        }
        Genre_viewController display = loader.<Genre_viewController>getController();
        //loader.getController();
        display.setText(9);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();

    }

//MENU
    @FXML
    private void GenresMenu(ActionEvent event) {

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
