package br.com.dicasdeumdev.springboottests.services;

import br.com.dicasdeumdev.springboottests.domain.User;
import br.com.dicasdeumdev.springboottests.domain.dto.UserDTO;

import java.util.List;

public interface IUserService {
    User findById(Integer id);
    List<User> getAll();
    User create(UserDTO userDTO);
}
