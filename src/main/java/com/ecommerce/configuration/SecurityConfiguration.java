package com.ecommerce.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.ecommerce.filter.JwtFilter;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
 private  UserAuthService userAuthService;
  @Autowired
 private UserAuthenticationEntryPoint userAuthenticationEntryPoint;
 @Autowired
private JwtFilter jwtRequestFilter;

  ///@Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.csrf().disable();
//    http.headers().disable();
//    http.cors();
//    http.httpBasic().authenticationEntryPoint(this.userAuthenticationEntryPoint);
//
//    http.httpBasic().and()
//      .authorizeRequests()
//      .antMatchers("/login/**").authenticated()
//       .antMatchers("/users/**").authenticated()
//        .antMatchers("/products/**").authenticated()
//        //.antMatchers(HttpMethod.PUT, "/api/1.0/users/{id}").authenticated()
//      .and()
//      .authorizeRequests().anyRequest().permitAll();
//    http.logout().logoutUrl("/do_logout").invalidateHttpSession(true).deleteCookies("JSESSIONID");
//
//
//    //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//  }
  @Bean
@Override
public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
}
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder());
  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  
  protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable();
		 httpSecurity.cors();
				// dont authenticate this particular request
		
				httpSecurity.authorizeRequests().antMatchers("/authenticate").permitAll().and()
				.authorizeRequests().antMatchers("/home").permitAll().and()
				.authorizeRequests().antMatchers("/password/*").permitAll().and()
				.authorizeRequests().antMatchers("/validate/").permitAll().and()
				.authorizeRequests().antMatchers("/upload/").permitAll().and()
				.authorizeRequests().antMatchers(HttpMethod.GET,"/products/").permitAll().and()
				.authorizeRequests().antMatchers(HttpMethod.GET,"/categories/").permitAll().and()
				.authorizeRequests().antMatchers(HttpMethod.POST,"/users/").permitAll().
				
				
				// all other requests need to be authenticated
				anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(this.userAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
