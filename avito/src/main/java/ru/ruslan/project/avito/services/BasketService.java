package ru.ruslan.project.avito.services;

import ru.ruslan.project.avito.dto.ProductsForm;
import ru.ruslan.project.avito.models.Basket;
import ru.ruslan.project.avito.models.Products;

import java.util.List;

public interface BasketService {
    void add(String name);
    List<Basket> find();
    void buy();
    void delete(String name);
}
