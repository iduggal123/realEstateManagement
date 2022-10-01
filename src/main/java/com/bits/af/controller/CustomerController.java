package com.bits.af.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
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

		HashMap<String, Object> status = new HashMap<String, Object>();
		String clientPassword = "";
		try {
			List<Customer> clients = customerRepo.findByClientEmailAddress(request.getClientEmailAddress());
			if (clients.size() <= 0) {
				status.put("errorCode", 1);
				status.put("error", String.format("User with email [%s] does not exist, please signup.",
						request.getClientEmailAddress()));

				return new ResponseEntity<>(status, HttpStatus.OK);
			} else {
				clientPassword = clients.get(0).getClientPassword();
				if (clientPassword.equals(request.getClientPassword())) {
					
					//setting the cookie to identify current logged in user
					HttpCookie cookie = ResponseCookie
							.from("userinfo", request.getClientEmailAddress() + "####" + clients.get(0).getClientId())
							.path("/").build();

					status.put("errorCode", 0);
					System.out.println(String.format("User [%s] is logged in.", request.getClientEmailAddress()));
					return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(status);
				} else {
					status.put("errorCode", 1);
					status.put("error", String.format("Invalid credentials. Please try again."));
					return new ResponseEntity<>(status, HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			status.put("errorCode", 2);
			status.put("error", String.format("Could not login the user due to [%s]", e.getMessage()));
			System.out.println(String.format("Could not login the user due to [%s]", e.getMessage()));
			return new ResponseEntity<>("We are sorry, bad response!", HttpStatus.OK);

		}
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "/signup")
	public ResponseEntity registerUser(@RequestBody Customer request) throws Exception {
		HashMap<String, Object> status = new HashMap<String, Object>();
		CommonUtils util = new CommonUtils();
		String clientUniqueId = "";
		Customer customer = new Customer();
		if (customerRepo.existsByclientEmailAddress(request.getClientEmailAddress())) {
			status.put("errorCode", 1);
			status.put("error",
					String.format("User with email [%s] already exists, try login", request.getClientEmailAddress()));

			return new ResponseEntity<>(status, HttpStatus.OK);

		} else {
			clientUniqueId = util.base64Encode(request.getClientEmailAddress());
			request.setClientUniqueId(clientUniqueId);
			BeanUtils.copyProperties(request, customer);
		}
		try {
			customer = customerRepo.save(customer);
			System.out.println("User is registerd successfully.");
			status.put("errorCode", 0);
			return new ResponseEntity<>(status, HttpStatus.OK);
		} catch (Exception e) {
			status.put("errorCode", 2);
			status.put("error",
					String.format(String.format("Could not register the user due to [%s]", e.getMessage())));

			System.out.println(String.format("Could not register the user due to [%s]", e.getMessage()));
			return new ResponseEntity<>(status, HttpStatus.OK);

		}
	}

}