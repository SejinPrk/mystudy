package bitcamp.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource({
    "classpath:config/ncp.properties",
    "classpath:config/ncp-secret.properties"
})
public class App {

  public static void main(String[] args) throws Exception {
    System.out.println("과제관리 시스템 서버 실행!");
    SpringApplication.run(App.class, args);
  }
}
