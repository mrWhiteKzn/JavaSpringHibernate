package exampro.config;

import exampro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCustomizeAuthenticationSuccessHandler(CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler) {
        this.customizeAuthenticationSuccessHandler = customizeAuthenticationSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/exam/hello", "/exam/getall", "/secure/registration", "/reports/recently").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/secure/login")
                .permitAll()
                .successHandler(customizeAuthenticationSuccessHandler)
                .and()
                .logout()
                .permitAll();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/css/**", "/js/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("select login, password, active from user where login=?")
//                .authoritiesByUsernameQuery("select u.login, ur.roles from user u inner join user_role ur on u.id = ur.user_id where u.login=?");

        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}