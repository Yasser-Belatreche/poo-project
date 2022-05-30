package poo.phoneoperatormanager.cli.operator_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.operator_management_menu.commands.utils.AgencyTypeIndexMapper;
import poo.phoneoperatormanager.domain.operator.SellAgency;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;
import poo.phoneoperatormanager.exeptions.PhoneNumberAlreadyExistException;
import poo.phoneoperatormanager.persistence.SellAgenciesStore;

import java.util.Scanner;

public class AddAgencyCommand implements Command {
    
    @Override
    public void execute() {
        boolean isNotValid = false;
        
        do {
            try {
                SellAgency agency = getSellAgencyFromCLI();
                SellAgenciesStore.saveThrowsIfAlreadyExist(agency);
                
                System.out.println("\nAgency with phone " + agency.getPhoneNumber() + " added successfully");
                
                isNotValid = false;
            } catch (InvalidPhoneNumberException e) {
                System.out.println("\n Invalid phone number, please try again.");
                isNotValid = true;
            } catch (PhoneNumberAlreadyExistException e) {
                System.out.println("\n Phone number already used, please try with another number");
                isNotValid = true;
            } catch (Exception e) {
                System.out.println("\n Something went wrong, please try again.");
                isNotValid = true;
            }
        } while (isNotValid);
    }
    
    private SellAgency getSellAgencyFromCLI() throws InvalidPhoneNumberException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nPlease provide the agency information : ");
        
        System.out.print("name : ");
        String name = sc.nextLine();
        
        System.out.print("wilaya : ");
        String wilaya = sc.nextLine();
        
        System.out.print("commun : ");
        String commun = sc.nextLine();
        
        System.out.print("phone number : ");
        String phoneNumber = sc.nextLine();
        
        System.out.print("agency type (1 - primary, 2 - secondary) : ");
        String typeIndex = sc.nextLine();
        
        return new SellAgency(name, wilaya, commun, phoneNumber, AgencyTypeIndexMapper.getTypeOfIndex(typeIndex));
    }
}
