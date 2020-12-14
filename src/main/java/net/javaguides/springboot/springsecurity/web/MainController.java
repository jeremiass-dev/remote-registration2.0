package net.javaguides.springboot.springsecurity.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.springsecurity.repository.StudentRepository;


@Controller
@RequestMapping("/")
public class MainController {
	private final StudentRepository studentRepository;

	@Autowired
	public MainController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

    @GetMapping("/")
    public String root(Model model) {
    	model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}
}
