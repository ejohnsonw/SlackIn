package com.ngeosone.generatron.bot

import grails.transaction.Transactional

import org.codehaus.groovy.grails.web.json.JSONObject

import com.ngeosone.modeled.AccountM;



//@Transactional
class GeneratronRobotParserService {

    def parse(JSONObject message, JSONObject userInfo) {
		if(message.text == "devkey"){
			println userInfo;
			AccountM u = AccountM.findByEmail(userInfo.user.profile.email);
			if(u){
				return "Your devkey is: " +u.devkey;
			}else{
			   return "Not found"
			}
			
		}
		return message.text;
    }
}
