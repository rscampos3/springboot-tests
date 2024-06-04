package br.com.dicasdeumdev.springboottests.services;

import br.com.dicasdeumdev.springboottests.domain.User;

public interface IUserService {
    User findById(Integer id);
}
