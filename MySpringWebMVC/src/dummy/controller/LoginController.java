package dummy.controller;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dummy.model.User;
import dummy.service.CSVFileService;

@Controller
public class LoginController {
	@Autowired
	CSVFileService service;
	private String feedback;
	private String filePath;
	private File convFile;
	
	@GetMapping("/")
	public String welcome() {
		return "Login";
	}
	
	@RequestMapping(value = "addNewUser", method=RequestMethod.POST)
	public @ResponseBody User addNewUser(@RequestBody Map<String, String> userMap) {
		User user = new User();
		user.setUsername(userMap.get("username").toString());
		user.setPassword(userMap.get("password").toString());
		filePath  = userMap.get("file");
		System.out.println("File uploaded successfully:"+filePath);
		convFile = new File(filePath);
		user.setConvFile(convFile);
		feedback= service.createRow(user);
		System.out.println(feedback);
		return user;
	}
	
	@RequestMapping(value = "printAllUsers", method= RequestMethod.GET)
	@ResponseBody
	public void printAllUsers() {
		feedback= service.printAllUsers();
		System.out.println(feedback);
		return;
		
	}

}
