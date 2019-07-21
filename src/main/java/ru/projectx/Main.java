package ru.projectx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    private static MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(new File("src/main/java/ru/projectx/fxml/title.fxml").toURI().toURL());
        primaryStage.setTitle("Hi Vlad");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        Media media = new Media(new File("src/main/resources/music/main.mp3").toURI().toString()); //replace /Movies/test.mp3 with your file
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
