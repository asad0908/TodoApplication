package com.seclore.main.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class ViewController {

	@RequestMapping("")
	String loadHomePage() {
		
		System.out.println("A");
		return "index";
	}

	@RequestMapping("/login")
	ModelAndView loadLoginPage() {
		return new ModelAndView("login");
	}

	@GetMapping("/signup")
	ModelAndView loadSignUpPage() {
		System.out.println("C");
		return new ModelAndView("signup");
	}

	@GetMapping("/dashboard")
	ModelAndView loadUserDashboardPage() {
		return new ModelAndView("dashboard");
	}

	@GetMapping("/todo/edit")
	ModelAndView loadEditTodoPage() {
		return new ModelAndView("edittodo");
	}

	@GetMapping("/todo/new")
	ModelAndView loadCreateTodoPage() {
		return new ModelAndView("createtodo");
	}

}
