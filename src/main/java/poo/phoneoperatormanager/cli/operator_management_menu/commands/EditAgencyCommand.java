package poo.phoneoperatormanager.cli.operator_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.operator_management_menu.commands.utils.AgencyTypeIndexMapper;
import poo.phoneoperatormanager.domain.operator.AgencyType;
import poo.phoneoperatormanager.domain.operator.SellAgency;
import poo.phoneoperatormanager.exeptions.AgencyNotExistException;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;
import poo.phoneoperatormanager.exeptions.PhoneNumberAlreadyExistException;
import poo.phoneoperatormanager.persistence.SellAgenciesStore;

import java.util.Scanner;

public class EditAgencyCommand implements Command {
    
    @Override
    public void execute() {
        boolean isNotValid = false;
        
        do {
            try {
                SellAgency targetAgency = getTargetAgency();
                SellAgency editedAgency = getEditedAgencyFromCLI(targetAgency);
                
                SellAgenciesStore.delete(targetAgency);
                SellAgenciesStore.saveThrowsIfAlreadyExist(editedAgency);
                
                System.out.println("\nAgency " + editedAgency.getName() + " edited successfully");
                
                isNotValid = false;
            } catch (InvalidPhoneNumberException e) {
                System.out.println("\n Invalid phone number, please try again");
                isNotValid = true;
            } catch (AgencyNotExistException e) {
                System.out.println("\n No agency found with the provided number");
                isNotValid = true;
            } catch (PhoneNumberAlreadyExistException e) {
                System.out.println("\n Phone number already used by anther agency, please try again");
                isNotValid = true;
            } catch (Exception e) {
                System.out.println("\n Something went wrong, please try again");
                isNotValid = true;
            }
        } while (isNotValid);
        
    }
    
    private SellAgency getTargetAgency() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nPlease provide the phone number of the agency : ");
        String phone = sc.nextLine();
        
        return SellAgenciesStore.getPerPhoneNumberThrowsIfNotExist(phone);
    }
    
    private SellAgency getEditedAgencyFromCLI(SellAgency agency) throws InvalidPhoneNumberException {
        Scanner sc = new Scanner(System.in);
        
        String name = agency.getName();
        String wilaya = agency.getAddress().getWilaya();
        String commun = agency.getAddress().getCommun();
        String phone = agency.getPhoneNumber().value();
        AgencyType type = agency.getType();
        
        System.out.println("\n Provide the new information of the agency : ");
        
        System.out.print("name : (" + name + ") ");
        String value = sc.nextLine();
        if (value.length() > 0)
            name = value;
        
        System.out.print("wilaya : (" + wilaya + ") ");
        value = sc.nextLine();
        if (value.length() > 0)
            wilaya = value;
        
        System.out.print("commun : (" + commun + ") ");
        value = sc.nextLine();
        if (value.length() > 0)
            commun = value;
        
        System.out.print("Phone number : (" + phone + ") ");
        value = sc.nextLine();
        if (value.length() > 0)
            phone = value;
        
        System.out.print("Agency Type (1 - PRIMARY, 2 - SECONDARY) : (" + type + ") ");
        value = sc.nextLine();
        if (value.length() > 0)
            type = AgencyTypeIndexMapper.getTypeOfIndex(value);
        
        return new SellAgency(name, wilaya, commun, phone, type);
    }
}
