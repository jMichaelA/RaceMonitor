import Exceptions.ApplicationException;
import Racedata.SimulatedDataSource;

public class Main {
    public static void main(String[] args){
        SimulatedDataSource dataSource = new SimulatedDataSource();
        DataHandler dataHandler = new DataHandler();

        dataSource.setInputFilename("input/SimulationData/Short Race Simulation-01.csv");
        dataSource.setHandler(dataHandler);
        try {
            dataSource.Start();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
}
