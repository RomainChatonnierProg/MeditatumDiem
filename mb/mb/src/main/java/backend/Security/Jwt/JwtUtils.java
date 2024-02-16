package backend.Security.Jwt;

import backend.Security.Services.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.el.parser.BooleanNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${app.jwt-secret}")
    private String jwtSecret;
    
    @Value("{app.jwt-expiration-milliseconds}")
    private int jwtExpirationMs;
    
    public String generateJwtToken(Authentication authentication){

        UserDetailsImpl UserPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        
        String rights = UserPrincipal.getAuthorities().stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        
        return Jwts.builder()
                .setSubject((UserPrincipal.getUsername()))
                .claim("email", UserPrincipal.getEmail())
                .claim("id", UserPrincipal.getId().toString())
                .claim("rights", rights)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
    
    private Key key(){ return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret)); }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parser().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
