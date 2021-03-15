// logowanie
// https://www.marcobehler.com/guides/spring-security

// package com.codigo.smartstore.webapi.configuration;
//
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//// @EnableWebSecurity
// public class SecurityConfiguration
// extends
// WebSecurityConfigurerAdapter {
//
// @Override
// protected void configure(final HttpSecurity http) throws Exception {
//
// http.cors()
// .and()
// .csrf()
// .disable()
// .authorizeRequests()
// .antMatchers("/api/v1/employees")
// .hasRole("manager")
// .anyRequest()
// .authenticated()
// .and()
// .formLogin();
// }
// }
//
//// @Configuration
//// @EnableWebSecurity
//// public class SecurityConfiguration
//// extends
//// WebSecurityConfigurerAdapter {
////
//// @Override
//// protected void configure(final AuthenticationManagerBuilder auth) throws
//// Exception {
////
//// final PasswordEncoder encoder =
//// PasswordEncoderFactories.createDelegatingPasswordEncoder();
//// auth.inMemoryAuthentication()
//// .withUser("user")
//// .password(encoder.encode("password"))
//// .roles("USER")
//// .and()
//// .withUser("admin")
//// .password(encoder.encode("admin"))
//// .roles("USER", "ADMIN");
//// }
////
//// @Override
//// protected void configure(final HttpSecurity http) throws Exception {
////
//// http.authorizeRequests()
//// .anyRequest()
//// .authenticated()
//// .and()
//// .httpBasic();
//// }
//// }