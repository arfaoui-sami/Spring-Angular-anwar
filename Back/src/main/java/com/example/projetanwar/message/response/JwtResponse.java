package com.example.projetanwar.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {

    private String token;
    private String type ="Bearer";
    private String roles;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public JwtResponse(String roles, String token, String type, String username, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.token = token;
        this.type = type;
        this.username = username;
        this.authorities = authorities;
        this.roles =roles;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    public JwtResponse(String token, String username, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.token = token;
        this.username = username;
        this.authorities = authorities;
    }



}
