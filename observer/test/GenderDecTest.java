import Racedata.AthleteRaceStatus;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class GenderDecTest {

    @Test
    public void getDescription() throws Exception {
        Integer age = 54;
        String firstName = "gaspf";
        String lastName = "gaspl";
        String gender = "m";
        Athlete athlete = new Athlete(1, age, firstName, lastName, gender);
        athlete.setCurrentState(new State(AthleteRaceStatus.ConvertFrom("Registered"), LocalDateTime.now()));
        MinMessage minMessage = new MinMessage();
        String expected = minMessage.getDescription(athlete) + "\nGender: " + athlete.getGender();
        AthleteDescDec message = new GenderDec(minMessage);
        assertEquals(message.getDescription(athlete), expected);
    }

}