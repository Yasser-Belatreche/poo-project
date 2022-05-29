package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.clients_management_menu.commands.utils.SubscriptionsIndexMapper;
import poo.phoneoperatormanager.domain.client.Client;
import poo.phoneoperatormanager.domain.subscription.Subscription;
import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.persistence.ClientsStore;

import java.util.ArrayList;
import java.util.Scanner;

public class GetClientPerPhoneNumberCommand implements Command {
    
    @Override
    public void execute() {
        String targetPhone = getPhoneNumberFromCLI();
        Client client = ClientsStore.findByPhoneNumber(targetPhone);
        
        if (client == null)
            System.out.println("\n No Client found with that phone number");
        else
            System.out.println(client);
    }
    
    private String getPhoneNumberFromCLI() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Phone number of the target client : ");
        
        return sc.nextLine();
    }
}
