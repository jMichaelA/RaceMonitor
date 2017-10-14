import Messages.AthleteUpdate;
import Racedata.IAthleteUpdateHandler;

import java.util.ArrayList;
import java.util.HashMap;


public class DataHandler implements IAthleteUpdateHandler, ISubject{
    private HashMap athletes;
    private ArrayList<IObserver> observer;

    public DataHandler() {
        this.athletes = new HashMap();
        this.observer = new ArrayList<>();
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
        notifyObserver();
//        System.out.println(athleteUpdate.toString());
    }
    @Override
    public void register(IObserver observerAthlete) {
        observer.add(observerAthlete);
    }

    @Override
    public void unRegister(IObserver observerAthlete) {
        observer.remove(observerAthlete);
    }

    @Override
    public void notifyObserver() {
        for (IObserver obs : observer){
            obs.update(athletes);
        }
    }

    // getters and Setters
    public HashMap getAthletes() {
        return athletes;
    }

    public void setAthletes(HashMap athletes) {
        this.athletes = athletes;
    }

}
