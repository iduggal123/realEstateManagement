package com.bits.af.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.af.entities.Property;
import com.bits.af.pojo.PropertyRequest;
import com.bits.af.repository.PropertyRepository;

@RestController
@RequestMapping("/property")
public class PropertyController {
	@Autowired
	private PropertyRepository propertyRepo;

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Property>> listAll() {
		List<Property> propertyInfo = propertyRepo.findAll();
		return ResponseEntity.ok(propertyInfo);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Property> listById(@PathVariable Integer id) {
		Optional<Property> properties = propertyRepo.findById(id);

		if (properties.isPresent())
			return ResponseEntity.ok(properties.get());
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity addProperty(@RequestBody PropertyRequest request) throws Exception {

		Property property = new Property();
		BeanUtils.copyProperties(request, property);
		try {
			property = propertyRepo.save(property);
			return new ResponseEntity<>("Property is listed.", HttpStatus.CREATED);
		} catch (Exception e) {
			throw new Exception("Could not process the listing" + e.getMessage());
		}
	}

}