package Movies.controllers;

import Movies.util.ConnectDB;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;




public class HomeController implements Initializable {

    @FXML
    private Label lbl_title;

    @FXML
    private Pane top_pane;

    @FXML
    private Label showTime;

    @FXML
    private GridPane gridBtn;
    @FXML
    private Button btn_close;
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
    private BarChart<Number, String> bar_chart;
    final NumberAxis xAxis = new NumberAxis();
    final CategoryAxis yAxis = new CategoryAxis();

    @FXML
    private PieChart pie_chart;

    @FXML
    public void TimeDisplay() {
        Date date = new Date();
        do {
            showTime.setText(date.toString());
        } while (0 == 0);

    }
    Connection connection;

    public HomeController() throws SQLException {
        connection = (Connection) ConnectDB.conDB();
    }

/// 
    ResultSet resultset = null;
    Double num1 = 0.0;

    PreparedStatement preparedStatement1;

    double[] numArray = new double[10];

    void CountGenres() {
        numArray[0] = 0.0;
        for (int i = 1; i <= 9; i++) {
            try {

                String query = "select COUNT(*) as numb from movies where Genre_id=" + i;

                resultset = connection.createStatement().executeQuery(query);
                //resultset = connection.dbExecuteQuery(query);

                while (resultset.next()) {
                    String numb1 = resultset.getString("numb");
                    numArray[i] = Double.valueOf(numb1.trim()).doubleValue();
                }

            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CountGenres();
      //  CountGenresNumb();
        //PIE CHART
        PieChart.Data slice1 = new PieChart.Data("Анимация", numArray[1]);
        PieChart.Data slice2 = new PieChart.Data("Екшън", numArray[2]);
        PieChart.Data slice3 = new PieChart.Data("Драма", numArray[3]);
        PieChart.Data slice4 = new PieChart.Data("Приключенски", numArray[4]);
        PieChart.Data slice5 = new PieChart.Data("Комедия", numArray[5]);
        PieChart.Data slice6 = new PieChart.Data("Крими", numArray[6]);
        PieChart.Data slice7 = new PieChart.Data("Ужаси", numArray[7]);
        PieChart.Data slice8 = new PieChart.Data("Романтичен", numArray[8]);
        PieChart.Data slice9 = new PieChart.Data("Фентъзи", numArray[9]);

        pie_chart.getData().add(slice1);
        pie_chart.getData().add(slice2);
        pie_chart.getData().add(slice3);
        pie_chart.getData().add(slice4);
        pie_chart.getData().add(slice5);
        pie_chart.getData().add(slice6);
        pie_chart.getData().add(slice7);
        pie_chart.getData().add(slice8);
        pie_chart.getData().add(slice9);

        //BAR CHART
        final String Anime = "Анимация";
        final String Action = "Екшън";
        final String Drama = "Драма";
        final String Adventure = "Приключенски";
        final String Comedy = "Комедия";
        final String Crime = "Крими";
        final String Horror = "Ужаси";
        final String Romantic = "Романтичен";
        final String Fantasy = "Фентъзи";

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Филми");
        series1.getData().add(new XYChart.Data(Anime, numArray[1]));
        series1.getData().add(new XYChart.Data(Action, numArray[2]));
        series1.getData().add(new XYChart.Data(Drama, numArray[3]));
        series1.getData().add(new XYChart.Data(Adventure, numArray[4]));
        series1.getData().add(new XYChart.Data(Comedy, numArray[5]));
        series1.getData().add(new XYChart.Data(Crime, numArray[6]));
        series1.getData().add(new XYChart.Data(Horror, numArray[7]));
        series1.getData().add(new XYChart.Data(Romantic, numArray[8]));
        series1.getData().add(new XYChart.Data(Fantasy, numArray[9]));

        bar_chart.getData().addAll(series1);

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

///
    @FXML
    private void HomeAction(ActionEvent event) {

        if (event.getSource() == btn_close) {
            System.exit(0);
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
