package ru.ruslan.project.avito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ruslan.project.avito.models.Products;
import ru.ruslan.project.avito.models.User;

import java.util.List;
import java.util.Optional;


public interface ProductsRepository extends JpaRepository<Products, Long> {
    Products findByNick(String nick);
    Products findByName(String name);
    Products findById(Integer id);
    List<Products> findAllByNick(String nick);
    @Query(nativeQuery = true, value = "DELETE FROM products WHERE name = :name returning 1")
    void delete(String name);
    @Query(nativeQuery = true, value = "SELECT * FROM products WHERE nick != :nick")
    List<Products> AllProduct(String nick);
}
