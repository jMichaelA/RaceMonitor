import Messages.AthleteUpdate;
import Racedata.IAthleteUpdateHandler;

import java.util.ArrayList;

public class DataHandler implements IAthleteUpdateHandler, IHandlerSubject{
    private ArrayList<IObserverAthlete> observer;

    public DataHandler(){
        observer = new ArrayList<IObserverAthlete>();
    }

    @Override
    public void ProcessUpdate(AthleteUpdate athleteUpdate) {
        System.out.println(athleteUpdate.toString());
    }

    @Override
    public void register(IObserverAthlete observerAthlete) {
        observer.add(observerAthlete);
    }

    @Override
    public void unRegister(IObserverAthlete observerAthlete) {
        observer.remove(observerAthlete);
    }

    @Override
    public void notifyObserver() {
        for(IObserverAthlete obs : observer){
            obs.update();
        }
    }
}
