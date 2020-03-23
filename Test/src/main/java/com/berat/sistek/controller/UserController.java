package com.berat.sistek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.berat.sistek.model.User;
import com.berat.sistek.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();

		model.setViewName("user/login");
		return model;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("user/signup");

		return model;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "Mail adresi kullanılıyor ! ");
		}
		if (bindingResult.hasErrors()) {
			model.setViewName("user/signup");
		} else {
			userService.saveUser(user);
			model.addObject("msg", "Kullanıcı kaydı başarılı !");
			model.addObject("user", new User());
			model.setViewName("user/signup");
		}

		return model;
	}

	@RequestMapping(value = { "/home/home" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		model.addObject("userId", user.getId());
		model.setViewName("home/home");
		return model;
	}

	@RequestMapping("/allUsers")
	public String getAllUsers(Model model) {
		model.addAttribute("users", userService.findAllUsers());
		return "user/userList";

	}

	@GetMapping(value = { "/edit/{id}" })
	public String editUser(@PathVariable long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "user/edit";
	}

	@PostMapping(value = { "/update/{id}" })
	public String updateUser(@PathVariable long id, @Valid User user, Model model, BindingResult result) {
		if (result.hasErrors()) {
			user.setId(id);
			return "user/edit";
		}

		userService.saveUser(user);
		model.addAttribute("msg", "Kullanıcı Güncellendi !");
		model.addAttribute("user", user);
		return "user/edit";
	}

	@RequestMapping(value = { "/access_denied" }, method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}

}