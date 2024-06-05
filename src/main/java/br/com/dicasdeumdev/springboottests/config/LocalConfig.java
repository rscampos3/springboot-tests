package br.com.dicasdeumdev.springboottests.config;

import br.com.dicasdeumdev.springboottests.domain.User;
import br.com.dicasdeumdev.springboottests.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;


@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public List<User> startDB(){
        User u1 = new User(null, "Valdir", "valdir@email.com", "34jif");
        User u2 = new User(null, "Rodrigo", "rod@email.com", "34jif");
        return this.userRepository.saveAll(List.of(u1, u2));
    }
}
