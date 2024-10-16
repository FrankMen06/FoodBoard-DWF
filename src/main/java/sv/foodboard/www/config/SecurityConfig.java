package sv.foodboard.www.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import sv.foodboard.www.service.UserDetailsServiceImpl;

import java.io.IOException;
import java.util.Collection;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // Bean para la encriptación de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Configuración del AuthenticationManager, necesaria para autenticar usuarios manualmente si es requerido
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Puedes habilitar CSRF si lo necesitas en otro contexto
                .authorizeHttpRequests(auth -> auth
//                              .requestMatchers("/home", "/error/", "/login", "/css/**", "/js/**").permitAll()
                                .requestMatchers("/clientes/**").permitAll() // Solo Cliente puede acceder a estas rutas
                                .requestMatchers("/admin/**").hasAuthority("Administrador") // Solo ADMIN puede acceder a estas rutas
                                .requestMatchers("/mesero/**").hasAuthority("Mesero") // Solo VENDEDOR puede acceder a estas rutas
                                .requestMatchers("/recepcionista/**").hasAuthority("Recepcionista") // Solo RECEPCIONISTA puede acceder a estas rutas
                                .requestMatchers("/pedidos/**").hasAuthority("Pedidos") // Solo PEDIDOS puede acceder a estas rutas
                                .requestMatchers("/jefeCocina/**").hasAuthority("JefeCocina") // Solo JEFECOCINA puede acceder a estas rutas
                                .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("codigo")
                        .passwordParameter("contrasena")
                        .successHandler(successHandler())
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new SimpleUrlAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                org.springframework.security.core.Authentication authentication)
                    throws IOException, ServletException {

                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                String redirectUrl = null;

                for (GrantedAuthority authority : authorities) {
                    String role = authority.getAuthority();

                    if (role.equals("Administrador")) {
                        redirectUrl = "admin/inicio";
                        break;
                    } else if (role.equals("Mesero")) {
                        redirectUrl = "mesero/inicioMesero";
                        break;
                    } else if (role.equals("Recepcionista")) {
                        redirectUrl = "/recepcionista/inicioRecepcionista";
                        break;
                    } else if (role.equals("Pedidos")) {
                        redirectUrl = "/pedidos/inicioPedidos";
                        break;
                    } else if (role.equals("JefeCocina")) {
                        redirectUrl = "/jefeCocina/inicioJefeCocina";
                        break;
                    }
                    // El login de cliente sigue en desarrollo pq eso se va a manejar de diferente manera pq no posee rol y viene de otra tabla
                }

                if (redirectUrl != null) {
                    response.sendRedirect(redirectUrl);
                } else {
                    throw new IllegalStateException("No se encontró una ruta de redirección.");
                }
            }
        };
    }
}
