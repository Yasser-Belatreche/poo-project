package poo.phoneoperatormanager.cli.operator_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.exeptions.AgencyNotExistException;
import poo.phoneoperatormanager.persistence.SellAgenciesStore;

import java.util.Scanner;

public class DeleteAgencyCommand implements Command {
    
    @Override
    public void execute() {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.print("\n Please provide the phone number of the agency you wanna delete : ");
            String phone = sc.nextLine();
            
            SellAgenciesStore.deleteThrowsIfNotExist(phone);
            
            System.out.println("\n Agency deleted successfully");
        } catch (AgencyNotExistException e) {
            System.out.println("\n No agency found with the provided phone number");
        } catch (Exception e) {
            System.out.println("\n Something went wrong, please try again");
        }
    }
}
