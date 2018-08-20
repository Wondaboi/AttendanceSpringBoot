package com.AttendanceBase.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter { 

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("test").password("{noop}test").roles("USER").and()
                .withUser("root").password("{noop}root").roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("**/address/add").hasRole("ADMIN")
                .antMatchers("**/address/update").hasRole("ADMIN")
                .antMatchers("**/employee/add").hasRole("ADMIN")
                .antMatchers("**/employee/update").hasRole("ADMIN")
                .antMatchers("**/clock/add").hasRole("ADMIN")
                .antMatchers("**/clock/update").hasRole("ADMIN")
                .antMatchers("**/contactDetails/add").hasRole("ADMIN")
                .antMatchers("**/contactDetails/update").hasRole("ADMIN")
                .antMatchers("**/position/add").hasRole("ADMIN")
                .antMatchers("**/position/update").hasRole("ADMIN")
                .anyRequest()
                .fullyAuthenticated()
                .and().httpBasic();
        httpSecurity.csrf().disable();
    }
}
