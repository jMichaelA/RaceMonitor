
import Messages.AthleteUpdate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Register implements ProcessBehavior {

    public Register(){

    }

    @Override
    public HashMap process(HashMap<Integer, Athlete> athletes, AthleteUpdate athleteUpdate) {
        String str = athleteUpdate.toString();
        List<String> athleteData = Arrays.asList(str.split(","));
        Integer age = Integer.parseInt(athleteData.get(6).trim());
        String firstName = athleteData.get(3);
        String lastName = athleteData.get(4);
        String gender = athleteData.get(5);
        State state = new State(athleteUpdate.getUpdateType(), athleteUpdate.getTimestamp());

        Athlete tempAthlete = new Athlete(athleteUpdate.getBibNumber(), age, firstName, lastName, gender, state);

        athletes.put(athleteUpdate.getBibNumber(), tempAthlete);

        return athletes;
    }
}
