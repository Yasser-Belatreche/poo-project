package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.client.Client;
import poo.phoneoperatormanager.persistence.ClientsStore;

import java.util.ArrayList;
import java.util.Scanner;

public class ListClientsPerWilayaCommand implements Command {
    
    @Override
    public void execute() {
        String targetWilaya = getWilayaFromCLI();
        ArrayList<Client> clients = ClientsStore.findClientsOfWilaya(targetWilaya);
        
        for (Client client : clients) {
            int index = clients.indexOf(client) + 1;
            System.out.println("\nClient " + index + " : ");
            System.out.println(client);
        }
        
        System.out.println("\n" + clients.size() + " clients in wilaya " + targetWilaya + " found.");
    }
    
    private String getWilayaFromCLI() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Wilaya : ");
        
        return sc.nextLine().toLowerCase();
    }
}
