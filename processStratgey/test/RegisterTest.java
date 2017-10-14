import Messages.AthleteUpdate;
import Messages.RegistrationUpdate;
import Racedata.AthleteRaceStatus;

import java.util.HashMap;

import static org.junit.Assert.*;

public class RegisterTest {
    @org.junit.Test
    public void process() throws Exception {
        Integer bibNumber = 1;
        Integer age = 3;
        String firstName = "gaspf";
        String lastName = "gaspl";
        String gender = "m";
        String date = "8/15/2017 7:00:00 AM";
        ProcessBehavior register = new Register();

        String[] data = {"Registered",bibNumber.toString(),date,firstName,lastName,gender,age.toString()};
        AthleteUpdate update = new RegistrationUpdate(data);
        HashMap<Integer, Athlete> athletes = new HashMap<>();

        athletes = register.process(athletes, update);
        assertEquals(athletes.get(bibNumber).getBibNumber(), bibNumber);
        assertEquals(athletes.get(bibNumber).getAge(), age);
        assertEquals(athletes.get(bibNumber).getGender(), gender);
        assertEquals(athletes.get(bibNumber).getLastName(), lastName);
        assertEquals(athletes.get(bibNumber).getFirstName(), firstName);
        assertEquals(athletes.get(bibNumber).getCurrentState().getStatus().toString(), "Registered");
    }

}