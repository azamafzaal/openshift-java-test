package com.example.demo.flyway;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass());

	@GetMapping(value = "/persons")
	public List<Person> readAll() {
		LOG.info("Displaying all person entries");
		return this.personRepository.findAll();
	}

	@GetMapping(value = "/persons/{id}")
	public Optional<Person> readOne(@PathVariable Long id) {
		LOG.info("Displaying one person entry");
		return this.personRepository.findById(id);
	}

}
