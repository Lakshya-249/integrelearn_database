package JWT_auth.authorization.config;

import JWT_auth.authorization.user.TeacherUserRepository;
import JWT_auth.authorization.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    private final UserRepository repository;
    private final TeacherUserRepository teacherUserRepository;

    public ApplicationConfig(UserRepository repository, TeacherUserRepository teacherUserRepository) {
        this.repository = repository;
        this.teacherUserRepository = teacherUserRepository;
    }

    @Bean
    public UserDetailsService userDetailsService(){

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserDetails user1 = repository.finduserbyusername(username);
                if(user1!=null){
                    return user1;
                }

                UserDetails user2 = teacherUserRepository.finduserbyemail(username);
                if(user2!=null){
                    return user2;
                }

                throw new UsernameNotFoundException("User not found with username: " + username);
            }
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider dauth = new DaoAuthenticationProvider();
        dauth.setUserDetailsService(userDetailsService());
        dauth.setPasswordEncoder(passwordEncoder());
        return dauth ;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
