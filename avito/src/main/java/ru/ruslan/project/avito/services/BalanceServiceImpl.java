package ru.ruslan.project.avito.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.ruslan.project.avito.dto.ProductsForm;
import ru.ruslan.project.avito.models.Products;
import ru.ruslan.project.avito.models.User;
import ru.ruslan.project.avito.repositories.ProductsRepository;
import ru.ruslan.project.avito.repositories.UsersRepository;

@Component
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void update(Double balance) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User entity = usersRepository.findByNick(auth.getName());
        if(entity != null){
            entity.setBalance(entity.getBalance() + balance);
            usersRepository.save(entity);
        }
    }

    @Override
    public User find(String nick) {
        return usersRepository.findByNick(nick);
    }

}
