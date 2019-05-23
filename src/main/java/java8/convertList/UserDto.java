package java8.convertList;

public class UserDto extends User{


    private String myType;

    public UserDto(String id, String test, String sex, String name, String myType) {
        super(id, test, sex, name);
        this.myType = myType;
    }

    public String getMyType() {
        return myType;
    }

    public void setMyType(String myType) {
        this.myType = myType;
    }
}
