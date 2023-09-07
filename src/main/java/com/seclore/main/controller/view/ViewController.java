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
		System.out.println("A");
		return new ModelAndView("index.jsp");
	}

	@GetMapping("/login")
	ModelAndView loadLoginPage() {
		System.out.println("B");
		return new ModelAndView("index");
	}

	@GetMapping("/signup")
	ModelAndView loadSignUpPage() {
		System.out.println("C");
		return new ModelAndView("/WEB_INF/views/index.jsp");
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
