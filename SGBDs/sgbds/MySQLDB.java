package sgbds;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class MySQLDB {
    private boolean isOpen = false;
    private Map<String, List<String>> userTransactions = new HashMap<>();
    
    public void openCluster() {
        this.isOpen = true;
        System.out.println("MySQLDB: Cluster de banco de dados aberto para múltiplas transações");
    }
    
    public void connectUser(String user) {
        if (!isOpen) {
            System.out.println("MySQLDB: Cluster não está disponível!");
            return;
        }
        userTransactions.putIfAbsent(user, new ArrayList<>());
        System.out.println("MySQLDB: Usuário " + user + " conectado ao cluster");
    }
    
    public void executeTransaction(String user, String query) {
        if (!isOpen || !userTransactions.containsKey(user)) {
            System.out.println("MySQLDB: Usuário não conectado ou cluster fechado!");
            return;
        }
        
        userTransactions.get(user).add(query);
        System.out.println("MySQLDB: Usuário " + user + " executando transação #" + 
                          userTransactions.get(user).size() + ": " + query);
        System.out.println("MySQLDB: Múltiplas transações suportadas - Transação registrada!");
    }
    
    public List<String> getUserTransactions(String user) {
        return userTransactions.getOrDefault(user, new ArrayList<>());
    }
    
    public void disconnectUser(String user) {
        userTransactions.remove(user);
        System.out.println("MySQLDB: Usuário " + user + " desconectado do cluster");
    }
    
    public void close() {
        this.isOpen = false;
        this.userTransactions.clear();
        System.out.println("MySQLDB: Cluster fechado");
    }
}