package br.com.dicasdeumdev.springboottests.resources;

import br.com.dicasdeumdev.springboottests.domain.User;
import br.com.dicasdeumdev.springboottests.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserResource {

    @Autowired
    private IUserService iUserService;

    @GetMapping(value="/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok().body(iUserService.findById(id));
    }
}
