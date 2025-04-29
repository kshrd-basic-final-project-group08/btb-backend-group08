package org.hrd.finalprojectmuseum.model.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppUserRegister {
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
}
