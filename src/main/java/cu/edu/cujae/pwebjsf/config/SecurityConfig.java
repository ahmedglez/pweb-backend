package cu.edu.cujae.pwebjsf.config;

import cu.edu.cujae.pwebjsf.middlewares.JwtFilterRequest;
import cu.edu.cujae.pwebjsf.services.CustomUserDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private CustomUserDetailsServices userDetailsService;

  @Autowired
  private JwtFilterRequest jwtFilterRequest;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf()
      .disable()
      .authorizeRequests()
      .antMatchers("/api/v1/login")
      .permitAll()
      .antMatchers("/api/v1/sendmail/**")
      .permitAll()
      .antMatchers("/api/v1/checkRecoveryCode/**")
      .permitAll()
      .antMatchers("/api/v1/changePassword/**")
      .permitAll()
      .antMatchers("/api/v1/refreshToken/**")
      .permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .logout()
      .logoutUrl("http://localhost:8080/pweb-jsf-0.0.1-SNAPSHOT/")
      .logoutSuccessUrl("http://localhost:8080/pweb-jsf-0.0.1-SNAPSHOT/")
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.addFilterBefore(
      jwtFilterRequest,
      UsernamePasswordAuthenticationFilter.class
    );
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
