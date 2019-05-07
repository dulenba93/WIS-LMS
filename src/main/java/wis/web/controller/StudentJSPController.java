package wis.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import wis.service.StudentService;

public class StudentJSPController {
	
	@Autowired
	StudentService studentService;
	
//	@GetMapping({"/students"})
//	public String getStudentbyJmbg(Model model) {
//		model.addAttribute("student", studentService.findByCardNumber(cardNumber));
//		return "student";
//	}

}
