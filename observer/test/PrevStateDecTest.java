import Racedata.AthleteRaceStatus;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PrevStateDecTest {
    @Test
    public void getDescription() throws Exception {
        Integer age = 54;
        String firstName = "gaspf";
        String lastName = "gaspl";
        String gender = "m";
        Athlete athlete = new Athlete(1, age, firstName, lastName, gender);

        athlete.setCurrentState(new State(AthleteRaceStatus.ConvertFrom("Registered"), LocalDateTime.now()));
        athlete.setCurrentState(new State(AthleteRaceStatus.ConvertFrom("OnCourse"), LocalDateTime.now(), 23.43));

        MinMessage minMessage = new MinMessage();
        State pastState = athlete.getPastState().get(athlete.getPastState().size()-1);

        String expected = minMessage.getDescription(athlete) + athlete.getPastState().get(athlete.getPastState().size()-1);
        expected += "\nPrevious State:\n    Status: " + pastState.getStatus().toString();
        expected += "\n    DateTime: " + pastState.getDateTime();

        AthleteDescDec message = new PrevStateDec(minMessage);
        assertEquals(message.getDescription(athlete), expected);
    }

}