package com.obs.OBS.auth;

import com.obs.OBS.user.User;
import com.obs.OBS.user.UserDAOImpl;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private UserDAOImpl userDAO;
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userDAO.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getType().name().toString()));
    log.info("test renvoi authorities " + authorities);
    return new org.springframework.security.core.userdetails.User(
        user.getEmail(),
        user.getPassword(),
        authorities
    );
  }
}
