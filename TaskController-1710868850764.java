// TaskController.java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private final List<Task> taskList = new ArrayList<>();

    @GetMapping("/tasks")
    public String showTasks(Model model) {
        model.addAttribute("tasks", taskList);
        return "tasks";
    }

    @GetMapping("/create-task")
    public String showCreateTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "create-task";
    }

    @PostMapping("/create-task")
    public String createTask(@ModelAttribute Task task) {
        taskList.add(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit-task/{index}")
    public String showEditTaskForm(@PathVariable int index, Model model) {
        model.addAttribute("task", taskList.get(index));
        return "edit-task";
    }

    @PostMapping("/edit-task/{index}")
    public String editTask(@PathVariable int index, @ModelAttribute Task updatedTask) {
        taskList.set(index, updatedTask);
        return "redirect:/tasks";
    }
}
