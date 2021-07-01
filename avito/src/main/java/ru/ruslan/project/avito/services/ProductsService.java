package ru.ruslan.project.avito.services;

import ru.ruslan.project.avito.dto.ProductsForm;
import ru.ruslan.project.avito.dto.UserDto;
import ru.ruslan.project.avito.models.Products;

import java.util.List;

public interface ProductsService {
    List<Products> findNick(String nick);
    void delete(String name);
    List<Products> all(String nick);
    void add(ProductsForm form);
}
