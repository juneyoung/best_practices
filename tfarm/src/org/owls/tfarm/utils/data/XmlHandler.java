package org.owls.tfarm.utils.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlHandler {
	
	public static String xmlString(Object from) throws JsonProcessingException{
		ObjectMapper mapper = new XmlMapper();
		return mapper.writeValueAsString(from);
	}
}
