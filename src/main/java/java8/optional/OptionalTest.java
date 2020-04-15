package java8.optional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();

    }
    @Test
    public void test1(){
        User user = null;
        Optional<User> opt = Optional.ofNullable(user);
    }
    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);

        assertEquals("John", opt.get());
    }
    @Test
    public void whenCheckIfPresent_thenOk() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);
        System.out.println(opt.get().getEmail());
        assertTrue(opt.isPresent());

        assertEquals(user.getEmail(), opt.get().getEmail());

        User user2 = null;
        opt.ifPresent( u -> System.out.println(u.getEmail()));
        Optional<User> opt2 = Optional.ofNullable(user2);
        opt2.ifPresent( u -> assertEquals(user.getEmail(), u.getEmail()));
        if (opt2.isPresent()){
            assertEquals(user.getEmail(), opt2.get().getEmail());
        }
    }
    @Test
    public void whenValueNotNull_thenIgnoreDefault() {
        User user = null;
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2);

        User result2 = Optional.ofNullable(user).orElseGet( () -> user2);

        assertEquals("john@gmail.com", result.getEmail());
    }

    @Test
    public void givenEmptyValue_whenCompare_thenOk() {
        User user = null;
        User result = Optional.ofNullable(user).orElse(createNewUser());
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    private User createNewUser() {
        System.out.println("createNewUser");
        return new User("extra@gmail.com", "1234");
    }
    @Test
    public void givenPresentValue_whenCompare_thenOk() {
        User user = new User("john@gmail.com", "1234");
        System.out.println("Using orElse");
        // orElse会都执行，但返回对象不变
        User result = Optional.ofNullable(user).orElse(createNewUser());
        System.out.println("Using orElseGet");
        // orElseGet 不会创建对象
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    @Test()
    public void whenThrowException_thenOk() {
        User user = null;
        User result = Optional.ofNullable(user)
                .orElseThrow( () -> new IllegalArgumentException());
    }

    @Test
    public void whenMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        String email = Optional.ofNullable(user)
                .map(u -> u.getEmail()).orElse("default@gmail.com");

        assertEquals(email, user.getEmail());
    }

    @Test
    public void testNull(){
        String json = "{\n" +
                "\t\"user\": {\n" +
                "\t\t\"age\": 20\n" +
                "\t\t,\"name\": \"Jim\"\n" +
                "\t\t,\"address2\": {\n" +
                "\t\t\t\"province\": \"浙江省\"\n" +
                "\t\t\t,\"postcode\": \"111111\"\n" +
                "\t\t}\n" +
                "   }\n" +
                "}";
        JSONObject jsonObj = JSON.parseObject(json);

        String address = Optional.ofNullable(jsonObj)
                .flatMap(jsonObject -> Optional.ofNullable(jsonObject.getJSONObject("user")))
                .flatMap(jsonObject->Optional.ofNullable(jsonObject.getJSONObject("address")))
                .flatMap(jsonObject->Optional.ofNullable(jsonObject.getString("postcode")))
                .orElse("unknown");

        System.out.println(address);

    }
}
