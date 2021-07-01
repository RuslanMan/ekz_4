package ru.ruslan.project.avito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ruslan.project.avito.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByNick(String nick);

    User findByActivationCode(String code);
}
