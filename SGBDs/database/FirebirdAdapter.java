package database;

import profiles.UserProfile;
import sgbds.FirebirdDB;

public class FirebirdAdapter implements DatabaseAdapter {
    private FirebirdDB firebirdDB;
    
    public FirebirdAdapter() {
        this.firebirdDB = new FirebirdDB();
    }
    
    @Override
    public void connect(UserProfile user) {
        firebirdDB.openMultiUser();
        firebirdDB.addUser(user.getUserName());
    }
    
    @Override
    public void executeQuery(UserProfile user, String query) {
        firebirdDB.executeSingleTransaction(user.getUserName(), query);
    }
    
    @Override
    public void disconnect(UserProfile user) {
        firebirdDB.removeUser(user.getUserName());
        firebirdDB.close();
    }
    
    @Override
    public String getDatabaseInfo() {
        return "Firebird DB - Multi User / Single Transaction";
    }
}