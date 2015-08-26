package com.generatron.bots;

import java.net.URI;
import java.util.HashMap;

import javax.websocket.*;

import org.codehaus.groovy.grails.web.json.JSONObject;

@ClientEndpoint
public class WSClient {
	private static Object waitLock = new Object();
	HashMap<String,JSONObject> users = new HashMap<String,JSONObject>();

	@OnMessage
	public void onMessage(String message) {
		// the new USD rate arrives from the websocket server side.
		System.out.println("Received msg: " + message);
	}

}

