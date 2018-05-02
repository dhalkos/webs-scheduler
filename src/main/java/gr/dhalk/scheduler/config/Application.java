package gr.dhalk.scheduler.config;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Dimitris Chalkos 
 * @date 26/04/2018
 */


@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan({"gr.dhalk.scheduler"})
public class Application extends SpringBootServletInitializer implements ServletContextInitializer  {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
	@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        return new ServletRegistrationBean(servlet, "*.xhtml");
    }
    
    @Bean
    public FilterRegistrationBean rewriteFilter() {
    
    	FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR));
        rwFilter.addUrlPatterns("/*");
        return rwFilter;
    }

	/* (non-Javadoc)
	 * @see org.springframework.boot.web.servlet.ServletContextInitializer#onStartup(javax.servlet.ServletContext)
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	
		return builder.sources(
                new Class[] { Application.class});
	}

	
}
