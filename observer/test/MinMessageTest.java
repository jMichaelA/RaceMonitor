import Racedata.AthleteRaceStatus;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class MinMessageTest {
    @Test
    public void getDescription() throws Exception {
        Integer age = 54;
        String firstName = "gaspf";
        String lastName = "gaspl";
        String gender = "m";
        Athlete athlete = new Athlete(1, age, firstName, lastName, gender);
        athlete.setCurrentState(new State(AthleteRaceStatus.ConvertFrom("Registered"), LocalDateTime.now()));

        MinMessage minMessage = new MinMessage();

        String expected = athlete.getFirstName() + " " + athlete.getLastName() + "\nstatus: " + athlete.getCurrentState().getStatus().toString();
        expected += "\nDate Time: " + athlete.getCurrentState().getDateTime();

        assertEquals(minMessage.getDescription(athlete), expected);
    }

    @Test
    public void getDescriptionMeters() throws Exception {
        Integer age = 54;
        String firstName = "gaspf";
        String lastName = "gaspl";
        String gender = "m";
        Athlete athlete = new Athlete(1, age, firstName, lastName, gender);
        athlete.setCurrentState(new State(AthleteRaceStatus.ConvertFrom("Oncourse"), LocalDateTime.now(), 2333.4));

        MinMessage minMessage = new MinMessage();

        String expected = athlete.getFirstName() + " " + athlete.getLastName() + "\nstatus: " + athlete.getCurrentState().getStatus().toString();
        expected += "\nDate Time: " + athlete.getCurrentState().getDateTime();
        expected +="\nMeters: " + athlete.getCurrentState().getMeters();

        assertEquals(minMessage.getDescription(athlete), expected);
    }

}