package org.ronel.tutorial.messenger;

import java.util.HashMap;
import java.util.Map;

import org.ronel.tutorial.messenger.model.Message;
import org.ronel.tutorial.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	private static long lastMessageId = 1l;
	private static long lastProfileId = 1l;
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	public static Long getNextMessageId(){
		return lastMessageId++;
	}
	
	public static Long getNextProfileId(){
		return lastProfileId++;
	}
	
}
