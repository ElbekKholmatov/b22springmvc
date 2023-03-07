package dev.jlkeesh.mapper;

import dev.jlkeesh.domain.User;
import dev.jlkeesh.dto.user.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromCreateDTO(UserCreateDTO dto);

    List<User> fromCreateDTO(List<UserCreateDTO> dtos);

    User fromUpdateDTO(UserUpdateDTO dto);

    User fromDeleteDTO(UserDeleteDTO dto);
}
