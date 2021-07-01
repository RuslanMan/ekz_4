package ru.ruslan.project.avito.services;

import ru.ruslan.project.avito.dto.UserForm;

public interface SignUpService {
    void signUp(UserForm form);

    boolean activateUser(String code);
}
