package ru.ruslan.project.avito.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.ruslan.project.avito.dto.UserForm;
import ru.ruslan.project.avito.models.User;
import ru.ruslan.project.avito.repositories.UsersRepository;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm form) {
        User userEmail = usersRepository.findByEmail(form.getEmail());
        User userNick = usersRepository.findByNick(form.getNick());
        if (userNick == null && userEmail == null) {
            User newUser = User.builder()
                    .email(form.getEmail())
                    .activationCode(UUID.randomUUID().toString())
                    .nick(form.getNick())
                    .hashPassword(passwordEncoder.encode(form.getPassword()))
                    .balance(0.0)
                    .role(User.Role.USER)
                    .state(User.State.BANNED)
                    .build();

            usersRepository.save(newUser);


            if (!StringUtils.isEmpty(newUser.getEmail())) {
                String message = String.format(
                        "Hello, %s! \n" +
                                "Welcome to Sweater. Please, visit next link: http://localhost:8080/activate/%s",
                        newUser.getNick(),
                        newUser.getActivationCode()
                );

                mailSender.send(newUser.getEmail(), "Activation code", message);
            }
        }
    }

    @Override
    public boolean activateUser(String code) {
        System.out.println(code);
        User user = usersRepository.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);
        user.setActive();

        usersRepository.save(user);

        return true;
    }
}
