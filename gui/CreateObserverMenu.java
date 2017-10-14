import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateObserverMenu extends Application {
    private IObserver obs;
    private String name;

    public CreateObserverMenu(){
        this.obs = new Email();
        this.name = "";
    }

    @Override
    public void start(Stage stage) throws Exception {

    }



    public IObserver getObs() {
        return obs;
    }

    public void setObs(IObserver obs) {
        this.obs = obs;
    }
}
