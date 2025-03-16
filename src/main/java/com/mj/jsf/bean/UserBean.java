package com.mj.jsf.bean;

import com.mj.jsf.enitity.User;
import com.mj.jsf.repository.UserRepository;
import jakarta.enterprise.context.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@RequestScoped
@Component
public class UserBean {

    @Autowired
    private UserRepository userRepository;

    private User user = new User();
    private String loginEmail;
    private String loginPassword;
    private String message;
    private User loggedInUser;

    // Registration
    public void saveUser() {
        if (userRepository.existsByEmail(user.getEmail())) {
            message = "Email already exists!";
        } else {
            userRepository.save(user);
            user = new User(); // Reset after saving
            message = "User registered successfully!";
        }
    }

    // Login
    public String loginUser() {
        User foundUser = userRepository.findByEmailAndPassword(loginEmail, loginPassword);
        if (foundUser != null) {
            loggedInUser = foundUser;
            return "home.xhtml?faces-redirect=true"; // Redirect after successful login
        } else {
            message = "Invalid credentials!";
            return null; // Stay on the same page
        }
    }

    // Get all users
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // Getters & Setters
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getLoginEmail() { return loginEmail; }
    public void setLoginEmail(String loginEmail) { this.loginEmail = loginEmail; }

    public String getLoginPassword() { return loginPassword; }
    public void setLoginPassword(String loginPassword) { this.loginPassword = loginPassword; }

    public User getLoggedInUser() { return loggedInUser; }
    public void setLoggedInUser(User loggedInUser) { this.loggedInUser = loggedInUser; }
}
