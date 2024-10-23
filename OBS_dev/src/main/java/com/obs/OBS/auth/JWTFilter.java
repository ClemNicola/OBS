package com.obs.OBS.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTFilter extends OncePerRequestFilter {
  @Autowired
  private JWTUtil util;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String token = getJWTFromRequest(request);

    if(StringUtils.hasText(token) && util.validateToken(token)){
      String email = util.getEmailFromJwt(token);

      List<String> roles = util.getRolesFromJwt(token);

      List<GrantedAuthority> authorities = roles.stream().map(
              SimpleGrantedAuthority::new)
          .collect(Collectors.toList());
      UserDetails userDetails = userDetailsService.loadUserByUsername(email);

      UsernamePasswordAuthenticationToken authenticationFilter =
          new UsernamePasswordAuthenticationToken(
                userDetails, null, authorities);

      authenticationFilter.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

      SecurityContextHolder.getContext().setAuthentication(authenticationFilter);
    }

    filterChain.doFilter(request, response);
  }

  private String getJWTFromRequest(HttpServletRequest request){
    String bearer = request.getHeader("Authorization");
    if(StringUtils.hasText(bearer) && bearer.startsWith(BEARER_PREFIX)) {
      return bearer.substring(BEARER_PREFIX.length());
    }
    return null;
  }
  private static final String BEARER_PREFIX = "Bearer ";
}
