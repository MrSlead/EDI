package com.almod.edi.config;

import org.apache.activemq.ActiveMQSslConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {
    @Value("${broker.url}")
    public String BROKER_URL;

    @Value("${broker.username}")
    public String BROKER_USERNAME;

    @Value("${broker.password}")
    public String BROKER_PASSWORD;

    @Value("${path.trustStore}")
    public String pathTrustStore;

    @Value("${path.passwordTrustStore}")
    public String passwordTrustStore;

    @Bean
    public ActiveMQSslConnectionFactory connectionFactory(){
        ActiveMQSslConnectionFactory connectionFactory = new ActiveMQSslConnectionFactory();

        try {
            connectionFactory.setBrokerURL(BROKER_URL);
            connectionFactory.setPassword(BROKER_USERNAME);
            connectionFactory.setUserName(BROKER_PASSWORD);

            connectionFactory.setTrustStore(pathTrustStore);
            connectionFactory.setTrustStorePassword(passwordTrustStore);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("1-1");
        return factory;
    }
}