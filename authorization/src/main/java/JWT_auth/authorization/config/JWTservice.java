package JWT_auth.authorization.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTservice {

    private static final String secrete_key= "b226bbc81f42321d083d227c18a843465682440f3f37c9e9fac859f1b28179fb";
    public String extractusername(String token){
        return extractclaims(token,Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails){
        return generatetoken(new HashMap<>(),userDetails);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractusername(token);
        return (username.equals(userDetails.getUsername())) && !istokenExpired(token);
    }

    private String generatetoken(
            Map<String,Object> extraclaim,
            UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(extraclaim)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*24))
                .signWith(getsignkey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private boolean istokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token){
        return extractclaims(token,Claims::getExpiration);
    }
    private <T> T extractclaims(String token, Function<Claims,T>claimresolver){
        final Claims claims = extractallclaims(token);
        return claimresolver.apply(claims);
    }

    private Claims extractallclaims(String token){
        return Jwts
                .parser()
                .verifyWith(secret)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    private Key getsignkey(){
        byte[] keybyte = Decoders.BASE64.decode(secrete_key);
        return Keys.hmacShaKeyFor(keybyte);
    }
    SecretKey secret = (SecretKey) getsignkey();
}
