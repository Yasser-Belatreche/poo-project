package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import java.util.Scanner;

import poo.phoneoperatormanager.cli.Command;

import poo.phoneoperatormanager.domain.operations.SMS;
import poo.phoneoperatormanager.domain.operations.SmsStatus;

import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

import poo.phoneoperatormanager.persistence.SmsStore;
import poo.phoneoperatormanager.persistence.ClientsStore;


public class AddSMSCommand implements Command {
    
    @Override
    public void execute() {
        boolean isNotValid = false;
        
        do {
            try {
                SMS sms = getSMSFromCLI();
                
                if (!ClientsStore.isExist(sms.getSenderNumber().value()))
                    throw new ClientNotExistException();
                
                SmsStore.save(sms);
                isNotValid = false;
                
                System.out.println("\n SMS added successfully");
                
            } catch (InvalidPhoneNumberException e) {
                System.out.println("\n Invalid phone number, please try again.");
                isNotValid = true;
            } catch (ClientNotExistException e) {
                System.out.println("No Client found with the provided sms sender number");
                isNotValid = true;
            } catch (Exception e) {
                System.out.println("\n Something went wrong, please try again.");
            }
        } while (isNotValid);
        
    }
    
    private SMS getSMSFromCLI() throws InvalidPhoneNumberException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n Please Provide the sms information : ");
        
        System.out.print("Sender Number : ");
        String senderNumber = sc.nextLine();
        
        System.out.print("Receiver Number : ");
        String receiverNumber = sc.nextLine();
        
        System.out.print("SMS Message : ");
        String message = sc.nextLine();
        
        return new SMS(senderNumber, receiverNumber, message, SmsStatus.SENT);
    }
}
