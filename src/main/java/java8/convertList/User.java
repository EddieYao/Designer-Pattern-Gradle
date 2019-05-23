package java8.convertList;

public class User {
    private String id;
    private String test;
    private String sex;
    private String name;

    public User(String id, String test, String sex, String name) {
        this.id = id;
        this.test = test;
        this.sex = sex;
        this.name = name;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
