package org.hrd.finalprojectmuseum.service;

public interface OtpCacheService {
    void storeOtp(String email, String otp);

    String getOtp(String email, String otp);

    void removeOtp(String email);
}

