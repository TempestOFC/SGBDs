package database;

import profiles.UserProfile;
import sgbds.ParadoxDB;

public class ParadoxAdapter implements DatabaseAdapter {
    private ParadoxDB paradoxDB;
    
    public ParadoxAdapter() {
        this.paradoxDB = new ParadoxDB();
    }
    
    @Override
    public void connect(UserProfile user) {
        paradoxDB.openSingleUser(user.getUserName());
    }
    
    @Override
    public void executeQuery(UserProfile user, String query) {
        paradoxDB.executeSingleTransaction(user.getUserName(), query);
    }
    
    @Override
    public void disconnect(UserProfile user) {
        paradoxDB.close();
    }
    
    @Override
    public String getDatabaseInfo() {
        return "Paradox DB - Single User / Single Transaction";
    }
}