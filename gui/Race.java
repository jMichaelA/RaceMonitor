import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Race extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Text title = new Text("Race Started");
        title.getStyleClass().addAll("title");

        Text obsTitle = new Text("Observers");
        obsTitle.getStyleClass().addAll("sec-title");

        TableView table = new TableView();
        table.getStyleClass().addAll("table");

        TableColumn obsName = new TableColumn("Observer");
        obsName.getStyleClass().addAll("col");
        TableColumn type = new TableColumn("Type");
        type.getStyleClass().addAll("col");
        TableColumn obsAthlete = new TableColumn("Athletes Subscribed to");
        obsAthlete.getStyleClass().addAll("sub-col", "col");

        table.getColumns().addAll(obsName, type, obsAthlete);

        Button subscribe = new Button("sub");
        subscribe.getStyleClass().addAll("button");
        /***TODO implement listener ***/

        Button unSubscribe = new Button("unsub");
        unSubscribe.getStyleClass().addAll("button");
        /***TODO implement listener ***/

        Text athleteTitle = new Text("Athletes");
        athleteTitle.getStyleClass().addAll("sec-title");

        TableView<Athlete> tableAthlete = new TableView<Athlete>();
        tableAthlete.getStyleClass().addAll("table");

        TableColumn athleteFName = new TableColumn("First Name");
        athleteFName.setCellValueFactory(
                new PropertyValueFactory<Athlete, String>("firstName"));
        athleteFName.getStyleClass().addAll("col");

        TableColumn<Athlete, String> athleteLName = new TableColumn<>("Last Name");
        athleteLName.setCellValueFactory(
                new PropertyValueFactory<Athlete, String>("lastName"));
        athleteLName.getStyleClass().addAll("col");

        tableAthlete.getColumns().addAll(athleteFName, athleteLName);

        //test DELETE ME
        ObservableList<Athlete> data =
                FXCollections.observableArrayList(
                        new Athlete(1, 12, "George", "Kistanza", "m"),
                        new Athlete(1, 12, "George", "Kistanza", "m"),
                        new Athlete(1, 12, "George", "Kistanza", "m"),
                        new Athlete(1, 12, "George", "Kistanza", "m")
        );


        tableAthlete.getItems().addAll(data);
        //end test


        HBox hboxTitle = new HBox();
        hboxTitle.setAlignment(Pos.CENTER);
        hboxTitle.getStyleClass().addAll("hbox");
        hboxTitle.getChildren().addAll(title);

        VBox vboxObs = new VBox();
        vboxObs.getStyleClass().addAll("vbox", "vbox-obs", "vbox-race");
        vboxObs.getChildren().addAll(obsTitle, table);

        VBox vboxButtons = new VBox();
        vboxButtons.getStyleClass().addAll("vbox", "vbox-race", "vbox-buttons");
        vboxButtons.setAlignment(Pos.CENTER);
        vboxButtons.getChildren().addAll(subscribe, unSubscribe);

        VBox vboxAthletes = new VBox();
        vboxAthletes.getStyleClass().addAll("vbox", "vbox-race");
        vboxAthletes.getChildren().addAll(athleteTitle, tableAthlete);

        HBox hboxBody = new HBox();
        hboxBody.getStyleClass().addAll("hbox", "hbox-col-md-4");
        hboxBody.getChildren().addAll(vboxObs, vboxButtons, vboxAthletes);

        VBox vboxBody = new VBox();
        vboxBody.getStyleClass().addAll("vbox", "body");
        vboxBody.getChildren().addAll(hboxTitle, hboxBody);

        // pane width, height
        Scene scene = new Scene(vboxBody, 1000, 700);
        scene.getStylesheets().add("assets/app.css");
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
}
