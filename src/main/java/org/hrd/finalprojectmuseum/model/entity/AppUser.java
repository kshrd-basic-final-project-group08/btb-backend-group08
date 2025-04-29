package org.hrd.finalprojectmuseum.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class AppUser implements UserDetails {
    private UUID userId;
    private String name;
    private String email;
    private String password;
    private String credentialType;
    private String role;
    private UUID profileImageId;
    private Boolean isVerified;
    private Boolean isApprove;
    private Boolean isActive;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private Boolean isDelete;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(role));
        return authorityList;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
