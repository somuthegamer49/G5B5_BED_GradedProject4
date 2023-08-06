package com.glearning.GradedAssignment4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean

	// Used for authentication
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(authenticationProvider());
		return authenticationManagerBuilder.build();
	}

	// Authorization
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeHttpRequests().antMatchers("/h2-console**", "/login**", "/logout**").permitAll()
				.antMatchers(HttpMethod.GET, "/users").hasRole("SUPER_ADMIN").antMatchers(HttpMethod.POST, "/users")
				.hasRole("SUPER_ADMIN").antMatchers(HttpMethod.GET, "/roles").hasRole("SUPER_ADMIN")
				.antMatchers(HttpMethod.POST, "/roles").hasRole("SUPER_ADMIN")
				.antMatchers(HttpMethod.GET, "/employees**").hasAnyRole("USER", "ADMIN")
				.antMatchers(HttpMethod.GET, "/employees").hasAnyRole("USER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/employees").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN").anyRequest().authenticated().and()
				.httpBasic();

		return http.build();
	}
}
