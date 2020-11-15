package com.peasch.controller.security.config;

import com.peasch.controller.security.service.CustomUserDetailsService;
import com.peasch.model.dto.RoleDto;
import com.peasch.model.entities.Role;
import com.peasch.service.Impl.UserServiceImpl;
import io.jsonwebtoken.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.Set;

@Component
public class JwtTokenProvider {
    @Value("${security.jwt.token.secret-key:secret}")
    private String secretKey ="spongeBob";

    @Value("${security.jwt.token.expire:3600000}")
    private long validityInMilliseconds =3600000;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String username, Set<RoleDto> set) { // Nous créons le Token : nous retrouvons les Claims dont nous avons parlé dans le cou
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", set);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        return Jwts.builder()//
                .setClaims(claims)// On y ajoute les informations qu'on veut nous même, les Claims.
                .setIssuedAt(now)// Date de création
                .setExpiration(validity)// Date d'expiration à partir de laquelle le Token ne sera plus valide.
                .signWith(SignatureAlgorithm.HS256, secretKey)// Et on y ajoute la signature.
                .compact();
    }
    public String getUsername(String token) { // On récupère le Claims userName.
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public Authentication getAuthentication(String token) { // Nous récupérons l'authentification courante de l'utilsiateur courant.
        CustomUserDetailsService userDetails = (CustomUserDetailsService) this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest req) { // Méthode qui va extraire de la requête Http le token.
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
    public boolean validateToken(String token) { // Voici la méthode qui va nous permettre de valider ou non un Token de part sa date d'expiration ou
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            if (claims.getBody().getExpiration().before(new Date())) {
                return false;
            }
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtException("Expired or invalid JWT token");
        }
    }
}
