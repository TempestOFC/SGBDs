package factory;

import database.DatabaseAdapter;
import database.ParadoxAdapter;
import database.FirebirdAdapter;
import database.MySQLAdapter;
import profiles.ProfileType;

public class DatabaseFactory {
    
    public static DatabaseAdapter getDatabaseAdapter(ProfileType profileType) {
        switch (profileType) {
            case FREE:
                System.out.println("Criando adapter para Paradox (Single User/Single Transaction)");
                return new ParadoxAdapter();
            case BASIC:
                System.out.println("Criando adapter para Firebird (Multi User/Single Transaction)");
                return new FirebirdAdapter();
            case ULTIMATE:
                System.out.println("Criando adapter para MySQL (Multi User/Multiple Transactions)");
                return new MySQLAdapter();
            default:
                throw new IllegalArgumentException("Perfil inválido: " + profileType);
        }
    }
}