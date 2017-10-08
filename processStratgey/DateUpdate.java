
import Messages.AthleteUpdate;

import java.util.HashMap;

public class DateUpdate implements ProcessBehavior {
    public DateUpdate() {

    }

    @Override
    public HashMap process(HashMap<Integer, Athlete> athletes, AthleteUpdate athleteUpdate) {
        State state = new State(athleteUpdate.getUpdateType(), athleteUpdate.getTimestamp());
        athletes.get(athleteUpdate.getBibNumber()).setCurrentState(state);
        return athletes;
    }
}
