package com.event.management.security;

public class ValidateJWT {

	/*//The JWT signature algorithm we will be using to sign the token
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    //We will sign our JWT with our ApiKey secret
    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey.getSecret());
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    //Let's set the JWT Claims
    JwtBuilder builder = Jwts.builder().setId(id)
                                .setIssuedAt(now)
                                .setSubject(subject)
                                .setIssuer(issuer)
                                .signWith(signatureAlgorithm, signingKey);

    //if it has been specified, let's add the expiration
    if (ttlMillis >= 0) {
    long expMillis = nowMillis + ttlMillis;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);
    }

    //Builds the JWT and serializes it to a compact, URL-safe string
    return builder.compact();*/
	
}
