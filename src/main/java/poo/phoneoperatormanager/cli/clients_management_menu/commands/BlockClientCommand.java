package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.client.BlockedClient;
import poo.phoneoperatormanager.domain.client.Client;
import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;
import poo.phoneoperatormanager.persistence.BlockedClientsStore;
import poo.phoneoperatormanager.persistence.ClientsStore;

import java.util.Scanner;

public class BlockClientCommand implements Command {
    
    @Override
    public void execute() {
        try {
            BlockedClient blockedClient = getBlockedClientFromCLI();
            
            Client targetClient = ClientsStore.findByPhoneNumberThrowsIfNotExist(blockedClient.getPhoneNumber().value());
            targetClient.block();
            
            ClientsStore.update(targetClient);
            BlockedClientsStore.save(blockedClient);
            
            System.out.println("\n Client Blocked Successfully.");
        } catch (ClientNotExistException e) {
            System.out.println("\n No client found with the provided number");
        } catch (Exception e) {
            System.out.println("\n Something went wrong, please try again");
        }
        
        
    }
    
    private BlockedClient getBlockedClientFromCLI() throws InvalidPhoneNumberException {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the phone number of the client you wanna block : ");
        String phone = sc.nextLine();
        
        System.out.print("Why you're blocking this number : ");
        String reason = sc.nextLine();
        
        return new BlockedClient(phone, reason);
        
    }
}
