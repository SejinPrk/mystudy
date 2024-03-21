package bitcamp.myapp.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@ComponentScan(value = {
    "bitcamp.myapp.controller"
})
public class AppConfig {
  private final Log log = LogFactory.getLog(RootConfig.class);

  public AppConfig() {
    log.debug("생성자 호출됨!");
  }

  @Bean
  MultipartResolver multipartResolver() {
    return new StandardServletMultipartResolver();
  }
}