package com.generatron.bots

import org.apache.commons.collections.map.HashedMap;
import org.apache.http.client.methods.HttpPost;
import org.codehaus.groovy.grails.web.json.JSONObject;

import com.generatron.bots.WSClient;

import grails.converters.JSON;
import grails.plugins.rest.client.RestBuilder;
import grails.transaction.Transactional

import java.net.URI;

import javax.websocket.*;

@ClientEndpoint
class WebSocketListenerImpl {
	
	HashMap<String,JSONObject> users = new HashMap<String,JSONObject>();

	@OnMessage
	public void onMessage(String message) {
		
		JSONObject json = JSON.parse(message);
		JSONObject user = null;
		if(json.user){
			user = users.get(json.user);
			if(!user){
				user = getUserInfo(json.user);
			}
		}
		if(json.type =="message"){
			 System.out.println("Received msg: " + message);
		}
		
	}
	
	def getUserInfo(String userId) {
		String url = baseUrl + "users.info?token="+token+"&user="+userId;
		def rest = new RestBuilder();
		def resp = rest.getAt(url);
		def responded = resp.json;
		users.put(userId, responded);
		println "Ok: "+responded.ok;
		println "User: "+responded;
	}
}
