package com.desafiolatam;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaG6Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaG6Application.class, args);
	}

	/* En la clase Application del proyecto, pegar bajo el método main: */
		  
		  @Bean
		    public TomcatServletWebServerFactory servletContainer() {
		        TomcatServletWebServerFactory tomcat= new TomcatServletWebServerFactory();
		        Connector ajpConnector= new Connector("AJP/1.3");
		        ajpConnector.setPort(9090);
		        ajpConnector.setSecure(false);
		        ajpConnector.setAllowTrace(false);
		        ajpConnector.setScheme("http");
		        ((AbstractAjpProtocol) ajpConnector.getProtocolHandler()).setSecretRequired(false);
		        tomcat.addAdditionalTomcatConnectors(ajpConnector);
		        return tomcat;
		    }
		    
}
