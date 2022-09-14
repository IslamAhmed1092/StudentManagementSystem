package system;

public abstract class User {

    protected String id;

    protected static long idCounter = 0;
    protected String name;

    protected String email;

    protected String mobileNumber;

    public User(String name, String email, String mobileNumber) {
        this.id = String.valueOf(idCounter++);
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public User(User other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.mobileNumber = other.mobileNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public abstract void displayUI();
}
