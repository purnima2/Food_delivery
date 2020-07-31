/**Entry point of Application
 * */
package com.coding.FoodDelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
@ComponentScan(basePackages = {"com.coding","com.coding.service"})
@EnableJpaRepositories(basePackages = { "com.coding.repository" })
@EntityScan(basePackages={"com.coding.model"})
public class FoodDeliveryApplication {
	public static void main(String[] args) {

		SpringApplication.run(FoodDeliveryApplication.class, args);

		}
}
