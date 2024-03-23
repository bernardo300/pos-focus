// package focus.posfocus.security;

// import java.util.Collections;
// import java.util.Date;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class Jwt {
//     static final long EXPIRATION_TIME = 5 * 24 * 60 * 60 * 1000;
//     static final String SECRET = "571b2af7-f3a7-4fe3-8d75-69ddd5de86c8";
//     static final String PREFIX = "Bearer";
//     static final String AUTH_HEADER = "Authorization";

//     static void add(HttpServletResponse response, String username) {
//         var expiration = System.currentTimeMillis() + EXPIRATION_TIME;
//         var JWT = JwtSpec.Builder()
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(expiration))
//                 .setSubject(username)
//                 .setIssuer("microblog")
//                 .signWith(SignatureAlgorithm.HS512, SECRET)
//                 .compact();
//         response.addHeader(AUTH_HEADER, PREFIX + "" + JWT);

//     }

//     public static Authentication get(HttpServletRequest request) {

//         var token = request.getHeader(AUTH_HEADER);

//         if (token == null)
//             return null;

//         String user = Jwts.parser()

//                 .setSigningKey(SECRET)
//                 .parseClaimsJws(token.replace(PREFIX, ""))

//                 .getBody()

//                 .getSubject();

//         return user == null ? null
//                 : new UsernamePasswordAuthenticationToken(
//                         user, null, Collections.emptyList());
//     }
// }