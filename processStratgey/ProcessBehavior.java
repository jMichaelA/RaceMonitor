

import Messages.AthleteUpdate;

import java.util.HashMap;

public interface ProcessBehavior {

    HashMap process(HashMap<Integer, Athlete> athletes, AthleteUpdate athleteUpdate);
}
