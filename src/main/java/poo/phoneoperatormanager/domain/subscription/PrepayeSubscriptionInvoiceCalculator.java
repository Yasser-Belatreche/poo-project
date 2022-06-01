package poo.phoneoperatormanager.domain.subscription;

import poo.phoneoperatormanager.domain.operations.Duration;

public class PrepayeSubscriptionInvoiceCalculator extends InvoiceCalculator {
    private final int TOTAL_CREDIT = 2300;
    
    public PrepayeSubscriptionInvoiceCalculator() {
    }
    
    public double calculateLeftCredit(Duration totalCallsDuration, int totalSMSSent) {
        return TOTAL_CREDIT - (totalCallsDuration.toMinutes() * MINUTE_CALL_PRICE + totalSMSSent * SMS_PRICE);
    }
}
