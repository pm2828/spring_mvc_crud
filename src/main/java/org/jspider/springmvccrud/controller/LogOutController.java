package org.jspider.springmvccrud.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LogOutController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session) {
        // Invalidate the session and redirect to the login page
        session.invalidate();

        return "redirect:/login";
    }
}
