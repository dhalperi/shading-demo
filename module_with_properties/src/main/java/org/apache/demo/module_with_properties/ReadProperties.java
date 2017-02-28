package org.apache.demo.module_with_properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by dhalperi on 2/27/17.
 */
public class ReadProperties {
  private static final String PROPERTIES_PATH = "/org/apache/demo/module_with_properties/some.properties";

  public static void main(String[] args) throws IOException {
    try (InputStream in = ReadProperties.class.getResourceAsStream(PROPERTIES_PATH)) {
      if (in == null) {
        throw new RuntimeException(PROPERTIES_PATH);
      }

      Properties properties = new Properties();
      properties.load(in);
      System.err.println(properties);
    }
  }
}
