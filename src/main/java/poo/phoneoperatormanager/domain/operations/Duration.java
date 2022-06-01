package poo.phoneoperatormanager.domain.operations;

import poo.phoneoperatormanager.exeptions.InvalidDurationFormatException;
import poo.phoneoperatormanager.exeptions.MinutesOutOfRangeException;
import poo.phoneoperatormanager.exeptions.SecondsOutOfRangeException;

import java.text.DecimalFormat;

public class Duration {
    
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    
    public Duration(String duration) throws InvalidDurationFormatException {
        String[] chunks = duration.split(":");
        
        if (chunks.length != 3)
            throw new InvalidDurationFormatException();
        
        this.hours = Integer.parseInt(chunks[0]);
        setMinutes(Integer.parseInt(chunks[1]));
        setSeconds(Integer.parseInt(chunks[2]));
    }
    
    public Duration(int hours, int minutes, int seconds) {
        this.hours = hours;
        setMinutes(minutes);
        setSeconds(seconds);
    }
    
    
    public int getHours() {
        return hours;
    }
    
    public int getMinutes() {
        return minutes;
    }
    
    public int getSeconds() {
        return seconds;
    }
    
    public void incrementBy(Duration duration) {
        addHours(duration.getHours());
        addMinutes(duration.getMinutes());
        addSeconds(duration.getSeconds());
    }
    
    private void addHours(int hours) {
        this.hours += hours;
    }
    
    private void addMinutes(int minutesToAdd) {
        if (this.minutes + minutesToAdd > 59) {
            addHours(1);
            this.minutes += minutesToAdd - 60;
        } else {
            this.minutes += minutesToAdd;
        }
    }
    
    private void addSeconds(int secondsToAdd) {
        if (this.seconds + secondsToAdd > 59) {
            addMinutes(1);
            this.seconds += secondsToAdd - 60;
        } else {
            this.seconds += secondsToAdd;
        }
    }
    
    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59)
            throw new MinutesOutOfRangeException();
        
        this.minutes = minutes;
    }
    
    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59)
            throw new SecondsOutOfRangeException();
        
        this.seconds = seconds;
    }
    
    public double toMinutes() {
        int minutesInHours = hours * 60;
        double minutesInSeconds = Double.parseDouble(new DecimalFormat("##.##").format(seconds / 60));
        
        return minutesInHours + minutes + minutesInSeconds;
    }
    
    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
