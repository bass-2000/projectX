package ru.projectx.old;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application {
    private static MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Label label = new Label();
        label.setText("Adventures of sad guy");
        label.setTranslateX(310);
        label.setTranslateY(10);
        label.setScaleX(3.0);
        label.setScaleY(3.0);

        Label subLabel = new Label();
        subLabel.setTranslateX(260);
        subLabel.setTranslateY(55);
        subLabel.setText("Asociality saves the world! (No, it's not...)");


        Image image = new Image("large.jpg", true);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(500);
        Label imgLabel = new Label();
        imgLabel.setGraphic(imageView);
        imgLabel.setTranslateX(100);
        imgLabel.setTranslateY(75);

        Button playButton = new Button();
        playButton.setText("Start game");
        playButton.setTranslateX(300);
        playButton.setTranslateY(400);

        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameStart();
            }

            private void gameStart() {

            }
        });


        Button exitButton = new Button();
        exitButton.setText("Exit");
        exitButton.setTranslateX(320);
        exitButton.setTranslateY(430);

        exitButton.setOnAction(event -> {
            try {
                Platform.exit();
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        root.getChildren().addAll(label, subLabel, imgLabel, playButton, exitButton);
        Scene scene = new Scene(root, 720, 480);
        primaryStage.setScene(scene);
        primaryStage.show();


        Media media = new Media(new File("src/main/resources/music/main.mp3").toURI().toString()); //replace /Movies/test.mp3 with your file
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();


    }

}
