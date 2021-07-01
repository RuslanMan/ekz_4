package ru.ruslan.project.avito.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.ruslan.project.avito.models.Basket;
import ru.ruslan.project.avito.models.Products;
import ru.ruslan.project.avito.models.User;
import ru.ruslan.project.avito.repositories.ProductsRepository;
import ru.ruslan.project.avito.repositories.BasketRepository;

import java.util.List;

@Component
public class BasketServiceImpl implements BasketService {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private BalanceService balanceService;

    @Override
    public void add(String name) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Products entity = productsRepository.findByName(name);
        Basket newBasket = Basket.builder()
                .nick(auth.getName())
                .name(entity.getName())
                .filename(entity.getFilename())
                .price(entity.getPrice())
                .build();
        basketRepository.save(newBasket);
        productsRepository.delete(name);
    }

    @Override
    public List<Basket> find() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Basket> entity = basketRepository.findAllByNick(auth.getName());
        return entity;
    }

    @Override
    public void buy() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        List<Basket> entity = basketRepository.findAllByNick(auth.getName());
        double mas = 0;
        for (Basket i:entity) {
            mas = mas + i.getPrice();
        }
        if(entity != null){
            balanceService.update(-mas);
            
            basketRepository.delete(auth.getName());
        }
    }

    @Override
    public void delete(String name){
        basketRepository.delete_pro(name);
    }
}
