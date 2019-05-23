package java8.convertList;

import java.util.ArrayList;
import java.util.List;

public class OmUTest {

    public static void main(String[] args) {
        User user = new User("1","1","1","1");
        List<User> users = new ArrayList<>();
        users.add(user);
        UserDto userDto = new UserDto("2","2","2","2","2");
        List<User> userDtos = new ArrayList<>();
        userDtos.add(userDto);

        User userDTransfer = ObjectMapperUtils.convertValue(userDto,User.class);
        System.out.println(userDTransfer.getId());

        List<User> userTransferList = ObjectMapperUtils.convertValueList(userDtos,User.class);
        System.out.println(userTransferList.get(0).getId());
    }
}
