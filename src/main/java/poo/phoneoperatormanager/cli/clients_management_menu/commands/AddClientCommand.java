package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.clients_management_menu.commands.utils.SubscriptionsIndexMapper;
import poo.phoneoperatormanager.domain.client.Client;
import poo.phoneoperatormanager.exeptions.InvalidEmailException;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;
import poo.phoneoperatormanager.exeptions.PhoneNumberAlreadyExistException;
import poo.phoneoperatormanager.persistence.ClientsStore;

import java.text.ParseException;
import java.util.Scanner;

public class AddClientCommand implements Command {
    @Override
    public void execute() {
        boolean isNotValid = false;
        
        do {
            try {
                Client client = getClientFromCLI();
                ClientsStore.saveThrowsIfAlreadyExist(client);
                System.out.println("\n Client " + client.getFirstName() + " added successfully");
                
                isNotValid = false;
            } catch (InvalidPhoneNumberException e) {
                System.out.println("\n Invalid phone number, please try again.");
                isNotValid = true;
            } catch (ParseException e) {
                System.out.println("\n Invalid Date Format, please try again.");
                isNotValid = true;
            } catch (InvalidEmailException e) {
                System.out.println("\n Invalid Email, please try again.");
                isNotValid = true;
            } catch (PhoneNumberAlreadyExistException e) {
                System.out.println("this Phone number is already used, please try again");
                isNotValid = true;
            }
        } while (isNotValid);
        
    }
    
    private Client getClientFromCLI() throws InvalidPhoneNumberException, ParseException, InvalidEmailException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n Please Provide the client information : ");
        
        System.out.print("First name : ");
        String firstName = sc.nextLine();
        
        System.out.print("Last name : ");
        String lastName = sc.nextLine();
        
        System.out.print("email : ");
        String email = sc.nextLine();
        
        System.out.print("Wilaya : ");
        String wilaya = sc.nextLine();
        
        System.out.print("Commun : ");
        String commun = sc.nextLine();
        
        System.out.print("Phone Number : ");
        String phoneNumber = sc.nextLine();
        
        System.out.print("Subscription type (1 - forfaitaire, 2 - prepaye, 3 - libre): ");
        String subscriptionTypeIndex = sc.nextLine();
        
        System.out.print("Contract Number : ");
        String contractNumber = sc.nextLine();
        
        System.out.print("Contract Date (dd/mm/yyyy) : ");
        String contractDate = sc.nextLine();
        
        return new Client(firstName, lastName, email, wilaya, commun, phoneNumber, SubscriptionsIndexMapper.getSubscriptionOfIndex(subscriptionTypeIndex), contractNumber, contractDate, false);
    }
    
    
}
