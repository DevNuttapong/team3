package com.example.accessingdatamysql.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.*;

import com.example.accessingdatamysql.model.Admin;
import com.example.accessingdatamysql.service.AdminService;

@Controller
public class AdminController {


	@Autowired    
	private AdminService adminService;


	/*
	 * @return list all admins in a JSONArray with JSONObjects transfermed from Admin models
	 */
	// @RequestMapping(path="/admins", method=RequestMethod.GET) 
	@GetMapping(path = "/admin") // Compliant
	public @ResponseBody ResponseEntity<Object> getAllAdmin() {

		Iterable<Admin> resultList = AdminService.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(resultList);
	}

	/*
	 * @param admin - the Admin model with name and optional email  
	 * @return a JSON Object with description "SAVED ID: <admin id>!" and the saved Admin model.
	 *         The Admin model contains four fields as follows:
	 * <ul>
	 *   <li>id - admin id</li>
	 *   <li>isActive - true as a default value for new admin</li>
	 *   <li>name - parametered name</li>
	 *   <li>email - parametered email</li>
	 * </ul>
	 */
	/*
	 * @return the number of admins
	 */
	// @RequestMapping(path="/admins", method=RequestMethod.POST) 
	@PostMapping(path = "/admins") // Compliantst
	public @ResponseBody ResponseEntity<Object> addAdmins(@RequestBody Admin admin) {

		Admin result = adminService.save(admin);

		HashMap<String, Object> map = new HashMap<>();
		map.put("description_555", String.format("SAVED ID: %s!", result.getId()));
		map.put("admin", result);
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}

	// @RequestMapping(path="/admins/count", method=RequestMethod.GET) 
	@GetMapping(path = "/admin/count") // Compliant
	public @ResponseBody ResponseEntity<Object> countAdmins(@RequestParam(name="isActive", defaultValue="true") boolean isActive) {

		int count = adminService.countAdmin(isActive);

		return ResponseEntity.status(HttpStatus.OK).body(count);
	}
}
