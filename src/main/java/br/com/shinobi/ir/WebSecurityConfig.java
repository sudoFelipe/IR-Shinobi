package br.com.shinobi.ir;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration		//	Anotação de configuração 
@EnableWebSecurity	//	Disponibiliza as dependência do spring security sobre configurações
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
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
						.loginPage("/login")				//	URL da página de login
						.defaultSuccessUrl("/home", true)	//	Caso o usuário efetue o login, será redirecionado para a home page
						.permitAll()
						
				)
				.logout(log -> log.logoutUrl("/logout"))			//	Acesso permitido a todos os usuários
				.csrf().disable();									//	Disabilitando funcionalidade de segurança CSRF
	}
	
	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
//		UserDetails user = User.builder()
//				.username("luis")
//				.password(encoder.encode("123"))
//				.roles("ADM")
//				.build();
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)		//	Responsável por conexões do banco de dados
			.passwordEncoder(encoder);
			
		}
}
