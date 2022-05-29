package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.client.BlockedClient;
import poo.phoneoperatormanager.persistence.BlockedClientsStore;

import java.util.Collection;

public class ListBlockedClientsCommand implements Command {
    
    @Override
    public void execute() {
        Collection<BlockedClient> blockedClients = BlockedClientsStore.findAll();
        
        int counter = 1;
        for (BlockedClient blockedClient : blockedClients) {
            System.out.println("\nClient " + counter++ + " : ");
            System.out.println(blockedClient);
        }
        
        System.out.println("\n" + blockedClients.size() + " blocked clients found");
    }
}
