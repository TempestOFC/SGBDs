package profiles;

public class UserProfile {
    private String userId;
    private String userName;
    private ProfileType profileType;
    
    public UserProfile(String userId, String userName, ProfileType profileType) {
        this.userId = userId;
        this.userName = userName;
        this.profileType = profileType;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public ProfileType getProfileType() {
        return profileType;
    }
    
    @Override
    public String toString() {
        return "UserProfile{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", profileType=" + profileType +
                '}';
    }
}