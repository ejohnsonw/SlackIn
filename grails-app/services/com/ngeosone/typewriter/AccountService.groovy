package com.ngeosone.typewriter

import grails.transaction.Transactional;

import com.ngeosone.exceptions.AccountExistsException;
import com.ngeosone.exceptions.PasswordDidNotMatchException;
import com.ngeosone.modeled.AccountM;
import com.ngeosone.skillvisor.utils.PasswordGenerator;



class AccountService {
	@Transactional
	public AccountM register(String firstName,String lastName, String email, String password, String confirmation) throws AccountExistsException, PasswordDidNotMatchException {
		def u = AccountM.findByEmail(email);
		if(u){
			throw new AccountExistsException();
		}
		if(password == null){
			password = new PasswordGenerator().generate(8);
			confirmation = password;
		}
		if(password.encodeAsPassword() != confirmation.encodeAsPassword()){
			throw new PasswordDidNotMatchException()
		}
		u = new AccountM();
		u.firstName = firstName;
		u.lastName = lastName;
		u.email = email;
		u.passwordHashed = password.encodeAsPassword();
		u.devkey = UUID.randomUUID();
		u.stripeId = "--";


		if (!u.save(flush:true)) {
			// validation failed, render registration page again
			u.errors.allErrors.each {println it};

		} else {

			sendMail {
				to "evolj@yahoo.com"
				subject "Registration for generatron.com  ${u.firstName} ${u.lastName} @{u.email}"
				html "<html><body>Dear ${u.firstName} ${u.lastName} please click the link below to activate your account<br><a href=\"http://www.generatron.com/user/activate/${u.devkey}\">Activate</a> </body></html>"
			}

			sendMail {
				to u.email
				subject "Your Generatron activation "
				html "<html><body>Dear ${u.firstName} ${u.lastName} please click the link below to activate your account<br><a href=\"http://www.generatron.com/user/activate/${u.devkey}\">Activate</a> </body></html>"
			}
			//gitHubService.createRepoForUser(u.email.replaceAll("@|\\.","-"));
		}
		return u;
	}
}
