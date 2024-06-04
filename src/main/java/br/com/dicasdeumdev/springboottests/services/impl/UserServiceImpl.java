package br.com.dicasdeumdev.springboottests.services.impl;

import br.com.dicasdeumdev.springboottests.domain.User;
import br.com.dicasdeumdev.springboottests.repository.UserRepository;
import br.com.dicasdeumdev.springboottests.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElse(null);
    }
}
