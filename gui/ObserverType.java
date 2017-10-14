import java.util.HashMap;

public class ObserverType {
    private String name;
    private String type;
    private IObserver observer;

    public ObserverType(String name, String type, IObserver observer) {
        this.name = name;
        this.type = type;
        this.observer = observer;
    }

    public void update(Athlete ath){
        observer.update(ath);
    }

    public void update(HashMap<Integer, Athlete> ath){
        observer.update(ath);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public IObserver getObserver() {
        return observer;
    }

    public void setObserver(IObserver observer) {
        this.observer = observer;
    }
}
