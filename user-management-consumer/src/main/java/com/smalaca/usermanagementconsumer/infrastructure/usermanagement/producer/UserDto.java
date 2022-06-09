package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static lombok.AccessLevel.PACKAGE;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = PACKAGE)
@ToString
public class UserDto {
    private Long id;
    private String login;
    private String password;
    private String group;

    UserDto(String login, String password, String group) {
        this.login = login;
        this.password = password;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        return new EqualsBuilder().append(id, userDto.id).append(login, userDto.login).append(group, userDto.group).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(login).append(group).toHashCode();
    }
}
