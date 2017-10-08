import Exceptions.ApplicationException;
import Racedata.SimulatedDataSource;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        SimulatedDataSource dataSource = new SimulatedDataSource();
        DataHandler dataHandler = new DataHandler();
        ArrayList<String> email = new ArrayList();

        email.add("jacob.m.adams@gmail.com");
        Email eObs = new Email(email, "jacob.m.adams@yahoo.com");
//        eObs.sendEmail("gaspage", "gaspage");

        dataSource.setInputFilename("input/SimulationData/Short Race Simulation-01.csv");
        dataSource.setHandler(dataHandler);
        try {
            dataSource.Start();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
}
