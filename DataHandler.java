import Messages.AthleteUpdate;
import Racedata.IAthleteUpdateHandler;

import java.util.HashMap;


public class DataHandler implements IAthleteUpdateHandler{
    private HashMap athletes;

    public DataHandler() {
        this.athletes = new HashMap();
    }

    @Override
    public void ProcessUpdate(AthleteUpdate athleteUpdate) {
        ProcessBehavior processBehavior;

        switch(athleteUpdate.getUpdateType().toString().toLowerCase()){
            case "registered":
                processBehavior = new Register();
                break;
            case "started":
                processBehavior = new DateUpdate();
                break;
            case "didnotstart":
                processBehavior = new DateUpdate();
                break;
            case "didnotfinish":
                processBehavior = new DateUpdate();
                break;
            case "finished":
                processBehavior = new DateUpdate();
                break;
            case "oncourse":
                processBehavior = new CourseUpdate();
                break;

            default:
                throw new java.lang.RuntimeException("New athlete update type, please updated code for: " + athleteUpdate.getUpdateType().toString());

        }
        athletes = processBehavior.process(athletes, athleteUpdate);

        // test
        Athlete ath = (Athlete) athletes.get(1);
//        System.out.println(athleteUpdate.toString());
    }

    // getters and Setters
    public HashMap getAthletes() {
        return athletes;
    }

    public void setAthletes(HashMap athletes) {
        this.athletes = athletes;
    }
}
