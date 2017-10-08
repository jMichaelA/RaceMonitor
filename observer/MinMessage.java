import java.util.ArrayList;

public class MinMessage implements AthleteDescription{

    public MinMessage(){

    }

    @Override
    public String getDescription(Athlete athlete) {
        String description = athlete.getFirstName() + " " + athlete.getLastName() + "\nstatus: " + athlete.getCurrentState().getStatus().toString();
        description += "\nDate Time: " + athlete.getCurrentState().getDateTime();

        if(athlete.getCurrentState().getMeters() != null){
            description +="\nMeters: " + athlete.getCurrentState().getMeters();
        }

        return description;
    }

}
