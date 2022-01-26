package com.oopsw.jh.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TestJWT {
	
	final String key = "thisismyfirstsecretkeythisismyfirstsecretkeythisismyfirstsecretkey";
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		TestJWT testJWT = new TestJWT();
		
		String jwt = testJWT.createToken();
		System.out.println(jwt);
		
		Map<String, Object> claimMap = testJWT.verifyJWT(jwt);
		System.out.println(claimMap); // token이 만료되었거나 문제있으면 null
		
	}
	
	
	/**
	 * Header
	 * · alg : signature를 해싱하기 위한 알고리즘 정보를 갖고 있음
	 * · typ : 토큰의 타입을 나타냄, 생략 가능, 보통 JWT 사용
	 * 
	 * 
	 * Payload
	 * - server와 client가 주고받는 시스템에서 실제로 사용 될 정보에 대한 내용을 담고있음
	 * - JWT가 기본적으로 갖고있는 키워드가 존재, 추가 가능
	 * · iss : 토큰 발급자
	 * · sub : 토큰 제목
	 * · aud : 토큰 대상
	 * · exp : 토큰 만료 시간
	 * · nbf : Not Before
	 * · iat : 토큰이 발급된 시간
	 * · jti : JWT의 고유 식별자
	 * 
	 * Signature
	 * - 서버에서 토큰이 유효한지 검증하기 위한 문자열 
	 * - Header + Payload + Secret Key로 값을 생성하므로 데이터 변조 여부를 판단 가능
	 * - Secret Key는 노출되지 않도록 서버에서 관리 필요
	 * */
	
	
	// token 생성
	public String createToken() {
		
		// Header 부분 설정
		Map<String, Object> headers = new HashMap<>();
		headers.put("typ", "JWT");		
		headers.put("alg", "HS256");	
		
		// payload(내용) 부분 설정
		Map<String, Object> payloads = new HashMap<>();
		payloads.put("data", "My First JWT!");
		
		Long expiredTime = 1000 * 60L * 60L * 2L; // 토큰 유효 시간 (2시간)
		
		Date ext = new Date();
		ext.setTime(ext.getTime() + expiredTime);
		
		// token builder
		String jwt = Jwts.builder()
                .setHeader(headers)  // Headers 설정
                .setClaims(payloads) // Claims 설정
                .setSubject("user")  // 토큰 용도 
                .setExpiration(ext)  // 토큰 만료 시간 설정
                .signWith(SignatureAlgorithm.HS256, key.getBytes()) // HS256과 Key로 Sign
                .compact(); // 토큰 생성
		
		return jwt;
		
	} // createToken()
	
	// token 검증
	public Map<String, Object> verifyJWT(String jwt) throws UnsupportedEncodingException {
		
		Map<String, Object> claimMap = null;
		
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key.getBytes("UTF-8")) 	// Set Key
                    .parseClaimsJws(jwt) 					// 파싱 및 검증, 실패 시 에러
                    .getBody();

            claimMap = claims;

            //Date expiration = claims.get("exp", Date.class);
            //String data = claims.get("data", String.class);
            
        } catch (ExpiredJwtException e) { 	// 토큰이 만료되었을 경우
            System.out.println(e);
        } catch (Exception e) { 			// 그외 에러났을 경우
            System.out.println(e);
        }
        
        return claimMap;
		
	} // verifyJWT()
	
	
}
