package com.app.user.mapper;

import com.app.user.dto.UserDto;
import com.app.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    void updateUserEntity(UserDto userDto,@MappingTarget User user);
}
