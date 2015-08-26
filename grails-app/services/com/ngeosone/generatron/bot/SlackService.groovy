package com.ngeosone.generatron.bot

import org.apache.commons.collections.map.HashedMap;
import org.apache.http.client.methods.HttpPost;
import org.codehaus.groovy.grails.web.json.JSONObject;


import com.generatron.bots.WSClient;
import com.generatron.bots.WebSocketListenerImpl;
import com.ngeosone.modeled.AccountM
//import com.ngeosone.typewriter.AccountService

import grails.converters.JSON;
import grails.plugins.rest.client.RestBuilder;
import grails.transaction.Transactional

import java.net.URI;
import java.util.HashMap;

import javax.websocket.*;
//import org.codehaus.groovy.grails.commons.ApplicationHolder as AH



@ClientEndpoint
class SlackService {
	private static String baseUrl = "https://slack.com/api/"
	private static String token = "xoxb-9524414727-MTbKDZcXDrbWqvAScWk6k3go"
	HashMap<String,JSONObject> users = new HashMap<String,JSONObject>();
	HashMap<String,String> channels = new HashMap<String,String>();
	HashMap<String,Session> sessions = new HashMap<String,Session>();
	WebSocketContainer container = null;
	//def accountService = AH.application.mainContext.accountService
	Session session = null;


	def authenticate() {
		String url = baseUrl + "rtm.start?token="+token;
		def rest = new RestBuilder();
		def resp = rest.getAt(url);
		def responded = resp.json;
		println "Ok: "+responded.ok;
		println "Connecting WS to: "+responded.url;
		println "User: "+responded.user;

		try {
			container = ContainerProvider.getWebSocketContainer();
			session = container.connectToServer(SlackService.class, URI.create(responded.url));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				try {
					//session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*@OnOpen
	 public void onOpen(Session session) {
	 try {
	 //session.getBasicRemote().sendText("start");
	 } catch (IOException e) {
	 throw new RuntimeException(e);
	 }
	 }*/

	@OnMessage
	public String onMessage(String message) {
		JSONObject json = JSON.parse(message);
		JSONObject user = null;
		if(json.user){
			user = users.get(json.user);
			if(!user){
				user = getUserInfo(json.user);
			}
			channels.put(json.user, json.channel)
			//sessions.put(json.user, session)
		}
		if(json.type =="message"){
			if(json.subtype != "bot_message"){
				println json;
				def cuser = users.get(json.user);
				if(cuser){
					//def sendThis = generatronRobotParserService.parse(json,cuser)
					def sendThis = "response"
					sendMessage(json.channel,sendThis)
				}else{
					sendMessage(json.channel,"Could not understand your message")
				}
			}
		}

		System.out.println("Received msg: " + message);
	}

	def getUserInfo(String userId) {
		String url = baseUrl + "users.info?token="+token+"&user="+userId;
		def rest = new RestBuilder();
		def resp = rest.getAt(url);
		def json = resp.json;

		//AccountM.withNewSession {
		def user = json.user;
		AccountM u = AccountM.findByEmail(user.profile.email);
		println json.user;
		println json.email;

		/*if(!u && json.email){
			try {
				if(user.profile.real_name != null && user.profile.real_name != ""){
					String[] toks = user.profile.realname.split(" ");
					if(toks.size() > 1){
						u = accountService.register(toks[0],toks[1],user.profile.email,null,null);
					}
				}else{
					u = accountService.register(user.profile.real_name,user.profile.real_name,user.profile.email,null,null);
				}
			} catch (Exception e) {
				//e.printStackTrace()
			}
		}*/
		//}


		users.put(userId, json);
		println "Ok: "+json.ok;
		println "User: "+json.user;
	}

	def sendMessage(String channel,String message) {
		String url = baseUrl + "chat.postMessage?token="+token+"&channel="+channel+"&text="+message;
		def rest = new RestBuilder();
		def resp = rest.post(url){
			contentType "application/json"
			json {
				token = token
				channel = channel
				text = message
				username = "Generatron Bot"
			}
		}
		def responded = resp.json;
		println "Ok: "+responded.ok;
		println "Response: "+responded;
	}
}
