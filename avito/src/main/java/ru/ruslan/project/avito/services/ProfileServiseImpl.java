package ru.ruslan.project.avito.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.ruslan.project.avito.models.User;
import ru.ruslan.project.avito.repositories.UsersRepository;

@Component
public class ProfileServiseImpl implements ProfileService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void update(String filename) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User entity = usersRepository.findByNick(auth.getName());
        System.out.println(auth.getName());
        System.out.println(entity);
        if(entity != null){
            entity.setFilename(filename);
            System.out.println(entity);
            usersRepository.save(entity);

        }
    }
}
