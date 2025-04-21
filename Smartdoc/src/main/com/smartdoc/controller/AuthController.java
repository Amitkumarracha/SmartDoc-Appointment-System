package main.com.smartdoc.controller;

import main.com.smartdoc.service.AuthService;

public class AuthController {
    private AuthService authService;
    
    public AuthController() {
        this.authService = new AuthService();
    }
    
    public String login(String username, String password) {
        // You can add hashing + validation logic here later
        return authService.login(username, password);
    }

    public String register(String username, String password) {
        return authService.register(username, password);
    }
}
