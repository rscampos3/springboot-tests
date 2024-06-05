package br.com.dicasdeumdev.springboottests.resources;

import br.com.dicasdeumdev.springboottests.domain.User;
import br.com.dicasdeumdev.springboottests.domain.dto.UserDTO;
import br.com.dicasdeumdev.springboottests.services.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IUserService iUserService;

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(iUserService.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok()
                .body(getMap(this.iUserService.getAll()));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {

        return ResponseEntity.created(getUri(userDTO)).build();
    }

    private URI getUri(UserDTO userDTO) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(this.iUserService.create(userDTO).getId()).toUri();
    }

    private List<UserDTO> getMap(List<User> users) {
        return mapper.map(users, new TypeToken<List<UserDTO>>() {
        }.getType());
    }
}
