package speed.wagon.userservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import speed.wagon.userservice.controller.UserController;
import speed.wagon.userservice.dto.mapper.UserMapper;
import speed.wagon.userservice.dto.request.UserRequestDto;
import speed.wagon.userservice.dto.response.UserResponseDto;
import speed.wagon.userservice.model.User;
import speed.wagon.userservice.service.UserService;
import java.time.LocalDate;

@SpringBootTest
class UserServiceApplicationTests {
    private static User defaultUser;
    private static UserRequestDto defaultUserRequestDto;
    private static UserResponseDto defaultUserResponseDto;
    private final UserMapper userMapper;
    private final UserService userService;
    private final UserController userController;


    @Autowired
    UserServiceApplicationTests(UserMapper userMapper,
                                UserService userService,
                                UserController userController) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.userController = userController;
    }

    @BeforeAll
    static void beforeAll() {
        defaultUser = new User();
        defaultUser.setName("John");
        defaultUser.setLastName("Doe");
        defaultUser.setBirthday(LocalDate.parse("1999-12-12"));

        defaultUserRequestDto = new UserRequestDto();
        defaultUserRequestDto.setName("John");
        defaultUserRequestDto.setLastName("Doe");
        defaultUserRequestDto.setBirthday(LocalDate.parse("1800-12-12"));

        defaultUserResponseDto = new UserResponseDto();
        defaultUserResponseDto.setName("John");
        defaultUserResponseDto.setLastName("Doe");
        defaultUserResponseDto.setBirthday(LocalDate.parse("1800-12-12"));
    }

    @Test
    void contextLoads() {
    }

    @Test
    void springInitializationTest_ok() {
        Assertions.assertNotNull(userMapper);
        Assertions.assertNotNull(userService);
    }

    @Test
    void userMapperToDtoUsage_ok() {
        UserResponseDto userResponseDto = userMapper.toDto(defaultUser);
        Assertions.assertEquals(defaultUser.getId(), userResponseDto.getId());
        Assertions.assertEquals(defaultUser.getName(), userResponseDto.getName());
        Assertions.assertEquals(defaultUser.getLastName(), userResponseDto.getLastName());
        Assertions.assertEquals(defaultUser.getBirthday(), userResponseDto.getBirthday());
    }

    @Test
    void userMapperToModel_ok() {
        User user = userMapper.toModel(defaultUserRequestDto);
        Assertions.assertEquals(defaultUserRequestDto.getName(), user.getName());
        Assertions.assertEquals(defaultUserRequestDto.getLastName(), user.getLastName());
        Assertions.assertEquals(defaultUserRequestDto.getBirthday(), user.getBirthday());
    }

    @Test
    void userServiceCreateAndUpdate_ok() {
        User savedUser = userService.save(defaultUser);
        defaultUser.setId(savedUser.getId());
        Assertions.assertEquals(savedUser, defaultUser);
        savedUser.setName("Dan");
        User updatedUser = userService.update(savedUser);
        defaultUser.setName("Dan");
        Assertions.assertEquals(updatedUser, defaultUser);
        userService.delete(updatedUser.getId());
    }

    @Test
    void userControllerCreate_ok() {
        UserResponseDto userResponseDto = userController.create(defaultUserRequestDto);
        Assertions.assertEquals(userResponseDto.getName(), defaultUserResponseDto.getName());
        Assertions.assertEquals(userResponseDto.getLastName(), defaultUserResponseDto.getLastName());
        Assertions.assertEquals(userResponseDto.getBirthday(), defaultUserResponseDto.getBirthday());
    }
}
