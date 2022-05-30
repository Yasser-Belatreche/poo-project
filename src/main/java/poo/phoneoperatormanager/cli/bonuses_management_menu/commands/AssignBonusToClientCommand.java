package poo.phoneoperatormanager.cli.bonuses_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.bonuses.AdditionalSoldBonus;
import poo.phoneoperatormanager.domain.bonuses.Bonus;
import poo.phoneoperatormanager.domain.bonuses.PhoneCallBonus;
import poo.phoneoperatormanager.domain.bonuses.SMSBonus;
import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;
import poo.phoneoperatormanager.persistence.BonusesStore;
import poo.phoneoperatormanager.persistence.ClientsStore;

import java.text.ParseException;
import java.util.Scanner;

public class AssignBonusToClientCommand implements Command {
    
    @Override
    public void execute() {
        boolean isNotValid = false;
        
        do {
            try {
                Bonus bonus = getBonusFromCLI();
                
                if (!ClientsStore.isExist(bonus.getBeneficiaryNumber().value()))
                    throw new ClientNotExistException();
                
                BonusesStore.save(bonus);
                
                System.out.println("\n Bonus Affected successfully to " + bonus.getBeneficiaryNumber());
                
                isNotValid = false;
            } catch (ClientNotExistException e) {
                System.out.println("\n No client found with the provided phone number.");
                isNotValid = true;
            } catch (InvalidBonusTypeException e) {
                System.out.println("\n Invalid Bonus type, please try again (should be from 1 to 3)");
                isNotValid = true;
            } catch (InvalidPhoneNumberException e) {
                System.out.println("\n Invalid Phone number, please try again (should be dd/mm/yyyy)");
                isNotValid = true;
            } catch (ParseException e) {
                System.out.println("\n Invalid Expiring Date format, please try again (should be dd/mm/yyyy)");
                isNotValid = true;
            }
        } while (isNotValid);
        
    }
    
    private Bonus getBonusFromCLI() throws InvalidBonusTypeException, InvalidPhoneNumberException, ParseException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n Please provide the Bonus information : ");
        
        System.out.print("beneficiary Number : ");
        String beneficiaryNumber = sc.nextLine();
        
        System.out.print("Expiring Date (dd/mm/yyyy) : ");
        String expiringDate = sc.nextLine();
        
        System.out.print("Bonus type (1 - Additional Sold, 2 - Additional Phone Calls, 3 - Additional SMS) : ");
        String bonusType = sc.nextLine();
        
        return getRightBonusType(beneficiaryNumber, expiringDate, bonusType);
    }
    
    private Bonus getRightBonusType(String beneficiaryNumber, String expiringDate, String bonusType) throws InvalidPhoneNumberException, ParseException, InvalidBonusTypeException {
        Scanner sc = new Scanner(System.in);
        
        switch (bonusType) {
            case "1" -> {
                System.out.print("Additional Sold : ");
                return new AdditionalSoldBonus(beneficiaryNumber, expiringDate, Integer.parseInt(sc.nextLine()));
            }
            case "2" -> {
                System.out.print("Number of additional phone call hours : ");
                return new PhoneCallBonus(beneficiaryNumber, expiringDate, Integer.parseInt(sc.nextLine()));
            }
            case "3" -> {
                System.out.print("Number of additional SMS : ");
                return new SMSBonus(beneficiaryNumber, expiringDate, Integer.parseInt(sc.nextLine()));
            }
            default -> throw new InvalidBonusTypeException();
        }
    }
    
    private class InvalidBonusTypeException extends Exception {
    }
}
