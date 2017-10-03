import Messages.AthleteUpdate;
import Racedata.IAthleteUpdateHandler;

public class DataHandler implements IAthleteUpdateHandler {
    public DataHandler(){

    }

    @Override
    public void ProcessUpdate(AthleteUpdate athleteUpdate) {
        System.out.println(athleteUpdate.toString());
    }
}
