package com.proj;

import java.io.IOException;
import java.util.Properties;

public class TestHelper {

	public String getProperty(String file, String name) {

		String value = null;

		Properties prop = new Properties();

		try {
			prop.load(TestHelper.class.getResourceAsStream(file));

			return prop.getProperty(name);

		} catch (IOException e) {
		}

		return value;

	}
	
}
