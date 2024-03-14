package bitcamp.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AdminWebApplicationInitializer extends
    AbstractAnnotationConfigDispatcherServletInitializer{

  private static Log log = LogFactory.getLog(AdminWebApplicationInitializer.class);

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{RootConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{AdminConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/admin/*"};
  }
  @Override
  protected String getServletName() {
    return "admin";
  }

}
