package com.example.demo;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		http.authorizeRequests()
		.mvcMatchers("/","/all/**").permitAll()
		.mvcMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated();
		
		
//		http.formLogin().loginPage("/login").defaultSuccessUrl("/list").permitAll();
		http.formLogin().defaultSuccessUrl("/list").permitAll();
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).invalidateHttpSession(true);
		http.httpBasic();
		
	}
	
}
