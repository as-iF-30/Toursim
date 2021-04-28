package com.persistent.tourism.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/login").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/fonts/**").permitAll()
		.antMatchers("/img/**").permitAll()
		.antMatchers("/js/**").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/signup").permitAll()
		.antMatchers("/package").permitAll()
		.antMatchers("/admin/*").hasAnyAuthority("ADMIN")
		.antMatchers("/newPackageForm").hasAnyAuthority("ADMIN")
		.antMatchers("/savePackage").hasAnyAuthority("ADMIN")
		.antMatchers("/showFormUpdate/*").hasAnyAuthority("ADMIN")
		.antMatchers("/deletePackage/*").hasAnyAuthority("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/user/home", false)
		.and()
		.logout().invalidateHttpSession(true).invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
	}
	

	 @Bean
	 AuthenticationProvider getAuthenticationProvider() {
		 DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		 daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		 daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		 return daoAuthenticationProvider;
	 }

	
	
}
