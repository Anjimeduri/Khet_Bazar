package com.khet_bazar.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@Aspect
@Component
public class AuthenticateAspect {
    @Around("@annotation(secureEndPoint)")
    public Object validateAuthHeaders() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        return request;
    }
}
