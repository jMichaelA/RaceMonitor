import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ObserverGui extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Text athleteName = new Text("athlete 1");
        athleteName.getStyleClass().addAll("sec-title");

        Text dateTime = new Text("datetime:  ");
        dateTime.getStyleClass().addAll("text-label");

        Text dateTimeVal = new Text("Monday 4:00 am");
        dateTimeVal.getStyleClass().addAll("text-label");

        HBox hboxAthlete = new HBox();
        hboxAthlete.getStyleClass().addAll("hbox");
        hboxAthlete.getChildren().addAll(dateTime, dateTimeVal);

        VBox vboxAthleteTitle = new VBox();
        vboxAthleteTitle.getStyleClass().addAll("vbox");
        vboxAthleteTitle.getChildren().addAll(athleteName, hboxAthlete);

        HBox hboxAthleteTitle = new HBox();
        hboxAthleteTitle.getStyleClass().addAll("hbox");
        hboxAthleteTitle.getChildren().addAll(vboxAthleteTitle);

        VBox vboxBody = new VBox();
        vboxBody.getStyleClass().addAll("vbox", "body");
        vboxBody.getChildren().addAll(hboxAthleteTitle);

        Scene scene = new Scene(vboxBody, 1000, 700);
        scene.getStylesheets().add("assets/app.css");
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
}
