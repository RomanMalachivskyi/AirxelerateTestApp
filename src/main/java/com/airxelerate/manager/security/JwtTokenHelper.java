package com.airxelerate.manager.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class JwtTokenHelper {
    private final RSAPrivateKey privateKey;
    private final RSAPublicKey publicKey;

    public String createJwtForClaims(String subject, Map<String, String> claims) {

        Date expirationDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
        log.info("created token expirationDate: " + expirationDate);

        JWTCreator.Builder jwtBuilder = JWT.create().withSubject(subject);

        claims.forEach(jwtBuilder::withClaim);

        return jwtBuilder.withNotBefore(new Date())
                .withExpiresAt(expirationDate)
                .sign(Algorithm.RSA256(publicKey, privateKey));
    }
}
