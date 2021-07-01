package ru.ruslan.project.avito.services;

import ru.ruslan.project.avito.models.User;

public interface BalanceService {
    User find(String nick);
    void update(Double balance);
}
