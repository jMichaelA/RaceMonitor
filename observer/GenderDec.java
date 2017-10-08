
public class GenderDec extends AthleteDescDec{

    public GenderDec(AthleteDescription description) {
        super(description);
    }

    @Override
    public String getDescription(Athlete athlete) {
        return tempDesc.getDescription(athlete) + "\nGender: " + athlete.getGender();
    }
}
