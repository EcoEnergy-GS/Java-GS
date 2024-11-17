//package br.com.fiap.EcoEnergy.seguranca;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/nova_pessoa","/atualiza_discente/{id}","/remove_discente/{id}")
//                        .hasAuthority("ROLE_ADMIN")
//                        .anyRequest().authenticated())
//                .formLogin((form) -> form.loginPage("/login").failureUrl("/login?erro=true")
//                        .defaultSuccessUrl("/index1").permitAll())
//                .logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout=true").permitAll())
//                .exceptionHandling((exception) ->
//                        exception.accessDeniedHandler((request,response,accessDeniedHandler) ->
//                        {response.sendRedirect("/acesso_negado");}));
//
//        return http.build();
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
