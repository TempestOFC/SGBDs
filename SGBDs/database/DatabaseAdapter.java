package database;

import profiles.UserProfile;

public interface DatabaseAdapter {
    void connect(UserProfile user);
    void executeQuery(UserProfile user, String query);
    void disconnect(UserProfile user);
    String getDatabaseInfo();
}