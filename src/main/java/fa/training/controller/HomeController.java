package fa.training.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.training.dto.LoginDTO;
import fa.training.dto.UserDTO;
import fa.training.entities.Company;
import fa.training.entities.Position;
import fa.training.entities.User;
import fa.training.services.CompanyServices;
import fa.training.services.impl.CompanyServicesImpl;
import fa.training.services.impl.PositionServicesImpl;
import fa.training.services.impl.UserServicesImpl;

@Controller
public class HomeController {

	@Autowired
	UserServicesImpl userServices;

	@Autowired
	PositionServicesImpl positionServices;

	@Autowired
	CompanyServicesImpl comServices;

	public HomeController() {
		System.out.println("Ctor HomeCtroller11");
	}

	@RequestMapping(value = "/")
	public String listStudent(Model model) {
		return "index";
	}


	@GetMapping("/login")
	public String login(Model model) {
		if (!model.containsAttribute("loginDTO")) {
			model.addAttribute("loginDTO", new LoginDTO());
		}
		return "login";
	}

	@GetMapping("/logout")
	public String login(HttpSession session) {
		User user = null;
		user = (User) session.getAttribute("User");
		if (user != null) {
			session.removeAttribute("User");
			return "redirect:/";
		}
		return "login";
	}

	@PostMapping("/login")
	public String logins(ModelMap map, HttpSession session, @Valid @ModelAttribute("loginDTO") LoginDTO dto,
			BindingResult br) {
		if (br.hasErrors()) {
			return "login";
		} else {
			User user = null;
			user = userServices.login(dto);
			if (user != null) {
				System.out.println(user.toString());
				session.setAttribute("User", user);
				return "redirect:/";
			} else {
				map.addAttribute("error", "Tài khoản hoặc mật khẩu không hơp lệ");
				return "login";
			}

		}

	}
	
	

}
