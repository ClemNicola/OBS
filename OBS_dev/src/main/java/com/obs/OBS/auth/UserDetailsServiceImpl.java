package com.obs.OBS.auth;

import com.obs.OBS.user.User;
import com.obs.OBS.user.UserDAOImpl;
import com.obs.OBS.user.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private UserDAOImpl userDAO;
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userDAO.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    String role = user.getType() == UserType.SEEKER ? "JOBSEEKER" : "COMPANY";
    return org.springframework.security.core.userdetails.User.builder()
        .username(user.getEmail())
        .password(user.getPassword())
        .roles(role)
        .build();
  }
}
