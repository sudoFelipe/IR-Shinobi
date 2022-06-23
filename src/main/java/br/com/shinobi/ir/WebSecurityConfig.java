package br.com.shinobi.ir;

import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration		//	Anotação de configuração 
@EnableWebSecurity	//	Disponibiliza as dependência do spring security sobre configurações
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

//	USADO A PARTIR DA VERSÃO 5.7
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated()
//            )
//            .httpBasic(withDefaults());
//        return http.build();
//    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//	CONFIGURAÇÕES DAS REQUISIÇÕES
		http.authorizeRequests()					//	Autorizador de requisições
//				.antMatchers("/", "/home").permitAll()	//	Todas as rotas definidas estão sendo permitidas (não precisa estar autenticado)
				.anyRequest().authenticated()			// Qualquer outra requisição (página) tem que estar autenticada
			
			.and()
				.formLogin(form -> form
						.loginPage("/login")	//	URL da página de login
						.permitAll()
						
				)
				.logout(log -> log.logoutUrl("/logout"));			//	Acesso permitido a todos os usuários
		
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("luis")
				.password("123")
				.roles("ADM")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
