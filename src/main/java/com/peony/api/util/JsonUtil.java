package com.peony.api.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	/**
	 * 对象转json字符串
	 * 
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String parseToJson(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

	/**
	 * json字符串 转 list对象
	 * 
	 * @param source
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public final static <T> List<T> getListByString(String source, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper jacksonMapper = new ObjectMapper();
		JavaType javaType = jacksonMapper.getTypeFactory().constructParametrizedType(ArrayList.class, List.class,
				clazz);
		List<T> lst = (List<T>) jacksonMapper.readValue(source, javaType);
		return lst;
	}

	/**
	 * 字符串转java对象
	 * 
	 * @param jsonSource
	 * @param clazz
	 * @return
	 */
	public final static <T> T getObjectByJSON(String jsonSource, Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		T t = null;
		try {
			t = mapper.readValue(jsonSource, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}
}
