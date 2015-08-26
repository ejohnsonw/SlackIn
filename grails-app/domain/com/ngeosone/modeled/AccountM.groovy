package com.ngeosone.modeled



class AccountM {
	String email
	String name
	String firstName
	String lastName
	String password        // plain text, not stored
	String confirm         // plain text, not stored
	String passwordHashed
	String stripeId;
	String devkey;

	

	// transients
	static transients = ['password', 'confirm','token']

	// constraints
	static constraints = {
		name  blank:true, nullable:true;
		email  blank:false, size:5..30, matches:/[\S]+/, unique:true
		stripeId: nullable:true;

		/*password  blank:false, size:5..30, matches:/[\S]+/, validator:{ val, obj ->
			if (obj.password != obj.confirm)
				return 'account.password.dontmatch'
		}*/
	}
	String toString() {
		return email
	}
	


}
