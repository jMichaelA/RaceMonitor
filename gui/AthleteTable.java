import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.HashMap;

public class AthleteTable extends TableView implements IObserver {
    private TableColumn<Athlete, String> athleteLName;
    private TableColumn<Athlete, String> athleteFName;
    private TableColumn<Athlete, Integer> bibNumber;

    public AthleteTable(TableColumn<Athlete, String> athleteLName, TableColumn<Athlete, String> athleteFName, TableColumn<Athlete, Integer> bibNumber) {
        this.athleteLName = athleteLName;
        this.athleteFName = athleteFName;
        this.bibNumber = bibNumber;
        this.getColumns().addAll(bibNumber, athleteFName, athleteLName);
    }

    public AthleteTable(ObservableList items, TableColumn<Athlete, String> athleteLName, TableColumn<Athlete, String> athleteFName, TableColumn<Athlete, Integer> bibNumber) {
        super(items);
        this.athleteLName = athleteLName;
        this.athleteFName = athleteFName;
        this.bibNumber = bibNumber;
        this.getColumns().addAll(bibNumber, athleteFName, athleteLName);
    }

    @Override
    public void update(Athlete athlete) {

    }

    @Override
    public void update(HashMap<Integer, Athlete> athlete) {
        boolean found = false;
        ObservableList<Athlete> data = FXCollections.observableArrayList();

        for (Integer key : athlete.keySet()) {
            found = false;
            for (Object o : this.getItems()) {
                if (athlete.get(key).getBibNumber() == bibNumber.getCellData((Athlete) o).intValue()){
                    found = true;
                }
            }
            if(!found){
                data.add(athlete.get(key));
            }
        }
        this.getItems().addAll(data);
    }
}
