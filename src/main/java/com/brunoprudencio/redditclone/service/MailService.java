package com.brunoprudencio.redditclone.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.brunoprudencio.redditclone.dto.NotificationMail;
import com.brunoprudencio.redditclone.exception.ActivationMailException;

@Service
@Slf4j
@AllArgsConstructor
class MailService {

	private final JavaMailSender mailSender;
	private final MailContentBuilder mailContentBuilder;
	private static final String FROM = "reddit-clone@mail.com";

	void sendMail(NotificationMail notificationMail) {
		MimeMessagePreparator messagePreparation = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper( mimeMessage );
			messageHelper.setFrom( FROM );
			messageHelper.setTo( notificationMail.getRecipient() );
			messageHelper.setSubject( notificationMail.getSubject() );
			messageHelper.setText( mailContentBuilder.build( notificationMail.getBody() ) );
		};
		try {
			mailSender.send( messagePreparation );
			log.info( "Activation mail sent to: " + notificationMail.getRecipient() );
		} catch (MailException e) {
			throw new ActivationMailException( "Error on sending email to: " + notificationMail.getRecipient(), e );
		}
	}
}
