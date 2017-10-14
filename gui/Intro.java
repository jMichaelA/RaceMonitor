import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Intro extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("Create Event");
        btn.getStyleClass().addAll("create-event-btn");

        // button and event with lambda expression
//        Button exit = new Button("Exit");
//        exit.setId("exit");
//        exit.getStyleClass().add("button");
//        btn.getStyleClass().add("button");
//        exit.setOnAction(e -> {
//            System.out.println("exiting");
//            System.exit(0);
//        });
        Text introTitle = new Text("Create Race");
        introTitle.getStyleClass().addAll("sec-title", "intro-title");

        Text raceText = new Text("Race Name:       ");
        raceText.getStyleClass().addAll("text-label");

        TextField raceNameTxtFld = new TextField();
        raceNameTxtFld.getStyleClass().addAll("text-field");

        Text simText = new Text("Simulator data:  ");
        simText.getStyleClass().addAll("text-label");

        TextField simTxtFld = new TextField();
        simTxtFld.getStyleClass().addAll("text-field");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                startRace(raceNameTxtFld.getText(), simTxtFld.getText());
            }
        });

        VBox vboxBody = new VBox();
        vboxBody.getStyleClass().addAll("vbox", "body");

        HBox hboxTitle = new HBox();
        hboxTitle.getChildren().addAll(introTitle);
        hboxTitle.getStyleClass().addAll("hbox");

        HBox hboxName = new HBox();
        hboxName.getChildren().addAll(raceText, raceNameTxtFld);
        hboxName.getStyleClass().addAll("hbox");

        HBox hboxSimData = new HBox();
        hboxSimData.getChildren().addAll(simText, simTxtFld);
        hboxName.getStyleClass().addAll("hbox");

        HBox hboxCreate = new HBox();
        hboxCreate.getChildren().addAll(btn);
        hboxCreate.getStyleClass().addAll("hbox", "hbox-right");
        hboxCreate.setMargin(btn, new Insets(0, 183, 0, 0));
        hboxCreate.setAlignment(Pos.CENTER_RIGHT);

        vboxBody.getChildren().addAll(hboxTitle, hboxName, hboxSimData, hboxCreate);

        // pane width, height
        Scene scene = new Scene(vboxBody, 500, 300);
        scene.getStylesheets().add("assets/app.css");
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    private void startRace(String name, String fileName){
        try {
            Race race = new Race(name, fileName);
            Stage stage = new Stage();
            race.start(stage);

        } catch (IOException e) {
            System.out.println("Failed to create new Window.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
