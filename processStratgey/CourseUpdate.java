
import Messages.AthleteUpdate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CourseUpdate implements ProcessBehavior {
    public CourseUpdate(){

    }

    @Override
    public HashMap process(HashMap<Integer, Athlete> athletes, AthleteUpdate athleteUpdate) {
        String str = athleteUpdate.toString();
        List<String> athleteData = Arrays.asList(str.split(","));

        State state = new State(athleteUpdate.getUpdateType(), athleteUpdate.getTimestamp(), Double.parseDouble(athleteData.get(3)));
        athletes.get(athleteUpdate.getBibNumber()).setCurrentState(state);
        return athletes;
    }
}
