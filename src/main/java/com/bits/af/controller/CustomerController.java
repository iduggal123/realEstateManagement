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

import com.bits.af.entities.Customer;
import com.bits.af.repository.CustomerRepository;
import com.bits.af.utils.CommonUtils;

@RestController
@RequestMapping("/users")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Customer>> listAll() {
		List<Customer> customers = customerRepo.findAll();
		System.out.println(customers);
		return ResponseEntity.ok(customers);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Customer> listById(@PathVariable Integer id) {
		Optional<Customer> customers = customerRepo.findById(id);

		if (customers.isPresent())
			return ResponseEntity.ok(customers.get());
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "/login")
	public ResponseEntity loginUser(@RequestBody Customer request) throws Exception {
		String clientPassword = "";
		try {
			List<Customer> clients = customerRepo.findByClientEmailAddress(request.getClientEmailAddress());
			if (clients.size() <= 0) {
				return new ResponseEntity<>(String.format("User with email [%s] does not exist, please signup.",
						request.getClientEmailAddress()), HttpStatus.NOT_ACCEPTABLE);
			} else {
				clientPassword = clients.get(0).getClientPassword();
				if (clientPassword.equals(request.getClientPassword())) {

					return new ResponseEntity<>(String.format("User is logged in.", request.getClientEmailAddress()),
							HttpStatus.OK);
				} else {
					return new ResponseEntity<>(String.format("Invalid credentials. Please try again."),
							HttpStatus.UNAUTHORIZED);
				}
			}
		} catch (Exception e) {
			System.out.println(String.format("Could not login the user due to [%s]", e.getMessage()));
			return new ResponseEntity<>("We are sorry, bad response!", HttpStatus.BAD_REQUEST);

		}
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "/signup")
	public ResponseEntity registerUser(@RequestBody Customer request) throws Exception {
		CommonUtils util = new CommonUtils();
		String clientUniqueId = "";
		Customer customer = new Customer();
		if (customerRepo.existsByclientEmailAddress(request.getClientEmailAddress())) {
			return new ResponseEntity<>(
					String.format("User with email [%s] already exists, try login", request.getClientEmailAddress()),
					HttpStatus.NOT_ACCEPTABLE);

		} else {
			clientUniqueId = util.base64Encode(request.getClientEmailAddress());
			request.setClientUniqueId(clientUniqueId);
			BeanUtils.copyProperties(request, customer);
		}
		try {
			customer = customerRepo.save(customer);
			return new ResponseEntity<>("User is registerd successfully.", HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(String.format("Could not register the user due to [%s]", e.getMessage()));
			return new ResponseEntity<>("We are sorry, bad response!", HttpStatus.BAD_REQUEST);

		}
	}

}