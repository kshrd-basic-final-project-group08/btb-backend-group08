package org.hrd.finalprojectmuseum.service.impl;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.hrd.finalprojectmuseum.service.OtpCacheService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OtpCacheServiceImpl implements OtpCacheService {

    private final Cache<String, String> otpCache;

    public OtpCacheServiceImpl() {
        this.otpCache = Caffeine.newBuilder()
                .expireAfterWrite(2, TimeUnit.MINUTES)
                .maximumSize(1000)
                .build();
    }

    public void storeOtp(String email, String otp) {
        otpCache.put(email, otp);
    }

    public String getOtp(String email, String otp) {
        return otpCache.getIfPresent(email);
    }

    public void removeOtp(String email) {
        otpCache.invalidate(email);
    }
}
