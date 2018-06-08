package kr.ac.jejunu.project.websecurity;

import kr.ac.jejunu.project.dao.ManagerDao;
import kr.ac.jejunu.project.management.Manager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.sql.SQLException;
import java.util.LinkedList;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/img/*", "/stylesheet/*", "/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        ManagerDao managerDao = new ManagerDao();

        LinkedList<Manager> managers = null;
        try {
            managers = managerDao.get();
            for (Manager m : managers) {
                System.out.println(m);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String id = managers.get(0).getId();
        String role = managers.get(0).getRole();
        String password = managers.get(0).getPassword();

        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username(id)
                        .password(password)
                        .roles(role)
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}