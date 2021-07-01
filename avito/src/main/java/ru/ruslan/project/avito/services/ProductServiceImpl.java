package ru.ruslan.project.avito.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ruslan.project.avito.dto.ProductsForm;
import ru.ruslan.project.avito.dto.UserDto;
import ru.ruslan.project.avito.models.Products;
import ru.ruslan.project.avito.repositories.ProductsRepository;

import java.util.List;

import static ru.ruslan.project.avito.dto.UserDto.from;

@Component
public class ProductServiceImpl implements ProductsService{
    @Autowired
    private ProductsRepository productsRepository;


    @Override
    public void add(ProductsForm form) {
        System.out.println(form);
        Products newProduct = Products.builder()
                .name(form.getName())
                .nick(form.getNick())
                .filename(form.getFilename())
                .price(form.getPrice())
                .build();
        System.out.println(newProduct);
        productsRepository.save(newProduct);
    }

    @Override
    public List<Products> findNick(String nick) {
        return productsRepository.findAllByNick(nick);
    }

    @Override
    public List<Products> all(String nick) {
        return productsRepository.AllProduct(nick);
    }

    @Override
    public void delete(String name) {
        productsRepository.delete(name);
    }
}
