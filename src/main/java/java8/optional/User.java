package java8.optional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
