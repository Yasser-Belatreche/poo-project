package poo.phoneoperatormanager.domain.bonuses;

import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

import java.text.ParseException;

public class PhoneCallBonus extends Bonus {
    
    final private int numOfHours;
    
    public PhoneCallBonus(String beneficiaryNumber, String expiringDate, int numOfHours) throws InvalidPhoneNumberException, ParseException {
        super(beneficiaryNumber, expiringDate);
        this.numOfHours = numOfHours;
    }
    
    public int getNumOfHours() {
        return numOfHours;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\n Number Of Hours    : " + numOfHours;
    }
}
