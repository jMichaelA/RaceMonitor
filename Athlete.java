import java.util.ArrayList;

public class Athlete implements ISubject{
    private Integer bibNumber;
    private Integer age;
    private String firstName;
    private String lastName;
    private String gender;
    private State currentState;
    private ArrayList<State> pastState;
    private ArrayList<IObserver> observer;

    public Athlete(Integer bibNumber, Integer age, String firstName, String lastName, String gender) {
        this.bibNumber = bibNumber;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;

        observer = new ArrayList<>();
        pastState = new ArrayList<>();
    }

    public Athlete(Integer bibNumber, Integer age, String firstName, String lastName, String gender, State state) {
        this.bibNumber = bibNumber;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.currentState = state;

        observer = new ArrayList<>();
        pastState = new ArrayList<>();
    }

    @Override
    public void register(IObserver observerAthlete) {
        observer.add(observerAthlete);
    }

    @Override
    public void unRegister(IObserver observerAthlete) {
        observer.remove(observerAthlete);
    }

    @Override
    public void notifyObserver() {
        for (IObserver obs : observer){
            obs.update(this);
        }
    }

    /* Getters and setters */

    public void setCurrentState(State currentState) {
        pastState.add(this.currentState);
        this.currentState = currentState;
    }

    public ArrayList<State> getPastState() {
        return pastState;
    }

    public Integer getBibNumber() {
        return bibNumber;
    }

    public void setBibNumber(Integer bibNumber) {
        this.bibNumber = bibNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setPastState(ArrayList<State> pastState) {
        this.pastState = pastState;
    }
}
