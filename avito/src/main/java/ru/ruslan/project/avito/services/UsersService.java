package ru.ruslan.project.avito.services;

import ru.ruslan.project.avito.dto.UserDto;
import ru.ruslan.project.avito.models.User;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
    User find(String nick);

    void banAll();
}
