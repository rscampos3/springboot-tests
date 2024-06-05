package br.com.dicasdeumdev.springboottests.services.impl;

import br.com.dicasdeumdev.springboottests.domain.User;
import br.com.dicasdeumdev.springboottests.domain.dto.UserDTO;
import br.com.dicasdeumdev.springboottests.repository.UserRepository;
import br.com.dicasdeumdev.springboottests.services.IUserService;
import br.com.dicasdeumdev.springboottests.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() ->  new ObjectNotFoundException("Objeto não encontrado!"));
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        return this.userRepository.save(mapper.map(userDTO, User.class));
    }
}
