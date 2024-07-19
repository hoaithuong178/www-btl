package vn.edu.iuh.fit.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum PayMethod {

  ONLINE("online"),
  OFFLINE("offline")
  ;

  private final String name;

  public List<SimpleGrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

    System.out.println("25 - authorities" + authorities);

    return authorities;
  }
}
