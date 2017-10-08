
public class PrevStateDec extends AthleteDescDec{
    public PrevStateDec(AthleteDescription description) {
        super(description);
    }

    @Override
    public String getDescription(Athlete athlete) {
        String desc = tempDesc.getDescription(athlete);
        if(athlete.getPastState().size() < 1){
            return desc;
        }

        State pastState = athlete.getPastState().get(athlete.getPastState().size()-1);
        desc += "\nPrevious State:\n    Status: " + pastState.getStatus().toString();
        desc += "\n    DateTime: " + pastState.getDateTime();
        if(pastState.getMeters() != null){
            desc += "\n    Meters: " + pastState.getMeters();
        }

        return desc;
    }
}
