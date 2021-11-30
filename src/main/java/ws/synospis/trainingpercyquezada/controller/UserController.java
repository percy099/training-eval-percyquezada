package ws.synospis.trainingpercyquezada.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ws.synospis.trainingpercyquezada.bean.request.UserRequest;
import ws.synospis.trainingpercyquezada.exception.TrainingException;
import ws.synospis.trainingpercyquezada.model.User;
import ws.synospis.trainingpercyquezada.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/users")
public class UserController {
	private final UserService userService;
	
	@PostMapping("")
	public ResponseEntity<?> add(@RequestBody UserRequest userReq) throws TrainingException{
		if(userReq.getLastName().equals("")) {
			throw new TrainingException("Los apellidos no pueden estar vac\\u00EDos");
		}
		
		if(userReq.getNames().equals("")) {
			throw new TrainingException("Los nombres no pueden estar vac\\u00EDos");
		}
		
		if(userReq.getPhone().equals("")) {
			throw new TrainingException("El celular no puede ser vac\\\\u00EDo");
		}
		
		if (!userService.add(userReq)){
			throw new TrainingException("El celular ingresado ya existe en la BD");
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("")
	public List<User> list(){
		return this.userService.list();
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<?> update(@PathVariable("userId") String userId, @RequestBody UserRequest userReq) throws TrainingException{
		if(userReq.getLastName().equals("")) {
			throw new TrainingException("Los apellidos no pueden estar vac\\u00EDos");
		}
		
		if(userReq.getNames().equals("")) {
			throw new TrainingException("Los nombres no pueden estar vac\\u00EDos");
		}
		
		if(userReq.getPhone().equals("")) {
			throw new TrainingException("El celular no puede ser vac\\\\u00EDo");
		}
		
		
		if (!userService.update(userReq, userId)) {
			throw new TrainingException("El ID de usuario no existe");
		}
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") String userId) throws TrainingException {
		return this.userService.getUser(userId);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> remove(@PathVariable("userId") String userId) throws TrainingException{
		if(!userService.remove(userId)) {
			throw new TrainingException("El ID de usuario no existe");
		}
		return ResponseEntity.ok().build();
	}
}
