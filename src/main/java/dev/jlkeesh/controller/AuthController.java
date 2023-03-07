package dev.jlkeesh.controller;

import dev.jlkeesh.dao.UserDAO;
import dev.jlkeesh.domain.User;
import dev.jlkeesh.dto.user.UserCreateDTO;
import dev.jlkeesh.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserDAO userDAO;
    private final UserMapper userMapper;


    public AuthController(UserDAO userDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }


    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "auth/signUp";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute UserCreateDTO dto) {
        if (!dto.password().equals(dto.confirmPassword())) {
            return "redirect:/auth/register";
        }
        if(dto.username().isEmpty() || dto.password().isEmpty() || dto.username().isBlank() || dto.password().isBlank() || dto.confirmPassword().isBlank()){
            return "redirect:/auth/register";
        }
        User user = userMapper.fromCreateDTO(dto);
        userDAO.save(user);
        return "redirect:/auth/login";
    }

}
