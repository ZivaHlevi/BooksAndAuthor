package com.jb.bookandauthor.clr;

import com.jb.bookandauthor.beans.Author;
import com.jb.bookandauthor.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class RestTemplateWeb implements CommandLineRunner {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        final String URL = "http://localhost:8080/api/library";
        //{get author #5}
        Author author1 = restTemplate.getForObject(URL + "/" + 5, Author.class);
        System.out.println(author1);
        //all books in library
        ResponseEntity<Book[]> response1 = restTemplate.getForEntity(URL, Book[].class);
        System.out.println(Arrays.asList(response1.getBody()));

        // @GetMapping("/{from}/{until}")1950-2000
        ResponseEntity<Book[]> response2 = restTemplate.getForEntity(URL+"/"+1950+"/"+2000, Book[].class);
        System.out.println(Arrays.asList(response2.getBody()));
//
        // @GetMapping("/avg/{authorId}")
        ResponseEntity<Double> response3 = restTemplate.getForEntity(URL+"/avg/"+3, Double.class);
        System.out.println("avg of author #5 is: "+Arrays.asList(response3.getBody()));

        // @PostMapping
        Author a = Author.builder().name("Author111").books(null).build();
        ResponseEntity<HttpStatus> response = restTemplate.postForEntity(URL, a, HttpStatus.class);
        System.out.println(response.getBody());

//        //update-no need
//
        //delete
        restTemplate.delete(URL+ "/" + 5);
//

        /*

@Service
public class PersonClientImpl implements PersonClient {

	@Autowired
	RestTemplate restTemplate;

	final String ROOT_URI = "https://localhost:8080/springData/person";

	public List<Person> getAllPerson() {
		ResponseEntity<Person[]> response = restTemplate.getForEntity(ROOT_URI, Person[].class);
		return Arrays.asList(response.getBody());

	}

	public Person getById(Long id) {
		ResponseEntity<Person> response = restTemplate.getForEntity(ROOT_URI + "/"+id, Person.class);
		return response.getBody();
	}

	public HttpStatus addPerson(Person person) {
		ResponseEntity<HttpStatus> response = restTemplate.postForEntity(ROOT_URI, person, HttpStatus.class);
		return response.getBody();
	}

	public void updatePerson(Person person) {
		restTemplate.put(ROOT_URI, person);
	}

	public void deletePerson(Long id) {
		restTemplate.delete(ROOT_URI + id);

         */

    }
}
