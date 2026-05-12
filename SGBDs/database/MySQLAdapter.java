package database;

import profiles.UserProfile;
import sgbds.MySQLDB;

public class MySQLAdapter implements DatabaseAdapter {
    private MySQLDB mySQLDB;
    
    public MySQLAdapter() {
        this.mySQLDB = new MySQLDB();
    }
    
    @Override
    public void connect(UserProfile user) {
        mySQLDB.openCluster();
        mySQLDB.connectUser(user.getUserName());
    }
    
    @Override
    public void executeQuery(UserProfile user, String query) {
        mySQLDB.executeTransaction(user.getUserName(), query);
    }
    
    @Override
    public void disconnect(UserProfile user) {
        mySQLDB.disconnectUser(user.getUserName());
        mySQLDB.close();
    }
    
    @Override
    public String getDatabaseInfo() {
        return "MySQL DB - Multi User / Multiple Transactions";
    }
}