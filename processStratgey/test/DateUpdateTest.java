import Messages.AthleteUpdate;
import Messages.FinishedUpdate;
import Messages.LocationUpdate;
import Messages.RegistrationUpdate;
import Racedata.AthleteRaceStatus;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.Assert.*;


public class DateUpdateTest {
    @Test
    public void process() throws Exception {
        Integer bibNumber = 1;
        Integer age = 3;
        String date = "8/15/2017 7:00:00 AM";
        String firstName = "gasp";
        String lastName = "gaspl";
        String gender = "m";
        Integer meters = 2253;
        LocalDateTime local = LocalDateTime.now();
        ProcessBehavior dateUpdate = new DateUpdate();

        String[] data = {"Finished",bibNumber.toString(),date, date};
        AthleteUpdate update = new FinishedUpdate(data);
        Athlete athlete = new Athlete(1, age, firstName, lastName, gender);
        athlete.setCurrentState(new State(AthleteRaceStatus.ConvertFrom("Registered"), local));
        HashMap<Integer, Athlete> athletes = new HashMap<>();
        athletes.put(bibNumber, athlete);

        athletes = dateUpdate.process(athletes, update);
        assertEquals(athletes.get(bibNumber).getBibNumber(), bibNumber);
        assertNotEquals(athletes.get(bibNumber).getCurrentState().getStatus().toString(), "Registered");
        assertEquals(athletes.get(bibNumber).getCurrentState().getStatus().toString(), "Finished");
        assertNotEquals(athletes.get(bibNumber).getCurrentState().getDateTime(), local);
    }

}