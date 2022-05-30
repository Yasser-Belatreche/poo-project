package poo.phoneoperatormanager.cli.main_menu.commands;

import java.text.ParseException;


import poo.phoneoperatormanager.cli.Command;

import poo.phoneoperatormanager.domain.client.Client;
import poo.phoneoperatormanager.domain.operations.SMS;
import poo.phoneoperatormanager.domain.operator.CoveringPercentage;
import poo.phoneoperatormanager.domain.operator.SellAgency;
import poo.phoneoperatormanager.domain.operator.AgencyType;
import poo.phoneoperatormanager.domain.operations.Duration;
import poo.phoneoperatormanager.domain.operations.PhoneCall;
import poo.phoneoperatormanager.domain.operations.SmsStatus;
import poo.phoneoperatormanager.domain.subscription.Subscription;

import poo.phoneoperatormanager.exeptions.InvalidEmailException;
import poo.phoneoperatormanager.exeptions.InvalidPercentageException;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

import poo.phoneoperatormanager.persistence.*;


public class FillDefaultDataCommand implements Command {
    
    @Override
    public void execute() {
        try {
            fillClients();
            fillCalls();
            fillSms();
            fillSellAgencies();
            fillCoveringPercentages();
            
            System.out.println("\n Data Filled Successfully.");
        } catch (InvalidPhoneNumberException | ParseException | InvalidEmailException | InvalidPercentageException e) {
            System.out.println("\n Error while filling some Data");
        }
    }
    
    private void fillClients() throws InvalidPhoneNumberException, ParseException, InvalidEmailException {
        ClientsStore.save(new Client("Yasser", "Belatreche", "yasser@gmail.com", "Jijel", "jijel", "0798980975", Subscription.FORFAITAIRE, "028293", "18/11/2022", false));
        ClientsStore.save(new Client("Imad", "Ayach", "imad@ayach.com", "Algiers", "Beb ezzouar", "0578972718", Subscription.LIBRE, "0348293", "10/10/2022", false));
        ClientsStore.save(new Client("Aya", "Chyat", "aya@gmail.com", "Ouregla", "commun", "0509809752", Subscription.PREPAYE, "0282933", "1/1/2022", false));
        ClientsStore.save(new Client("Ines", "Chikhi", "ines@gmail.com", "Algiers", "Beb eloued", "0698980090", Subscription.PREPAYE, "011293", "18/10/2021", false));
        ClientsStore.save(new Client("Wail", "Belarbi", "wail@gmail.com", "Soug ehras", "Beb eloued", "0500980975", Subscription.LIBRE, "128293", "12/11/2021", false));
        ClientsStore.save(new Client("Walid", "Alouch", "walid@gmail.com", "Jijel", "Beb eloued", "0790980975", Subscription.FORFAITAIRE, "1283293", "1/1/2021", false));
        ClientsStore.save(new Client("Wassim", "Tertag", "yasser@gmail.com", "Adrar", "Beb eloued", "0718980975", Subscription.FORFAITAIRE, "0228293", "18/1/2021", false));
        ClientsStore.save(new Client("Nada", "Bibi", "nada@gmail.com", "Laghouat", "Beb eloued", "0798910975", Subscription.LIBRE, "0282931", "8/1/2020", false));
        ClientsStore.save(new Client("Jimi", "Chikou", "jimi@gmail.com", "Biskra", "Beb eloued", "0798940975", Subscription.PREPAYE, "0283293", "8/11/2022", false));
        ClientsStore.save(new Client("James", "Koukou", "james@gmail.com", "Bechar", "Beb ezzouar", "0518980975", Subscription.LIBRE, "0282493", "18/12/2022", false));
        ClientsStore.save(new Client("Oussama", "Gimouki", "oussama@gmail.com", "Tizi Ouzou", "Beb ezzouar", "0606980975", Subscription.FORFAITAIRE, "0528293", "18/4/2022", false));
        ClientsStore.save(new Client("Rafik", "Karabirnou", "rafik@gmail.com", "Skikda", "Beb ezzouar", "0500921929", Subscription.LIBRE, "0282933", "18/2/2022", false));
        ClientsStore.save(new Client("Rami", "Hanad", "rami@gmail.com", "Annaba", "Beb ezzouar", "0687919303", Subscription.PREPAYE, "0282932", "18/5/2022", false));
        ClientsStore.save(new Client("Youssra", "Bouzaout", "youssra@gmail.com", "Guelma", "Beb ezzouar", "0500980975", Subscription.PREPAYE, "03428293", "11/1/2022", false));
        ClientsStore.save(new Client("Meriem", "Chibouni", "meriem@gmail.com", "Mascara", "Beb ezzouar", "0612980975", Subscription.LIBRE, "02829223", "1/11/2022", false));
        ClientsStore.save(new Client("Nada", "Chenati", "nada@gmail.com", "Mostaganem", "Beb ezzouar", "0500280975", Subscription.FORFAITAIRE, "0218293", "12/11/2022", false));
        ClientsStore.save(new Client("Anis", "Chibani", "anis@gmail.com", "Bordj Bou Arreridj", "jijel", "0611080975", Subscription.LIBRE, "0282933", "11/11/2022", false));
        ClientsStore.save(new Client("Anisa", "Boubeltou", "anisa@gmail.com", "Constantine", "jijel", "0511330975", Subscription.LIBRE, "0282930", "15/11/2022", false));
        ClientsStore.save(new Client("James", "Chirou", "james@gmail.com", "Bordj Bou Arreridj", "Beb ezzouar", "0611400975", Subscription.PREPAYE, "0228293", "4/11/2022", false));
        ClientsStore.save(new Client("Marwa", "Kabana", "marwa@gmail.com", "Tissemsilt", "jijel", "0500980975", Subscription.PREPAYE, "0282932", "8/1/2022", false));
        ClientsStore.save(new Client("Moncef", "Bousis", "moncef@gmail.com", "Algiers", "Beb ezzouar", "0611000975", Subscription.FORFAITAIRE, "0428293", "8/11/2022", false));
    }
    
    private void fillCalls() throws InvalidPhoneNumberException {
        PhoneCallsStore.save(new PhoneCall("0798910975", "0611080975", new Duration(0, 3, 30)));
        PhoneCallsStore.save(new PhoneCall("0612980975", "0511330975", new Duration(1, 0, 30)));
        PhoneCallsStore.save(new PhoneCall("0500980975", "0611080975", new Duration(0, 4, 23)));
        PhoneCallsStore.save(new PhoneCall("0798910975", "0611080975", new Duration(0, 1, 31)));
        PhoneCallsStore.save(new PhoneCall("0611000975", "0798910975", new Duration(0, 2, 30)));
        PhoneCallsStore.save(new PhoneCall("0798910975", "0511330975", new Duration(0, 0, 30)));
        PhoneCallsStore.save(new PhoneCall("0511330975", "0611000975", new Duration(0, 1, 30)));
        PhoneCallsStore.save(new PhoneCall("0798910975", "0511330975", new Duration(0, 4, 53)));
        PhoneCallsStore.save(new PhoneCall("0798910975", "0611080975", new Duration(0, 10, 31)));
    }
    
    private void fillSms() throws InvalidPhoneNumberException {
        SmsStore.save(new SMS("0798910975", "0611080975", "Hello How are you doing", SmsStatus.RECEIVED));
        SmsStore.save(new SMS("0611080975", "0798910975", "Hi, i need a ride", SmsStatus.ERROR));
        SmsStore.save(new SMS("0798910975", "0611080975", "See you at 10am", SmsStatus.SENT));
        SmsStore.save(new SMS("0798980975", "0611080975", "Thanks for your help", SmsStatus.SENT));
        SmsStore.save(new SMS("0798910975", "0511330975", "Love you", SmsStatus.RECEIVED));
        SmsStore.save(new SMS("0511330975", "0611080975", "Okey no problem", SmsStatus.ERROR));
        SmsStore.save(new SMS("0511330975", "0798980975", "Hi, can you call me later", SmsStatus.SENT));
        SmsStore.save(new SMS("0606980975", "0611080975", "I appreciate your help", SmsStatus.SENT));
        SmsStore.save(new SMS("0798980975", "0606980975", "Sorry, i won't do it again", SmsStatus.RECEIVED));
    }
    
    private void fillSellAgencies() throws InvalidPhoneNumberException {
        SellAgenciesStore.save(new SellAgency("Al rahma", "Jijel", "Beb ezzouar", "0567281990", AgencyType.PRIMARY));
        SellAgenciesStore.save(new SellAgency("Al Bassma", "Mostaganem", "Beb ezzouar", "0611180975", AgencyType.SECONDARY));
        SellAgenciesStore.save(new SellAgency("Al Ihsan", "Annaba", "Beb ezzouar", "0511330970", AgencyType.SECONDARY));
        SellAgenciesStore.save(new SellAgency("Al Agency", "Tissemsilt", "Beb ezzouar", "0611010975", AgencyType.PRIMARY));
        SellAgenciesStore.save(new SellAgency("Al N3ama", "Constantine", "Beb ezzouar", "0798930975", AgencyType.SECONDARY));
        SellAgenciesStore.save(new SellAgency("Al Batata", "Algiers", "Beb ezzouar", "0567281903", AgencyType.SECONDARY));
        SellAgenciesStore.save(new SellAgency("Al cherba", "Bordj Bou Arreridj", "Beb ezzouar", "0611080970", AgencyType.PRIMARY));
    }
    
    private void fillCoveringPercentages() throws InvalidPercentageException {
        CoveringPercentagesStore.save(new CoveringPercentage("Jijel", 10.8));
        CoveringPercentagesStore.save(new CoveringPercentage("Constantine", 40));
        CoveringPercentagesStore.save(new CoveringPercentage("Bordj Bou Arreridj", 60.3));
        CoveringPercentagesStore.save(new CoveringPercentage("Mostaganem", 80));
        CoveringPercentagesStore.save(new CoveringPercentage("Tissemsilt", 95));
    }
}
