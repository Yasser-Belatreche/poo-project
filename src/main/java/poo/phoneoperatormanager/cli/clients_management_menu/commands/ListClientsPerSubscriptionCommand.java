package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.clients_management_menu.commands.utils.SubscriptionsIndexMapper;
import poo.phoneoperatormanager.domain.client.Client;
import poo.phoneoperatormanager.domain.subscription.Subscription;
import poo.phoneoperatormanager.persistence.ClientsStore;

import java.util.ArrayList;
import java.util.Scanner;

public class ListClientsPerSubscriptionCommand implements Command {
    
    @Override
    public void execute() {
        Subscription targetSubscription = getSubscriptionFromCLI();
        ArrayList<Client> clients = ClientsStore.findClientsOfSubscription(targetSubscription);
        
        for (Client client : clients) {
            int index = clients.indexOf(client) + 1;
            System.out.println("\nClient " + index + " : ");
            System.out.println(client);
        }
        
        System.out.println("\n" + clients.size() + " clients of subscription " + targetSubscription + " found");
    }
    
    private Subscription getSubscriptionFromCLI() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Subscription type (1 - forfaitaire, 2 - prepaye, 3 - libre): ");
        
        String subscriptionIndex = sc.nextLine();
        
        return SubscriptionsIndexMapper.getSubscriptionOfIndex(subscriptionIndex);
    }
}
