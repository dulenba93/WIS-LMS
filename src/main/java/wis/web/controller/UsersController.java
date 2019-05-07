package wis.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import wis.domain.Users;
import wis.service.UsersService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService usersService;

	//@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Users>> getUsers(){
		
		return new ResponseEntity<Iterable<Users>>(usersService.getAllUsers(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Users> getUserById(@PathVariable Long id){
		Optional<Users> user = usersService.getUsersById(id);
		if(user.isPresent()) {
			return new ResponseEntity<Users>(user.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
	}
	
    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        usersService.addUser(user);
        return new ResponseEntity<Users>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
        usersService.updateUser(id, user);
        return new ResponseEntity<Users>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Users> removeUser(@PathVariable Long id) {
        try {
            usersService.removeUser(id);
        }catch (Exception e) {
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
    }

	
}
