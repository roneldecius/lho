package com.draag.services.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.draag.services.DatabaseClass;
import com.draag.services.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
		
	public MessageService() {
		if (messages.size() == 0) {
			Long id = DatabaseClass.getNextMessageId();
			messages.put(id, new Message(id, "Hello World!", "Ronel Decius"));
			id = DatabaseClass.getNextMessageId();
			messages.put(id, new Message(id, "Hello Jersey!", "Ronel Decius"));
		}
	}

	public List<Message> getAllMessages(){
//		List<Message> list = new ArrayList<Message>(); 
//		list.add();
//		list.add(new Message(2l, "Hello Jersey!", "Ronel"));
//		return list;
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messageForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year){
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<>(messages.values());
		if (start > list.size()) return new ArrayList<Message>();
		if (start + size > list.size()){
			size = list.size() - start;
		}
		return list.subList(start, start + size);
	}
	
	public Message getMessage(Long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(DatabaseClass.getNextMessageId());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if (messages.get(message.getId()) instanceof Message){
			messages.put(message.getId(), message);
			return message;
		}
		return null;
	}

	public Message deleteMessage(long id){
		Message message = messages.get(id);
		if (message instanceof Message){
			return messages.remove(id);
//			return message;
		}
		return null;
	}
}
