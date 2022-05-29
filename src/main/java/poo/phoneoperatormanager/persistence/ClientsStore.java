package poo.phoneoperatormanager.persistence;

import java.util.HashMap;
import java.util.ArrayList;

import poo.phoneoperatormanager.domain.client.Client;
import poo.phoneoperatormanager.domain.subscription.Subscription;

import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.exeptions.PhoneNumberAlreadyExistException;


public class ClientsStore {
    
    private static final HashMap<String, Client> store = new HashMap<String, Client>();
    
    public static Client save(Client client) {
        return store.put(client.getPhoneNumber().value(), client);
    }
    
    public static Client saveThrowsIfAlreadyExist(Client client) throws PhoneNumberAlreadyExistException {
        if (isExist(client))
            throw new PhoneNumberAlreadyExistException();
        
        return store.put(client.getPhoneNumber().value(), client);
    }
    
    
    public static Client findByPhoneNumber(String phoneNumber) {
        return store.get(phoneNumber);
    }
    
    public static Client findByPhoneNumberThrowsIfNotExist(String phoneNumber) throws ClientNotExistException {
        if (!isExist(phoneNumber))
            throw new ClientNotExistException();
        
        return store.get(phoneNumber);
    }
    
    
    public static Client update(Client client) {
        return store.replace(client.getPhoneNumber().value(), client);
    }
    
    public static Client updateThrowsIfNotExist(Client client) throws ClientNotExistException {
        if (!isExist(client))
            throw new ClientNotExistException();
        
        return store.replace(client.getPhoneNumber().value(), client);
    }
    
    
    public static Client delete(String phoneNumber) {
        return store.remove(phoneNumber);
    }
    
    public static Client deleteThrowsIfNotExist(String phoneNumber) throws ClientNotExistException {
        if (!isExist(phoneNumber))
            throw new ClientNotExistException();
        
        return store.remove(phoneNumber);
    }
    
    public static ArrayList<Client> findClientsOfSubscription(Subscription subscription) {
        ArrayList<Client> targetClients = new ArrayList<Client>();
        
        store.forEach((s, client) -> {
            if (client.getSubscription() == subscription)
                targetClients.add(client);
        });
        
        return targetClients;
    }
    
    public static ArrayList<Client> findClientsOfWilaya(String wilaya) {
        ArrayList<Client> targetClients = new ArrayList<Client>();
        
        store.forEach((s, client) -> {
            if (client.getAddress().getWilaya().equals(wilaya))
                targetClients.add(client);
        });
        
        return targetClients;
    }
    
    public static boolean isExist(Client client) {
        Client existingClient = store.get(client.getPhoneNumber().value());
        
        return existingClient != null;
    }
    
    public static boolean isExist(String phoneNumber) {
        Client existingClient = store.get(phoneNumber);
        
        return existingClient != null;
    }
}
