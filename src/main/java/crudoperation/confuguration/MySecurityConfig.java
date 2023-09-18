//package crudoperation.confuguration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//      http
//              .authorizeRequests()
//              //.antMatchers("/home","/ login","/register").permitAll()//all are public  "/public/**"
//              .antMatchers("/api/posts/**").permitAll()
//              .anyRequest()
//              .authenticated()
//              .and()
//              .httpBasic();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//       auth.inMemoryAuthentication().withUser("Natabar@143").password(this.passwordEncoder().encode("Natabar@143")).roles("NORMAL");
//       auth.inMemoryAuthentication().withUser("Hari@143").password(this.passwordEncoder().encode("Hari@143")).roles("ADMIN");
//
//    }
//    //Role -high level overview->normal :Read
//    //Authority-permission->read
//    //Admin-READ,WRITE,UPDATE
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder(10);
//    }
//}
