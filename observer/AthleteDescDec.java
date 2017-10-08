
public abstract class AthleteDescDec implements AthleteDescription{
    protected AthleteDescription tempDesc;

    public AthleteDescDec(AthleteDescription description){
        tempDesc = description;
    }

    public AthleteDescription getDesc() {
        return tempDesc;
    }

    public void setDesc(AthleteDescription tempDesc) {
        this.tempDesc = tempDesc;
    }
}
