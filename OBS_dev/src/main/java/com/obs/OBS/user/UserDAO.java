package com.obs.OBS.user;

import java.util.Optional;

public interface UserDAO {
  Optional<User> findByEmail(String email);
}
