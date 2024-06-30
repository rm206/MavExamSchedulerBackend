package edu.uta.MavExamScheduler;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class IPService {
    /**
     * Returns client IP from which the request was made. {@code X-Forwarded-For} header is also checked in case the
     * service is located behind a load balancer.
     */
    public String getClientIP(HttpServletRequest request) {
        System.out.println("IPService.getClientIP triggered");
        String xForwardedHeader = request.getHeader("X-Forwarded-For");
        if (xForwardedHeader == null) {
            return request.getRemoteAddr();
        }
        return xForwardedHeader.split(",")[0];
    }
}