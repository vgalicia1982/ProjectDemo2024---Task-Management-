// UserController.java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final List<User> registeredUsers = new ArrayList<>();

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userAlreadyRegistered(user)) {
            model.addAttribute("error", "Username or email already registered");
            return "register";
        }

        registeredUsers.add(user);
        return "redirect:/registration-success";
    }

    private boolean userAlreadyRegistered(User user) {
        return registeredUsers.stream()
                .anyMatch(u -> u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail()));
    }
}
