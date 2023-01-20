package speed.wagon.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import speed.wagon.userservice.dto.mapper.UserMapper;
import speed.wagon.userservice.dto.request.UserRequestDto;
import speed.wagon.userservice.dto.response.UserResponseDto;
import speed.wagon.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService,
                          UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public UserResponseDto create(@RequestBody UserRequestDto userRequestDto) {
        return userMapper.toDto(
                userService.save(userMapper.toModel(userRequestDto))
        );
    }

    @GetMapping()
    public UserResponseDto getById(@RequestParam Long id) {
        return userMapper.toDto(userService.getById(id));
    }

}
