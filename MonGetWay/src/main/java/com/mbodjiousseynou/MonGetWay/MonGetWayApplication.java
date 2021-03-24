package com.mbodjiousseynou.MonGetWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MonGetWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonGetWayApplication.class, args);
	}
	//@bean
	RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route((r)->r.path("/etudiants/**").uri("lb://INSCRIPTION-ETUDIANT"))
				.build();
	}
	
	@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties) {
		return new DiscoveryClientRouteDefinitionLocator(rdc,properties);
	}

}
