import profiles.UserProfile;
import profiles.ProfileType;
import database.DatabaseAdapter;
import factory.DatabaseFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema com Padrão Adapter para SGBDs ===\n");
        
        // Criando usuários com diferentes perfis
        UserProfile freeUser = new UserProfile("001", "João Silva", ProfileType.FREE);
        UserProfile basicUser = new UserProfile("002", "Maria Santos", ProfileType.BASIC);
        UserProfile ultimateUser = new UserProfile("003", "Pedro Oliveira", ProfileType.ULTIMATE);
        
        // Testando cada perfil
        testUserDatabase(freeUser);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        testUserDatabase(basicUser);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        testUserDatabase(ultimateUser);
    }
    
    private static void testUserDatabase(UserProfile user) {
        System.out.println("Testando usuário: " + user.getUserName());
        System.out.println("Perfil: " + user.getProfileType());
        System.out.println("-".repeat(40));
        
        // Factory escolhe o adapter baseado no perfil
        DatabaseAdapter adapter = DatabaseFactory.getDatabaseAdapter(user.getProfileType());
        
        System.out.println("SGBD Selecionado: " + adapter.getDatabaseInfo());
        System.out.println();
        
        // Conectando
        System.out.println("1. Conectando ao banco de dados...");
        adapter.connect(user);
        
        // Executando queries
        System.out.println("\n2. Executando operações no banco:");
        adapter.executeQuery(user, "SELECT * FROM usuarios");
        adapter.executeQuery(user, "INSERT INTO logs VALUES ('teste')");
        adapter.executeQuery(user, "UPDATE configuracoes SET status='ativo'");
        
        // Desconectando
        System.out.println("\n3. Desconectando do banco de dados...");
        adapter.disconnect(user);
        
        System.out.println("Teste concluído para " + user.getUserName());
    }
}