package ru.ruslan.project.avito.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ruslan.project.avito.dto.UserDto;
import ru.ruslan.project.avito.models.User;
import ru.ruslan.project.avito.repositories.UsersRepository;

import java.util.List;
import static ru.ruslan.project.avito.dto.UserDto.*;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public void banAll() {
        List<User> users = usersRepository.findAll();
        for (User user : users) {
            if (!user.isAdmin()) {
                user.setState(User.State.BANNED);
                usersRepository.save(user);
            }
        }
    }

    @Override
    public User find(String nick) {
        return usersRepository.findByNick(nick);
    }
}
