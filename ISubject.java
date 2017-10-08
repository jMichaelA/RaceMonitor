public interface ISubject {
    void register(IObserver observerAthlete);
    void unRegister(IObserver observerAthlete);
    void notifyObserver();
}
