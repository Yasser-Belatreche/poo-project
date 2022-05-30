package poo.phoneoperatormanager.domain.operator;

import poo.phoneoperatormanager.exeptions.InvalidPercentageException;

public class CoveringPercentage {
    
    private String wilaya;
    private Percentage percentage;
    
    public CoveringPercentage(String wilaya, double percentage) throws InvalidPercentageException {
        this.wilaya = wilaya;
        this.percentage = new Percentage(percentage);
    }
    
    public String getWilaya() {
        return wilaya;
    }
    
    public Percentage getPercentage() {
        return percentage;
    }
    
    @Override
    public String toString() {
        return "\n Wilaya     : " + wilaya +
                "\n Percentage : " + percentage;
    }
}
