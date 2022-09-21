package com.leasepe.mail.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leasepe.mail.model.User;
import com.leasepe.mail.service.MailService;

/**
 * This class contains a Mail API developed using Spring Boot
 * 
 * @author MukulJaiswal
 *
 */
@CrossOrigin
@RestController
@RequestMapping
public class RegistrationController {

	@Autowired
	private MailService notificationService;

	@Autowired
	private User user;

	@RequestMapping("/send-mail")
	public String send(@RequestParam String email) {

		System.out.println(email);
		user.setEmailAddress(email); // Receiver's email address
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations mail! Your mail has been send to the user.";
	}

}