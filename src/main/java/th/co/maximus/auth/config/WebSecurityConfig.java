package th.co.maximus.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ImportResource({ "classpath:applicationContext.xml" })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean("freesiaUPC")
//	public net.sf.jasperreports.engine.fonts.SimpleFontFamily freesiaUPC() {
//    	net.sf.jasperreports.engine.fonts.SimpleFontFamily  simpleFontFamily = new net.sf.jasperreports.engine.fonts.SimpleFontFamily();
//		simpleFontFamily.setName("FreesiaUPC");
//		
//		simpleFontFamily.setNormal("th/co/maximus/report/font/newFL.ttf");
//		simpleFontFamily.setBold("th/co/maximus/report/font/newFB.ttf");
//		simpleFontFamily.setItalic("th/co/maximus/report/font/newFI.ttf");
//		simpleFontFamily.setBoldItalic("th/co/maximus/report/font/newFBI.ttf");
//		simpleFontFamily.setNormalPdfFont("th/co/maximus/report/font/newFL.ttf");
//		simpleFontFamily.setItalicPdfFont("th/co/maximus/report/font/newFB.ttf");
//		simpleFontFamily.setBoldPdfFont("th/co/maximus/report/font/newFBI.ttf");
//		simpleFontFamily.setPdfEmbedded(true);
//		simpleFontFamily.setPdfEncoding("Identity-H");
//		
//		return simpleFontFamily;
//		
//	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}