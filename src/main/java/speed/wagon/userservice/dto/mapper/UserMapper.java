package speed.wagon.userservice.dto.mapper;

import org.springframework.stereotype.Component;
import speed.wagon.userservice.dto.request.UserRequestDto;
import speed.wagon.userservice.dto.response.UserResponseDto;
import speed.wagon.userservice.model.User;

@Component
public class UserMapper {
    public UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setBirthday(user.getBirthday());
        return userResponseDto;
    }

    public User toModel(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setLastName(userRequestDto.getLastName());
        user.setBirthday(userRequestDto.getBirthday());
        return user;
    }
}
