package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import java.util.Scanner;

import poo.phoneoperatormanager.cli.Command;

import poo.phoneoperatormanager.domain.operations.Duration;
import poo.phoneoperatormanager.domain.operations.PhoneCall;

import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.exeptions.InvalidDurationFormatException;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

import poo.phoneoperatormanager.persistence.PhoneCallsStore;
import poo.phoneoperatormanager.persistence.SmsStore;
import poo.phoneoperatormanager.persistence.ClientsStore;


public class AddPhoneCallCommand implements Command {
    
    @Override
    public void execute() {
        boolean isNotValid = false;
        
        do {
            try {
                PhoneCall phoneCall = getPhoneCallFromCLI();
                
                if (!ClientsStore.isExist(phoneCall.getCallerNumber().value()))
                    throw new ClientNotExistException();
                
                PhoneCallsStore.save(phoneCall);
                isNotValid = false;
                
                System.out.println("\n Phone Call added successfully");
            } catch (InvalidDurationFormatException e) {
                System.out.println("\n Invalid Duration Format, please provide a valid format (HH:MM:SS)");
                isNotValid = true;
            } catch (InvalidPhoneNumberException e) {
                System.out.println("\n Invalid phone number, please try again.");
                isNotValid = true;
            } catch (ClientNotExistException e) {
                System.out.println("\n No Client found with the provided caller number");
                isNotValid = true;
            } catch (Exception e) {
                System.out.println("\n Something went wrong, please try again.");
            }
        } while (isNotValid);
        
    }
    
    private PhoneCall getPhoneCallFromCLI() throws InvalidPhoneNumberException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n Please Provide the phone call information : ");
        
        System.out.print("Caller Number : ");
        String callerNumber = sc.nextLine();
        
        System.out.print("Receiver Number : ");
        String receiverNumber = sc.nextLine();
        
        System.out.print("Duration (HH:MM:SS) : ");
        String duration = sc.nextLine();
        
        return new PhoneCall(callerNumber, receiverNumber, new Duration(duration));
    }
}
