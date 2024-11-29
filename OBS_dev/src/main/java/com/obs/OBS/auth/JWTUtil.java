package com.obs.OBS.auth;

import com.obs.OBS.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JWTUtil {
  @Value("${jwt_secret}")
  private String secret;
@Value("${jwt_expiration}")
  private int expirationMs;
  public String generateToken(User user) {
    Claims claims = Jwts.claims().setSubject(user.getEmail());
    claims.put("roles", Collections.singletonList(user.getType()));
    Date tokenCreateTime = new Date();
    Date tokenExpiration = new Date(tokenCreateTime.getTime() + expirationMs);
    return Jwts.builder()
        .setClaims(claims)
        .setExpiration(tokenExpiration)
        .signWith(SignatureAlgorithm.HS256, key())
        .setIssuedAt(tokenCreateTime)
        .compact();
  }
  private Key key(){
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
  }
  public String getEmailFromJwt(String token){
    return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody().getSubject();
  }

  public List<String> getRolesFromJwt(String token){
      Claims claims = Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
      return claims.get("roles", List.class);
  }

  public boolean validateToken(String token){
    try {
      Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token);
      return true;
    }catch(MalformedJwtException e){
      log.error("Invalid JWT token: {} ", e.getMessage());
    }catch(ExpiredJwtException e){
      log.error("JWT token is expired: {}", e.getMessage());
    }catch(UnsupportedJwtException e){
      log.error("JWT Token is unsupported : {}", e.getMessage());
    }catch(IllegalArgumentException e){
      log.error("JWT claims string is empty: {}", e.getMessage());
    }
    return false;
  }
}
