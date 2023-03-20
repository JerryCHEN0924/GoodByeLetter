package com.iSpanProject.GoodByeletter.model.Tina.chat.utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iSpanProject.GoodByeletter.model.Tina.chat.ResultMessage;


public class MessageUtils {
	//getResultMessage
	public static String getResultMessage(boolean isSystem,String fromName, Object message) {
		try {
			ResultMessage result =new ResultMessage();
			result.setSystem(isSystem);
			result.setMessage(message);
			if(fromName!=null) {
			result.setFromName(fromName);
			}
			ObjectMapper mapper = new ObjectMapper();
			  // result(ResultMessage) Object 轉 json
			return mapper.writeValueAsString(result);
		}catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
