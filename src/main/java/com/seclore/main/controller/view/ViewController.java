package com.seclore.main.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * The ViewController class is responsible for handling requests related to view rendering.
 * It provides endpoints for rendering various jsp pages, such as the home page, login page,
 * signup page, user dashboard page, and pages for editing and creating TODOs.
 *
 * @Controller Indicates that this class is a controller for handling web requests.
 * @RequestMapping("/view") Specifies the base URL path for mapping this controller's endpoints.
 */
@Controller
@RequestMapping("/view")
public class ViewController {

	/**
     * Loads the home page.
     */
	@RequestMapping("")
	String loadHomePage() {
		return "index";
	}

	/**
     * Loads the login page.
     */
	@RequestMapping("/login")
	ModelAndView loadLoginPage() {
		return new ModelAndView("login");
	}

	/**
     * Loads the signup page.
     */
	@GetMapping("/signup")
	ModelAndView loadSignUpPage() {
		return new ModelAndView("signup");
	}

	/**
     * Loads the user specific dashboard page.
     */
	@GetMapping("/dashboard")
	ModelAndView loadUserDashboardPage() {
		return new ModelAndView("dashboard");
	}

	/**
     * Loads the todo specific edit page; if the user is authorized to edit it
     */
	@GetMapping("/todo/edit")
	ModelAndView loadEditTodoPage() {
		return new ModelAndView("edittodo");
	}

	/**
     * Loads the create new todo page.
     */
	@GetMapping("/todo/new")
	ModelAndView loadCreateTodoPage() {
		return new ModelAndView("createtodo");
	}

}
