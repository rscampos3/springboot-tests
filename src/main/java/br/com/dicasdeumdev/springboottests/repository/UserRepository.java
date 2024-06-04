package br.com.dicasdeumdev.springboottests.repository;

import br.com.dicasdeumdev.springboottests.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
