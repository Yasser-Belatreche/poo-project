package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.operations.SMS;
import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.persistence.ClientsStore;
import poo.phoneoperatormanager.persistence.SmsStore;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSMSCommands implements Command {
    
    @Override
    public void execute() {
        try {
            String phone = getPhoneNumberFromCli();
            
            if (!ClientsStore.isExist(phone))
                throw new ClientNotExistException();
            
            ArrayList<SMS> smsList = SmsStore.findSmsListOf(phone);
            
            for (SMS call : smsList) {
                int index = smsList.indexOf(call) + 1;
                System.out.println("\nCall " + index + " : ");
                System.out.println(call);
            }
            
            System.out.println("\n" + smsList.size() + " sms found for " + phone);
        } catch (ClientNotExistException e) {
            System.out.println("\n No client found with this number");
        } catch (Exception e) {
            System.out.println("\n Something went wrong, please try again");
        }
        
    }
    
    private String getPhoneNumberFromCli() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the phone number of the target client : ");
        
        return sc.nextLine();
    }
}
