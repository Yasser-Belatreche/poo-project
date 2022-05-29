package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.client.Client;
import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.persistence.BlockedClientsStore;
import poo.phoneoperatormanager.persistence.ClientsStore;

import java.util.Scanner;

public class UnBlockClientCommand implements Command {
    
    @Override
    public void execute() {
        String phone = getPhoneNumberFromCli();
        
        try {
            BlockedClientsStore.deleteThrowsIfNotExist(phone);
            
            Client targetClient = ClientsStore.findByPhoneNumberThrowsIfNotExist(phone);
            targetClient.unblock();
            
            ClientsStore.update(targetClient);
            
            System.out.println("\n Client unblocked successfully");
        } catch (ClientNotExistException e) {
            System.out.println("\n No Blocked Client was with the provided phone number");
        } catch (Exception e) {
            System.out.println("\n Something went wrong, please try again");
        }
        
        
    }
    
    private String getPhoneNumberFromCli() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the phone number of the client you wanna unblock : ");
        
        return sc.nextLine();
    }
}
