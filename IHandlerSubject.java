public interface IHandlerSubject {
    void register(IObserverAthlete observerAthlete);
    void unRegister(IObserverAthlete observerAthlete);
    void notifyObserver();
}
