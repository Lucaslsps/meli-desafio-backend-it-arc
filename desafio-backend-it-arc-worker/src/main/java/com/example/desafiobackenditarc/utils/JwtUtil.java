package com.example.desafiobackenditarc.utils;

import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@Slf4j
public class JwtUtil {

    public SignedJWT decodeJwt(String token) throws ParseException {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            log.info("Header: " + signedJWT.getHeader().toJSONObject());
            log.info("Payload: " + signedJWT.getPayload().toJSONObject());
            return signedJWT;
        } catch (ParseException e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}

