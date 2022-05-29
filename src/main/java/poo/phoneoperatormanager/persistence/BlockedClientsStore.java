package poo.phoneoperatormanager.persistence;

import poo.phoneoperatormanager.domain.client.BlockedClient;
import poo.phoneoperatormanager.exeptions.ClientNotExistException;
import poo.phoneoperatormanager.exeptions.PhoneNumberAlreadyExistException;

import java.util.Collection;
import java.util.HashMap;

public class BlockedClientsStore {
    
    private static final HashMap<String, BlockedClient> store = new HashMap<String, BlockedClient>();
    
    public static BlockedClient save(BlockedClient blockedClient) {
        return store.put(blockedClient.getPhoneNumber().value(), blockedClient);
    }
    
    public static BlockedClient saveThrowsIfAlreadyExist(BlockedClient blockedClient) throws PhoneNumberAlreadyExistException {
        if (isExist(blockedClient.getPhoneNumber().value()))
            throw new PhoneNumberAlreadyExistException();
        
        return store.put(blockedClient.getPhoneNumber().value(), blockedClient);
    }
    
    public static BlockedClient findByPhoneNumber(String phoneNumber) {
        return store.get(phoneNumber);
    }
    
    public static BlockedClient findByPhoneNumberThrowsIfNotExist(String phoneNumber) throws ClientNotExistException {
        BlockedClient blockedClient = store.get(phoneNumber);
        
        if (!isExist(phoneNumber))
            throw new ClientNotExistException();
        
        return blockedClient;
    }
    
    public static BlockedClient delete(String phone) {
        return store.remove(phone);
    }
    
    public static BlockedClient deleteThrowsIfNotExist(String phone) throws ClientNotExistException {
        if (!isExist(phone))
            throw new ClientNotExistException();
        
        return store.remove(phone);
    }
    
    public static boolean isExist(String phone) {
        BlockedClient blockedClient = store.get(phone);
        
        return blockedClient != null;
    }
    
    public static Collection<BlockedClient> findAll() {
        return store.values();
    }
}
