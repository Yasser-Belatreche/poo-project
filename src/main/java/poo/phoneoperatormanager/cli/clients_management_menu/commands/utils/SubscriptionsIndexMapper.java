package poo.phoneoperatormanager.cli.clients_management_menu.commands.utils;


import poo.phoneoperatormanager.domain.subscription.Subscription;

public class SubscriptionsIndexMapper {
    
    public static Subscription getSubscriptionOfIndex(String i) throws InvalidSubscriptionIndexChoice {
        return switch (i) {
            case "1" -> Subscription.FORFAITAIRE;
            case "2" -> Subscription.PREPAYE;
            case "3" -> Subscription.LIBRE;
            default -> throw new InvalidSubscriptionIndexChoice();
        };
    }
    
    public static String getSubscriptionIndexOf(Subscription subscription) {
        return switch (subscription) {
            case FORFAITAIRE -> "1";
            case PREPAYE -> "2";
            case LIBRE -> "3";
        };
    }
    
    private static class InvalidSubscriptionIndexChoice extends RuntimeException {
        public InvalidSubscriptionIndexChoice() {
            super("invalid subscription index");
        }
    }
}
