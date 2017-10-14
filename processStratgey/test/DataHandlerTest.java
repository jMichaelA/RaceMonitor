import Messages.AthleteUpdate;
import Messages.LocationUpdate;
import Racedata.AthleteRaceStatus;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DataHandlerTest {
    private IObserver observer;
    private DataHandler dataHandler;

    public DataHandlerTest(){
        observer = new Email();
        dataHandler = new DataHandler();
    }

    @Test
    public void register() throws Exception {
        dataHandler.register(observer);

        for(IObserver obs : dataHandler.getObserver()){
            if(obs == observer){
                assertEquals(1, 1);
                return;
            }
        }
        assertEquals(0, 1);
    }

    @Test
    public void unRegister() throws Exception {
        IObserver email = new Email();
        dataHandler.register(email);
        dataHandler.unRegister(email);

        for(IObserver obs : dataHandler.getObserver()){
            if(obs == email){
                assertEquals(1, 0);
            }
        }
    }

}