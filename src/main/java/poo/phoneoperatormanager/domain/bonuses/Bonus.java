package poo.phoneoperatormanager.domain.bonuses;

import poo.phoneoperatormanager.domain.common.PhoneNumber;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bonus {
    
    private final PhoneNumber beneficiaryNumber;
    private final Date expiresAt;
    
    public Bonus(String beneficiaryNumber, String expiringDate) throws InvalidPhoneNumberException, ParseException {
        this.beneficiaryNumber = new PhoneNumber(beneficiaryNumber);
        this.expiresAt = new SimpleDateFormat("dd/MM/yyyy").parse(expiringDate);
    }
    
    public PhoneNumber getBeneficiaryNumber() {
        return beneficiaryNumber;
    }
    
    public Date getExpiringDate() {
        return expiresAt;
    }
    
    @Override
    public String toString() {
        return "\n Beneficiary Number : " + beneficiaryNumber +
                "\n Expired at         : " + new SimpleDateFormat("dd/MM/yyyy").format(expiresAt);
    }
}
