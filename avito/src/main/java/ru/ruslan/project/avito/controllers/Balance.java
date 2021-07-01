package ru.ruslan.project.avito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ruslan.project.avito.models.User;
import ru.ruslan.project.avito.repositories.UsersRepository;
import ru.ruslan.project.avito.security.details.UserDetailsImpl;
import ru.ruslan.project.avito.services.BalanceService;

@Controller
public class Balance {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/balance")
    public String getBalancePage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", balanceService.find(user.getUsername()));
        return "balance";
    }
    @PostMapping("/balance")
    public String signUp(@RequestParam("balance") Double balance) {
        balanceService.update(balance);
        return "redirect:/products";
    }
}

