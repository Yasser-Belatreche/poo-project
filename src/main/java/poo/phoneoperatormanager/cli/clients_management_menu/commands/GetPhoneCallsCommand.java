package poo.phoneoperatormanager.cli.clients_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.operations.Duration;
import poo.phoneoperatormanager.domain.operations.PhoneCall;
import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.persistence.ClientsStore;
import poo.phoneoperatormanager.persistence.PhoneCallsStore;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPhoneCallsCommand implements Command {
    
    @Override
    public void execute() {
        try {
            String phone = getPhoneNumberFromCli();
            
            if (!ClientsStore.isExist(phone))
                throw new ClientNotExistException();
            
            ArrayList<PhoneCall> calls = PhoneCallsStore.findCallsOf(phone);
            
            int numOfCallsFromTarget = 0;
            Duration totalDurationOfCallsFromTarget = new Duration(0, 0, 0);
            
            for (PhoneCall call : calls) {
                int index = calls.indexOf(call) + 1;
                System.out.println("\nCall " + index + " : ");
                System.out.println(call);
                
                if (call.getCallerNumber().equals(phone)) {
                    numOfCallsFromTarget++;
                    totalDurationOfCallsFromTarget.incrementBy(call.getDuration());
                }
            }
            
            System.out.println("\n" + calls.size() + " calls found for " + phone);
            System.out.println(numOfCallsFromTarget + " of those calls were from " + phone + ", and the total duration of them were : " + totalDurationOfCallsFromTarget);
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
