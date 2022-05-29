package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import java.util.Scanner;
import java.text.ParseException;

import poo.phoneoperatormanager.cli.Command;

import poo.phoneoperatormanager.domain.client.Client;

import poo.phoneoperatormanager.persistence.ClientsStore;

import poo.phoneoperatormanager.exeptions.InvalidEmailException;
import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;


public class EditClientCommand implements Command {
    
    @Override
    public void execute() {
        boolean isNotValid = false;
        
        do {
            try {
                Client client = getTargetClient();
                Client editedClient = getEditedClientInfoFromCli(client);
                ClientsStore.updateThrowsIfNotExist(editedClient);
                
                System.out.println("\n Client edited successfully.");
                
                isNotValid = false;
            } catch (ClientNotExistException e) {
                System.out.println("\n No Client found with this number.");
            } catch (InvalidPhoneNumberException e) {
                System.out.println("\n Invalid phone number, please try again.");
                isNotValid = true;
            } catch (ParseException e) {
                System.out.println("\n Invalid Date Format, please try again.");
                isNotValid = true;
            } catch (InvalidEmailException e) {
                System.out.println("\n Invalid Email, please try again.");
                isNotValid = true;
            }
        } while (isNotValid);
        
    }
    
    private Client getTargetClient() throws ClientNotExistException {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nThe phone number of the client you wanna edit : ");
        String phone = sc.nextLine();
        
        return ClientsStore.findByPhoneNumberThrowsIfNotExist(phone);
    }
    
    private Client getEditedClientInfoFromCli(Client client) throws InvalidPhoneNumberException, ParseException, InvalidEmailException {
        String firstName = client.getFirstName();
        String lastName = client.getLastName();
        String email = client.getEmail().value();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n Please Provide the new client information : ");
        
        System.out.print("First name : (" + firstName + ") ");
        String value = sc.nextLine();
        
        if (value.length() > 0)
            firstName = value;
        
        System.out.print("Last name : (" + lastName + ") ");
        value = sc.nextLine();
        
        if (value.length() > 0)
            lastName = value;
        
        System.out.print("Email : (" + email + ") ");
        value = sc.nextLine();
        
        if (value.length() > 0)
            email = value;
        
        return new Client(
                firstName,
                lastName,
                email,
                client.getAddress().getWilaya(),
                client.getAddress().getCommun(),
                client.getPhoneNumber().value(),
                client.getSubscription(),
                client.getContractNumber(),
                client.getContractDate().toString(),
                client.isBlocked()
        );
        
    }
}
