package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.johnsunday.app.entity.EmployeeType;
import com.johnsunday.app.service.EmployeeTypeServiceImpl;

@CrossOrigin(origins="*")
@RequestMapping("api/v1/employee_type")
@RestController
public class EmployeeTypeControllerImpl implements IEmployeeTypeController<EmployeeType> {

	
	@Autowired
	private EmployeeTypeServiceImpl employeeTypeService;
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/")	
	public ResponseEntity<?> getAllEmployeeType() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.findAll());
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to SHOW all employee types\"}");
		}
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{employeeTypeId}")
	//@ResponseBody
	public ResponseEntity<?> getEmployeeTypeById(@PathVariable("employeeTypeId")Integer employeeTypeId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.findById(employeeTypeId));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please, Try it later. NOT possible to SHOW the employee type which you find.\"}");
		}
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/")
	//@ResponseBody
	public ResponseEntity<?> saveEmployeeType(@RequestBody @Valid EmployeeType employeeType) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.save(employeeType));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to SAVE the employee type.\"}");
		}
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{employeeTypeId}")
	//@ResponseBody
	public ResponseEntity<?> deleteEmployeeType(@PathVariable("employeeTypeId")Integer employeeTypeId) {
		try {						
			return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.delete(employeeTypeId));			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible to DELETE the employee type.\"}");
		}
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/{employeeTypeId}")	
	public ResponseEntity<?> updateEmployeeType(@RequestBody @Valid EmployeeType employeeType,
											    @PathVariable("employeeTypeId")Integer employeeTypeId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.update(employeeTypeId,employeeType));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please, Try it later. It is NOT possible UPDATE the employee type which you are looking for.\"}");
		}
	}
}
