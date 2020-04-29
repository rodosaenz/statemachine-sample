package io.rodosz.statemachine;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import io.rodosz.statemachine.enums.Events;
import io.rodosz.statemachine.enums.States;

@SpringBootApplication
public class Application {
	
	@Autowired
    private StateMachine<States, Events> stateMachine;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@PostConstruct
	public void postConstruct() {
		
		stateMachine.start();
        stateMachine.sendEvent(Events.EVENT1);
        stateMachine.sendEvent(Events.EVENT2);
        
        System.out.println("Current State " + stateMachine.getState().getId());
	}

}
