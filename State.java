import Racedata.AthleteRaceStatus;

import java.time.LocalDateTime;

public class State {
    private AthleteRaceStatus status;
    private LocalDateTime dateTime;
    private Double meters;

    public State(AthleteRaceStatus status, LocalDateTime dateTime, Double meters) {
        this.status = status;
        this.dateTime = dateTime;
        this.meters = meters;
    }

    public State(AthleteRaceStatus status, LocalDateTime dateTime) {
        this.status = status;
        this.dateTime = dateTime;
    }

    public AthleteRaceStatus getStatus() {
        return status;
    }

    public void setStatus(AthleteRaceStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Double getMeters() {
        return meters;
    }

    public void setMeters(Double meters) {
        this.meters = meters;
    }
}
