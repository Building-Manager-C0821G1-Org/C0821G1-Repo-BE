//package com.c0821g1.sprint1.config;
//
//import com.c0821g1.sprint1.accessdenied.CustomAccessDeniedHandler;
//import com.c0821g1.sprint1.jwt.JwtAuthenticationEntryPoint;
//import com.c0821g1.sprint1.jwt.JwtFilter;
//import com.c0821g1.sprint1.service.account.impl.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsServiceImpl;
//
//    @Autowired
//    private JwtFilter jwtFilter;
//
//    @Autowired
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000);
//        http.authorizeRequests()
//                // Các trang không yêu cầu login
//                .antMatchers("/api/public/**", "/api/customer/**", "/**/*.jpg", "/**/*.png","/api/contract/**")
//                .permitAll()
//                //phan quyen
//                .and().authorizeRequests().antMatchers("/api/customer/update/**","/api/employee/list/**",
//                "/api/customer/**", "/api/floors/update/**")
//                .hasAnyRole("EMPLOYEE", "ADMIN")
//                .and().authorizeRequests().antMatchers("/api/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and().cors()
//                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                // make sure we use stateless session; session won't be used to
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // Add a filter to validate the tokens with every request
////        thêm lọc filter trước khi xác thực
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//    }
//
//    @Bean
//    public AccessDeniedHandler accessDeniedHandler() {
//        return new CustomAccessDeniedHandler();
//    }
//}
