package ru.ruslan.project.avito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ruslan.project.avito.models.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import ru.ruslan.project.avito.models.User;
import ru.ruslan.project.avito.repositories.UsersRepository;
import ru.ruslan.project.avito.security.details.UserDetailsImpl;
import ru.ruslan.project.avito.services.UsersService;

@Controller
public class ChatController {

    @Autowired
    private UsersService usersService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @GetMapping("/index")
    public String getProductsPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", usersService.find(user.getUsername()));
        return "index";
    }
}
