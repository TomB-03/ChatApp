package com.tomB.chatApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
//Message Broker verteilt Nachrichten
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        //an alle Clients
        registry.enableSimpleBroker("/chatroom", "/user");
        //für einzelnen Client
        registry.setUserDestinationPrefix("/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //Clients können sich mit der Route verbinden
        //withSockJS: JS-Library -> falls Websocket nicht verfügbar wird bspw. polling genutzt
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();

    }
}
