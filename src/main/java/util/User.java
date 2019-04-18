package util;

public class User {
    public User(String id, String test) {
        this.id = id;
        this.test = test;
    }

    private String id;
    private String test;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
