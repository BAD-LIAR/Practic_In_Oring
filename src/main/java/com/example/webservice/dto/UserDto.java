package com.example.webservice.dto;

import com.example.webservice.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;

    public static UserDto from(User user) {

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public static List<UserDto> from(List<User> teachers) {
        return teachers.stream().map(UserDto::from).collect(Collectors.toList());
    }

}
