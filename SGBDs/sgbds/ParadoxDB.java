package sgbds;

public class ParadoxDB {
    private boolean isOpen = false;
    private String currentUser = null;
    
    public void openSingleUser(String user) {
        this.currentUser = user;
        this.isOpen = true;
        System.out.println("ParadoxDB: Banco aberto para usuário único: " + user);
    }
    
    public void executeSingleTransaction(String user, String query) {
        if (!isOpen || currentUser == null || !currentUser.equals(user)) {
            System.out.println("ParadoxDB: Usuário não autenticado ou banco fechado!");
            return;
        }
        System.out.println("ParadoxDB: Usuário " + user + " executando transação única: " + query);
        System.out.println("ParadoxDB: Transação completada com sucesso!");
    }
    
    public void close() {
        this.isOpen = false;
        this.currentUser = null;
        System.out.println("ParadoxDB: Banco fechado");
    }
}