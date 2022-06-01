package poo.phoneoperatormanager.domain.subscription;

import poo.phoneoperatormanager.domain.operations.Duration;

public class LibreSubscriptionInvoiceCalculator extends InvoiceCalculator {
    private final int BASE_PRICE_TO_PAY = 500;
    private final int TVA_PERCENTAGE = 19;
    
    public LibreSubscriptionInvoiceCalculator() {
    }
    
    public double calculateInvoice(Duration totalCallsDuration, int totalSMSSent) {
        double totalWithoutTVA = totalSMSSent * SMS_PRICE + totalCallsDuration.toMinutes() * MINUTE_CALL_PRICE;
        double tvaValue = totalWithoutTVA * TVA_PERCENTAGE / 100;
        
        return totalWithoutTVA + tvaValue + BASE_PRICE_TO_PAY;
    }
}
