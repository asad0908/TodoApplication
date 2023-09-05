package com.seclore.main.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class ViewController {

	@GetMapping("")
	ModelAndView loadHomePage() {

		return null;
	}

	@GetMapping("/login")
	ModelAndView loadLoginPage() {

		return null;
	}

	@GetMapping("/signup")
	ModelAndView loadSignUpPage() {

		return null;
	}

	@GetMapping("/dashboard")
	ModelAndView loadUserDashboardPage() {

		return null;
	}

	@GetMapping("/todo/edit")
	ModelAndView loadEditTodoPage() {

		return null;
	}

	@GetMapping("/todo/new")
	ModelAndView loadCreateTodoPage() {

		return null;
	}

}
