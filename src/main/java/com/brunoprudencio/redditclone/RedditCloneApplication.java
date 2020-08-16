package com.brunoprudencio.redditclone;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@Configuration
@EnableAsync
public class RedditCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run( RedditCloneApplication.class, args );
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setPort( 587 );
		mailSender.setProtocol( "smtp" );
		mailSender.setHost( "smtp.mailtrap.io" );
		mailSender.setUsername( "5a161cab3aab03" );
		mailSender.setPassword( "8529b82f0cdb90" );

		Properties props = mailSender.getJavaMailProperties();
		props.put( "mail.transport.protocol", "smtp" );
		props.put( "mail.smtp.auth", "true" );
		props.put( "mail.smtp.starttls.enable", "true" );
		props.put( "mail.debug", "true" );

		return mailSender;
	}

}
