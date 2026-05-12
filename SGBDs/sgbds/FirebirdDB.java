package sgbds;

import java.util.HashSet;
import java.util.Set;

public class FirebirdDB {
    private boolean isOpen = false;
    private Set<String> activeUsers = new HashSet<>();
    
    public void openMultiUser() {
        this.isOpen = true;
        System.out.println("FirebirdDB: Banco aberto para múltiplos usuários");
    }
    
    public void addUser(String user) {
        if (!isOpen) {
            System.out.println("FirebirdDB: Banco não está aberto!");
            return;
        }
        activeUsers.add(user);
        System.out.println("FirebirdDB: Usuário " + user + " conectado. Total de usuários: " + activeUsers.size());
    }
    
    public void executeSingleTransaction(String user, String query) {
        if (!isOpen || !activeUsers.contains(user)) {
            System.out.println("FirebirdDB: Usuário não autenticado ou banco fechado!");
            return;
        }
        System.out.println("FirebirdDB: Usuário " + user + " executando transação única: " + query);
        System.out.println("FirebirdDB: Transação completada com sucesso!");
    }
    
    public void removeUser(String user) {
        activeUsers.remove(user);
        System.out.println("FirebirdDB: Usuário " + user + " desconectado");
    }
    
    public void close() {
        this.isOpen = false;
        this.activeUsers.clear();
        System.out.println("FirebirdDB: Banco fechado");
    }
}