package br.com.gouvea.api.web.place.config.secyrity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/assets/**").permitAll()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated().and()
		.formLogin().defaultSuccessUrl("/actuator", true).and()
		.logout().logoutUrl("/logout").and()
		.httpBasic();
        
		 http.csrf().disable();
	     http.headers().frameOptions().disable();
	     
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**",
				"/swagger-resources/**");
	}
	
	
}
