package ru.ruslan.project.avito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.ruslan.project.avito.dto.ProductsForm;
import ru.ruslan.project.avito.dto.UserForm;
import ru.ruslan.project.avito.models.Products;
import ru.ruslan.project.avito.models.User;
import ru.ruslan.project.avito.repositories.ProductsRepository;
import ru.ruslan.project.avito.repositories.UsersRepository;
import ru.ruslan.project.avito.security.details.UserDetailsImpl;
import ru.ruslan.project.avito.services.BasketService;
import ru.ruslan.project.avito.services.ProductsService;
import ru.ruslan.project.avito.services.SignUpService;
import ru.ruslan.project.avito.services.UsersService;
;import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private BasketService basketService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/products")
    public String getProductsPage(@AuthenticationPrincipal UserDetailsImpl user,Model model) {
        List<Products> entity = productsService.all(user.getUsername());
        model.addAttribute("user", usersService.find(user.getUsername()));
        model.addAttribute("products", entity);
        return "products";
    }
    @PostMapping("/products")
    public String postProductsPage(@RequestParam("name") String name) {
        System.out.println(name);
        basketService.add(name);
        return "redirect:/products";
    }
    @GetMapping("/add_products")
    public String getadd_ProductsPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", usersService.find(user.getUsername()));
        return "add_products";
    }
    @PostMapping("/add_products")
    public String postProductsPage(ProductsForm form) {
        System.out.println(form);
        productsService.add(form);
        return "redirect:/products";
    }
    @GetMapping("/you_product")
    public String getyou_productsPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", usersService.find(user.getUsername()));
        List<Products> entity = productsService.findNick(user.getUsername());
        model.addAttribute("products", entity);
        return "you_product";
    }
    @PostMapping("/you_product")
    public String postYou_productPage(@RequestParam("name") String name) {
        productsService.delete(name);
        return "redirect:/products";
    }
}
