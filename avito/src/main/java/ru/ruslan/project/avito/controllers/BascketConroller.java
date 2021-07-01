package ru.ruslan.project.avito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ruslan.project.avito.models.Products;
import ru.ruslan.project.avito.models.Basket;
import ru.ruslan.project.avito.models.User;
import ru.ruslan.project.avito.repositories.BasketRepository;
import ru.ruslan.project.avito.repositories.UsersRepository;
import ru.ruslan.project.avito.security.details.UserDetailsImpl;
import ru.ruslan.project.avito.services.BasketService;
import ru.ruslan.project.avito.services.UsersService;

import java.util.List;

@Controller
public class BascketConroller {

    @Autowired
    private BasketService basketService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/basket")
    public String getBascketPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", usersService.find(user.getUsername()));
        List<Basket> entity = basketService.find();
        System.out.println(entity);
        model.addAttribute("products", entity);
        return "basket";
    }

    @PostMapping("/basket")
    public String postBascketPage(@RequestParam("name") String name) {
        basketService.delete(name);
        return "redirect:/products";
    }

    @PostMapping("/basket_buy")
    public String postBascketPage() {
        System.out.println("zas");
        basketService.buy();
        return "redirect:/products";
    }
}
