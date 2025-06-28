package indeedcoder.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import indeedcoder.thymeleafdemo.model.Employee;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHome() {
		return "HomePage";
	}

	@GetMapping("/data")
	public String getData(Model m) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("ABC", 30, 12000));
		employees.add(new Employee("MNO", 32, 18000));
		employees.add(new Employee("PQR", 40, 32000));
		employees.add(new Employee("XYZ", 43, 52000));
		m.addAttribute("preparedBy", "Aman");
		m.addAttribute("employees", employees);
		return "DataPage";
	}

	@GetMapping("/myPage")
	public String getMyPage() {
		return "MyPage";
	}

	@GetMapping("/register")
	public String getRegistrationPage() {
		return "RegisterPage";
	}

	@PostMapping("/save")
	public String getSavePage(
			@ModelAttribute Employee employee, Model model) {
		model.addAttribute("emp", employee);
		return "SavePage";
	}
}
