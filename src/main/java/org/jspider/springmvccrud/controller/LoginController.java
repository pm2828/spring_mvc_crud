package org.jspider.springmvccrud.controller;

;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {

        // Perform authentication logic here
        if (isValidUser(username, password)) {
            // Set a session attribute to indicate the user is logged in
            session.setAttribute("loggedIn", true);
            session.setAttribute("username", username);

            return "redirect:/books"; // Redirect to the main page after successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Show login form with error message
        }
    }

    // Replace this method with your actual authentication logic
    private boolean isValidUser(String username, String password) {
        // Hardcode the valid username and password
        String validUsername = "admin";
        String validPassword = "password";

        // Check if the provided username and password match the valid credentials
        return username.equals(validUsername) && password.equals(validPassword);
    }
}
