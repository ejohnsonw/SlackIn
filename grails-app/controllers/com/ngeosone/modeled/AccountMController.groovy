package com.ngeosone.modeled

import grails.converters.JSON;

class AccountMController {
	def scaffold = AccountM;
	
	def list(){
		def result = AccountM.list();
		render result as JSON;
	}

}
