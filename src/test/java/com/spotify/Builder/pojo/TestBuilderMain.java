package com.spotify.Builder.pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestBuilderMain {
@Test
	public static void main() throws JsonProcessingException {
		Builder_Pojo builder=new Builder_Pojo.Builder()
				             .setName("MyPlayList_Bibhu")
				             .setDescription("AutomationPLaylist Description")
				             .setPublic(false)
				             .build();
		
		 ObjectMapper mapper = new ObjectMapper();
	        String jsonPayload = mapper.writeValueAsString(builder);
	        
	        System.out.println(jsonPayload.toString());
	}
}
