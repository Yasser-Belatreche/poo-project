package poo.phoneoperatormanager.cli.invoices_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.client.Client;
import poo.phoneoperatormanager.domain.operations.Duration;
import poo.phoneoperatormanager.domain.operations.PhoneCall;
import poo.phoneoperatormanager.domain.operations.SMS;
import poo.phoneoperatormanager.domain.subscription.ForfaitaireSubscriptionInvoiceCalculator;
import poo.phoneoperatormanager.domain.subscription.InvoiceCalculator;
import poo.phoneoperatormanager.domain.subscription.LibreSubscriptionInvoiceCalculator;
import poo.phoneoperatormanager.domain.subscription.PrepayeSubscriptionInvoiceCalculator;
import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.persistence.ClientsStore;
import poo.phoneoperatormanager.persistence.PhoneCallsStore;
import poo.phoneoperatormanager.persistence.SmsStore;

import java.util.ArrayList;
import java.util.Scanner;

public class EstablishInvoiceForGivenNumberCommand implements Command {
    @Override
    public void execute() {
        try {
            String phoneNumber = getPhoneNumberFromCli();
            
            Client targetClient = ClientsStore.findByPhoneNumberThrowsIfNotExist(phoneNumber);
            
            ArrayList<SMS> smsList = SmsStore.findSmsListOf(phoneNumber);
            ArrayList<PhoneCall> phoneCalls = PhoneCallsStore.findCallsOf(phoneNumber);
            
            Duration totalPhoneCallsDurationFromTargetClient = getTotalPhoneCallsDuration(phoneCalls, phoneNumber);
            int totalNumberOfSmsSentFromTargetClient = getTotalSmss(smsList, phoneNumber);
            
            switch (targetClient.getSubscription()) {
                case LIBRE -> {
                    LibreSubscriptionInvoiceCalculator calculator = new LibreSubscriptionInvoiceCalculator();
                    double priceToPay = calculator.calculateInvoice(totalPhoneCallsDurationFromTargetClient, totalNumberOfSmsSentFromTargetClient);
                    System.out.println("\nTarget client have " + priceToPay + " DA to pay that month");
                }
                case FORFAITAIRE -> {
                    ForfaitaireSubscriptionInvoiceCalculator calculator = new ForfaitaireSubscriptionInvoiceCalculator();
                    double creditLeft = calculator.calculateLeftCredit(totalPhoneCallsDurationFromTargetClient, totalNumberOfSmsSentFromTargetClient);
                    System.out.println("\nTarget client still have " + creditLeft + " DA of his FORFAITAIRE subscription");
                }
                case PREPAYE -> {
                    PrepayeSubscriptionInvoiceCalculator calculator = new PrepayeSubscriptionInvoiceCalculator();
                    double creditLeft = calculator.calculateLeftCredit(totalPhoneCallsDurationFromTargetClient, totalNumberOfSmsSentFromTargetClient);
                    System.out.println("\nTarget client still have " + creditLeft + " DA of his PREPAYE subscription");
                }
                default -> {
                }
            }
        } catch (ClientNotExistException e) {
            System.out.println("\nNo Client found with this number");
        }
        
    }
    
    private String getPhoneNumberFromCli() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the phone number of the target client : ");
        
        return sc.nextLine();
    }
    
    private Duration getTotalPhoneCallsDuration(ArrayList<PhoneCall> calls, String callerNumber) {
        Duration duration = new Duration(0, 0, 0);
        
        for (PhoneCall call : calls) {
            if (call.getCallerNumber().equals(callerNumber)) {
                duration.incrementBy(call.getDuration());
            }
        }
        
        return duration;
    }
    
    private int getTotalSmss(ArrayList<SMS> smsList, String senderNumber) {
        int total = 0;
        
        for (SMS sms : smsList) {
            if (sms.getSenderNumber().equals(senderNumber))
                total++;
        }
        
        return total;
    }
}
