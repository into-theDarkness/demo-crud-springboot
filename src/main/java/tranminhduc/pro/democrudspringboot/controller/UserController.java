package tranminhduc.pro.democrudspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tranminhduc.pro.democrudspringboot.model.User;
import tranminhduc.pro.democrudspringboot.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listUsers(){
        List<User> users = (List<User>) userService.findAll();
        if (users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    @RequestMapping(value ="/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<User>> getUser(@PathVariable("id") long id){
        Optional<User> user  = userService.findById(id);
        if(user == null){
            System.out.println("User with id" + id + "not found");
            return new ResponseEntity<Optional<User>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
    }
    @RequestMapping(value ="/users", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
        System.out.println("Creating User" + user.getName());
        userService.save(user);
        HttpHeaders headers =  new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}

  