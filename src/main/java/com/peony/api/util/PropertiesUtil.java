package com.peony.api.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class PropertiesUtil {
	private static Properties peonyProperties = new Properties();
	static {
		ClassPathResource cr = new ClassPathResource("msg.properties");
		try {
			peonyProperties.load(cr.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getSmsPropertiesVal(String key) {
		return peonyProperties.getProperty(key);
	}
}
