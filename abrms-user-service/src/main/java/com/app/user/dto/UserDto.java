package com.app.user.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private Boolean isActive;


}
