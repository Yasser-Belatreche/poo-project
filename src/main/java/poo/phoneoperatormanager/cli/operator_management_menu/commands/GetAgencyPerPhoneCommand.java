package poo.phoneoperatormanager.cli.operator_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.operator.SellAgency;
import poo.phoneoperatormanager.exeptions.AgencyNotExistException;
import poo.phoneoperatormanager.persistence.SellAgenciesStore;

import java.util.Scanner;

public class GetAgencyPerPhoneCommand implements Command {
    @Override
    public void execute() {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.print("\n The phone number of the target agency : ");
            
            SellAgency agency = SellAgenciesStore.getPerPhoneNumberThrowsIfNotExist(sc.nextLine());
            
            System.out.println(agency);
        } catch (AgencyNotExistException e) {
            System.out.println("\n No agency found.");
        } catch (Exception e) {
            System.out.println("\n Something went wrong, please try again");
        }
    }
}
