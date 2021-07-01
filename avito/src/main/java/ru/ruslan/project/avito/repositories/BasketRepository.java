package ru.ruslan.project.avito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ruslan.project.avito.models.Basket;
import ru.ruslan.project.avito.models.Products;

import java.util.List;


public interface BasketRepository extends JpaRepository<Basket, Long> {
    List<Basket> findAllByNick(String nick);
    @Query(nativeQuery = true, value = "DELETE FROM basket WHERE nick = :nick returning 1")
    void delete(String nick);
    @Query(nativeQuery = true, value = "DELETE FROM basket WHERE name = :name returning 1")
    void delete_pro(String name);
}
