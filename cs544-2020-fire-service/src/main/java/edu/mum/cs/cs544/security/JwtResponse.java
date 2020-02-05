package edu.mum.cs.cs544.security;

public class JwtResponse {

    private String accessToken;
    private final  String tokenType = "Bearer";
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
    
    public JwtResponse() {
		// TODO Auto-generated constructor stub
	}
	public JwtResponse(String token) {
		this.accessToken = token;
	}

}