package com.kimjieun99.gallery.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class WebConfig {

  @Value("${file.path}")
  private String uploadPath;

  public void addResouceHandlers(ResourceHandlerRegistry registry) {
    registry
      .addResourceHandler("/upload/**")
      .addResourceLocations("file:///" + uploadPath);
  }
}
