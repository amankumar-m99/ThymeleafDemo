package indeedcoder.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		employees.add(new Employee("ABC", 30, 12000, null));
		employees.add(new Employee("MNO", 32, 18000, null));
		employees.add(new Employee("PQR", 40, 32000, null));
		employees.add(new Employee("XYZ", 43, 52000, null));
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

	@GetMapping("/query")
	public String getQueryParamsPage(
			@RequestParam("name") String name,
			@RequestParam("id") Integer id,
			@RequestParam(value="msg", required = false, defaultValue = "NO-MSG") String msg,
			@RequestParam("marks") List<Integer> marks,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("msg", msg);
		model.addAttribute("marks", marks);
		return "QueryPage";
	}

	//redirection
	@GetMapping("/redirect")
	public String getFirstPage() {
		System.out.println("Calling the redirection method.");
		return "redirect:redirectedPage";
	}

	@GetMapping("/redirectedPage")
	public String getRedirectedPage() {
		return "RedirectedPage";
	}

	//bi-directional form binding
	@GetMapping("/editemployee")
	public String getEditEmployeeForm(Model m) {
		Map<Integer, String> depts = Map.of(
				11,"DEV",
				12,"QA",
				13,"BA",
				14,"AC"
				);
		Employee employee = new Employee("AmanK", 100, 120, 11);
		m.addAttribute("emp", employee);
		m.addAttribute("depts", depts);
		return "EditEmployee";
	}

}
