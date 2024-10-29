package com.obs.OBS.user;

import java.util.Optional;
import org.springframework.stereotype.Component;

@Component

public class UserDAOImpl implements UserDAO{
  private final UserRepository repository;
  public UserDAOImpl(UserRepository repository){
    this.repository = repository;
  }
  @Override
  public Optional<User> findByEmail(String email) {
    return repository.findByEmail(email);
  }
}
