package com.team10.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.team10.service.CustomAuthServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Bean
	UserDetailsService detailsService() {
		return new CustomAuthServiceImpl();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(detailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
			http
					.authorizeHttpRequests((authorize)->
						authorize
									.requestMatchers("/","/login","/register","/process-user","/error","/css/**","/images/**").permitAll()
									.anyRequest().authenticated()
							)
					.formLogin((login)->
						login
								.loginPage("/login")
								.defaultSuccessUrl("/auth/profile")
							)
					.logout((logout)->
						logout
								.logoutSuccessUrl("/login")
								.permitAll()
							);
		// @formatter:on

		return http.build();
	}
}
