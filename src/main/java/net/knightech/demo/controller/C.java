package net.knightech.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.knightech.demo.Customer;
import net.knightech.demo.CustomerRepository;

@RestController
public class C {

    @Autowired CustomerRepository customerRepository;

    @Autowired RestTemplate restTemplate;
    
    @GetMapping("/name")
    public Customer getOrSave(@RequestParam(value="name") String name){
        Customer customer = customerRepository.findByFirstName(name);
        if(customer==null){
            customer = customerRepository.save(new Customer(name, name));
        }

        String tesla = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<String> response
                        = restTemplate.getForEntity(tesla + "/1", String.class);

        return customer;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class UserNotFoundException extends RuntimeException {

        public UserNotFoundException(String userId) {
            super("could not find user '" + userId + "'.");
        }
    }
}
