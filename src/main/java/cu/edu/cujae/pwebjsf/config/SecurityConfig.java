package cu.edu.cujae.pwebjsf.config;

import cu.edu.cujae.pwebjsf.services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  CustomUserDetailService userDetailService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailService);
  }

  /* permitir que las request se hagan sin autenticacion (momentaneo) */
  @Override
  protected void configure(
          org.springframework.security.config.annotation.web.builders.HttpSecurity http
  ) throws Exception {
    http
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/**")
            .permitAll()
            .antMatchers(HttpMethod.POST, "/**")
            .permitAll()
            .antMatchers(HttpMethod.PUT, "/**")
            .permitAll()
            .antMatchers(HttpMethod.DELETE, "/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
