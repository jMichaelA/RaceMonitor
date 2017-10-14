import Racedata.SimulatedDataSource;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.omg.CORBA.portable.ApplicationException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Race extends Application {
    private String name;
    private String fileName;
    private ArrayList<String> email;
    private DataHandler dataHandler;
    private SimulatedDataSource dataSource;
    private IObserver observer;
    private ObservableList<Athlete> tableData;
    private Scene scene;
    private Stage stage;
    private AthleteTable tableAthlete;
    private TableView table;
    private ArrayList<ObserverType> observerTypes;

    public Race(){
        tableData = FXCollections.observableArrayList();
    }

    public Race(String name, String fileName){
        this.name = name;
        this.fileName = fileName;
        tableData = FXCollections.observableArrayList();
        observerTypes = new ArrayList<>();

        dataSource = new SimulatedDataSource();
        dataHandler = new DataHandler();
        email = new ArrayList();
        dataSource.setInputFilename(fileName);
        dataSource.setHandler(dataHandler);
        try {
            dataSource.Start();
        } catch (Exceptions.ApplicationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        TableColumn athleteFName = new TableColumn("First Name");
        athleteFName.setCellValueFactory(
                new PropertyValueFactory<Athlete, String>("firstName"));
        athleteFName.getStyleClass().addAll("col");


        TableColumn<Athlete, String> athleteLName = new TableColumn<>("Last Name");
        athleteLName.setCellValueFactory(
                new PropertyValueFactory<Athlete, String>("lastName"));
        athleteLName.getStyleClass().addAll("col");

        TableColumn<Athlete, Integer> athleteBibNum = new TableColumn<>("Bibnumber");
        athleteBibNum.setCellValueFactory(
                new PropertyValueFactory<Athlete, Integer>("bibNumber"));
        athleteLName.getStyleClass().addAll("col");

        tableAthlete = new AthleteTable(athleteFName, athleteLName, athleteBibNum);
        tableAthlete.getStyleClass().addAll("table");
        dataHandler.register(tableAthlete);

        table = new TableView();
        table.getStyleClass().addAll("table");

        TableColumn obsName = new TableColumn("Observer");
        obsName.getStyleClass().addAll("col");
        obsName.setCellValueFactory(
                new PropertyValueFactory<ObserverType, String>("name"));

        TableColumn type = new TableColumn("Type");
        type.setCellValueFactory(
                new PropertyValueFactory<ObserverType, String>("type"));
        type.getStyleClass().addAll("col");

        table.getColumns().addAll(obsName, type);

        VBox vboxBody = standard();
        // pane width, height
        scene = new Scene(vboxBody, 1000, 700);
        scene.getStylesheets().add("assets/app.css");
        this.stage.setTitle(name);
        this.stage.setScene(scene);
        this.stage.show();


    }

    private VBox specifyObserver() {
        Text title = new Text("Observer Type");
        title.getStyleClass().addAll("title");

        Text obsName = new Text("Observer Name:       ");
        obsName.getStyleClass().addAll("text-label");

        TextField obsNameIn = new TextField();
        obsNameIn.getStyleClass().addAll("text-field");

        Text obsType = new Text("Observer Type  ");
        obsType.getStyleClass().addAll("text-label");

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "email",
                        "gui"
                );
        ComboBox obsTypeIn = new ComboBox(options);
        obsTypeIn.getStyleClass().addAll("combo");

        Button create = new Button("Create");
        create.getStyleClass().addAll("button");
        create.setOnAction(e -> {
            name = obsNameIn.getText();
            switch(obsTypeIn.getValue().toString()){
                case "email":
                    observer = new Email();
                    break;
                case "gui":
                    observer = new ObserverGui();
                    break;
            }
            observerTypes.add(new ObserverType(name, obsTypeIn.getValue().toString(), observer));
            changeScene(standard());
        });

        HBox hboxTitle = new HBox();
        hboxTitle.getStyleClass().addAll("hbox");
        hboxTitle.getChildren().addAll(title);

        HBox hboxName = new HBox();
        hboxName.getStyleClass().addAll("hbox");
        hboxName.getChildren().addAll(obsName, obsNameIn);

        HBox hboxType = new HBox();
        hboxType.getStyleClass().addAll("hbox");
        hboxType.getChildren().addAll(obsType, obsTypeIn);

        VBox vboxBody = new VBox();
        vboxBody.getStyleClass().addAll("vbox", "body");
        vboxBody.getChildren().addAll(hboxTitle, hboxName, hboxType, create);
        return vboxBody;
    }

    private VBox standard(){
        Text title = new Text("Race Started");
        title.getStyleClass().addAll("title");

        Text obsTitle = new Text("Observers");
        obsTitle.getStyleClass().addAll("sec-title");

        Button addObs = new Button("+");
        addObs.getStyleClass().addAll("button");
        addObs.setOnAction(e -> {
            changeScene(specifyObserver());
        });

        Button subscribe = new Button("sub");
        subscribe.getStyleClass().addAll("button");
        /***TODO implement listener ***/

        Button unSubscribe = new Button("unsub");
        unSubscribe.getStyleClass().addAll("button");
        /***TODO implement listener ***/

        Text athleteTitle = new Text("Athletes");
        athleteTitle.getStyleClass().addAll("sec-title");

        TableView<Athlete> tableObsAthlete = new TableView<Athlete>();
        tableObsAthlete.getStyleClass().addAll("table");

        TableColumn athleteFName2 = new TableColumn("First Name");
        athleteFName2.setCellValueFactory(
                new PropertyValueFactory<Athlete, String>("firstName"));
        athleteFName2.getStyleClass().addAll("col");

        TableColumn<Athlete, String> athleteLName2 = new TableColumn<>("Last Name");
        athleteLName2.setCellValueFactory(
                new PropertyValueFactory<Athlete, String>("lastName"));
        athleteLName2.getStyleClass().addAll("col");

        tableObsAthlete.getColumns().addAll(athleteFName2, athleteLName2);

        for (ObserverType type : observerTypes){
            table.getItems().add(type);
        }

        // Title
        HBox hboxTitle = new HBox();
        hboxTitle.setAlignment(Pos.CENTER);
        hboxTitle.getStyleClass().addAll("hbox");
        hboxTitle.getChildren().addAll(title);

        // observer
        VBox vboxObs = new VBox();
        vboxObs.getStyleClass().addAll("vbox", "vbox-obs", "vbox-race");
        vboxObs.getChildren().addAll(addObs, obsTitle, table);

        // middle col
        VBox vboxButtons = new VBox();
        vboxButtons.getStyleClass().addAll("vbox", "vbox-race", "vbox-buttons");
        vboxButtons.setAlignment(Pos.CENTER);
        vboxButtons.getChildren().addAll(subscribe, unSubscribe);

        // athletes
        VBox vboxAthletes = new VBox();
        vboxAthletes.getStyleClass().addAll("vbox", "vbox-race");
        vboxAthletes.getChildren().addAll(athleteTitle, tableAthlete);

        // main body
        HBox hboxBody = new HBox();
        hboxBody.getStyleClass().addAll("hbox", "hbox-col-md-4");
        hboxBody.getChildren().addAll(vboxObs, vboxButtons, vboxAthletes);

        // lower body
        VBox vboxBody = new VBox();
        vboxBody.getStyleClass().addAll("vbox", "body");
        vboxBody.getChildren().addAll(hboxTitle, hboxBody, tableObsAthlete);

        return vboxBody;
    }

    private void changeScene(VBox vbox){
        scene = new Scene(vbox, 1000, 700);
        scene.getStylesheets().add("assets/app.css");
        stage.setScene(scene);
        this.stage.setTitle(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
