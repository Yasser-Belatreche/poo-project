package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.persistence.ClientsStore;

import java.util.Scanner;

public class DeleteClientCommand implements Command {
    @Override
    public void execute() {
        try {
            String phoneNumber = getPhoneNumberFromCli();
            ClientsStore.deleteThrowsIfNotExist(phoneNumber);
            
            System.out.println("\n Client deleted successfully");
        } catch (ClientNotExistException e) {
            System.out.println("\n No client found with this phone number");
        }
    }
    
    private String getPhoneNumberFromCli() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the phone number of the client you wanna delete : ");
        
        return sc.nextLine();
    }
}
