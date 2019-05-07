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

import wis.domain.Title;
import wis.service.TitleService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/title")
public class TitleController {
	
	@Autowired
	TitleService ts;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Title>> getAllTitle() {
		return new ResponseEntity<Iterable<Title>>(ts.getTitle(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Title> addTitle(@RequestBody Title title) {
		ts.addTitle(title);
		return new ResponseEntity<Title>(title, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Title> updateTitle(@PathVariable Long id, @RequestBody Title title) {
		ts.updateTitle(id, title);
		return new ResponseEntity<Title>(title, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Title> getTitleById(@PathVariable Long id) {
		Optional<Title> title = ts.getTitle(id);
		if(title.isPresent()) {
			return new ResponseEntity<Title>(title.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Title>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Title> removeTitle(@PathVariable Long id) {
		try {
			ts.deleteTitle(id);
		}catch (Exception e) {
			return new ResponseEntity<Title>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Title>(HttpStatus.NO_CONTENT);
	}
	
}
