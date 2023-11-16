package com.fis.banksystem.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//@Component is an annotation that allows Spring to detect our custom beans automatically.
@Component

 /*json Web Token  is a proposed Internet standard for creating data with optional 
 signature and/or optional encryption whose payload holds JSON that asserts some number of claims. 
 The tokens are signed either using a private secret or a public/private key.
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}