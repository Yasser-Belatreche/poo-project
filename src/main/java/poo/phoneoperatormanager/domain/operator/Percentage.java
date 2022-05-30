package poo.phoneoperatormanager.domain.operator;

import poo.phoneoperatormanager.exeptions.InvalidPercentageException;

public class Percentage {
    private double value;
    
    public Percentage(double value) throws InvalidPercentageException {
        if (value < 0 || value > 100)
            throw new InvalidPercentageException();
        
        this.value = value;
    }
    
    public double value() {
        return value;
    }
    
    @Override
    public String toString() {
        return value + "%";
    }
}
