package com.example.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.domein.User;
import com.example.form.UserForm;


@Controller
@RequestMapping("/ex04")
public class Exam04Controller {

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam04";
	}

	@Autowired
	private HttpSession session;
	
	@RequestMapping("/create")
	public String create(@Validated UserForm form,BindingResult result,Model model) {
	
		if(result.hasErrors()) {
			return index();
		}
		
		User user = new User();
		BeanUtils.copyProperties(form, user);
		session.setAttribute("user", user);
		return "exam04-result";
		
	}
	
}
