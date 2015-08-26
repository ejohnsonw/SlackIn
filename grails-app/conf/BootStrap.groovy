import com.ngeosone.modeled.AccountM;

import grails.converters.JSON;

class BootStrap {
	def slackService;
    def init = { servletContext ->
		
		JSON.registerObjectMarshaller(AccountM) {
			def returnArray = [:]
			//returnArray['class_'] = it.class
			returnArray['confirm'] = it.confirm

			returnArray['devkey'] = it.devkey

			returnArray['email'] = it.email

			returnArray['id'] = it.id

			returnArray['name'] = it.name
			returnArray['firstName'] = it.firstName
			returnArray['lastName'] = it.lastName


			

			//returnArray['stripeId'] = it.stripeId

			return returnArray
		}
		slackService.authenticate();
    }
    def destroy = {
    }
}
