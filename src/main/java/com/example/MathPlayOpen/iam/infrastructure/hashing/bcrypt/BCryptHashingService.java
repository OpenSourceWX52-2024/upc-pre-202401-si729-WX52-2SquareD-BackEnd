package com.example.MathPlayOpen.iam.infrastructure.hashing.bcrypt;

import com.example.MathPlayOpen.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
