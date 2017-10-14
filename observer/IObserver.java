import java.util.ArrayList;
import java.util.HashMap;

public interface IObserver {
    void update(Athlete athlete);
    void update(HashMap<Integer, Athlete> athlete);
}
