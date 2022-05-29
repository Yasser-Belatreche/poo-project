package poo.phoneoperatormanager.domain.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {
    private final java.util.Date value;
    
    public Date(String date) throws ParseException {
        value = new SimpleDateFormat("dd/MM/yyyy").parse(date);
    }
    
    public java.util.Date value() {
        return value;
    }
    
    @Override
    public String toString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(value);
    }
}
