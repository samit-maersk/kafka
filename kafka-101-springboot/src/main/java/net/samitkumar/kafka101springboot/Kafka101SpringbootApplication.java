package net.samitkumar.kafka101springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Kafka101SpringbootApplication {
	private final Producer producer;
	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

	@Autowired
	Kafka101SpringbootApplication(Producer producer) {
		this.producer = producer;
	}


	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Kafka101SpringbootApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);

		//SpringApplication.run(Kafka101SpringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunnerBean() {
		return (args) -> {
			for (String arg : args) {
				switch (arg) {
					case "--producer":
						this.producer.sendMessage("awalther", "t-shirts");
						this.producer.sendMessage("htanaka", "t-shirts");
						this.producer.sendMessage("htanaka", "batteries");
						this.producer.sendMessage("eabara", "t-shirts");
						this.producer.sendMessage("htanaka", "t-shirts");
						this.producer.sendMessage("jsmith", "book");
						this.producer.sendMessage("awalther", "t-shirts");
						this.producer.sendMessage("jsmith", "batteries");
						this.producer.sendMessage("jsmith", "gift card");
						this.producer.sendMessage("eabara", "t-shirts");
						break;
					case "--consumer":
						MessageListenerContainer listenerContainer = kafkaListenerEndpointRegistry.getListenerContainer("myConsumer");
						listenerContainer.start();
						break;
					default:
						break;
				}
			}
		};
	}
}
