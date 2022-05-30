package poo.phoneoperatormanager.domain.bonuses;

import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

import java.text.ParseException;

public class AdditionalSoldBonus extends Bonus {
    
    private final int additionalSold;
    
    public AdditionalSoldBonus(String beneficiaryNumber, String expiringDate, int additionalSold) throws InvalidPhoneNumberException, ParseException {
        super(beneficiaryNumber, expiringDate);
        this.additionalSold = additionalSold;
    }
    
    public int getAdditionalSold() {
        return additionalSold;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n Additional Sold    : " + additionalSold;
    }
}
