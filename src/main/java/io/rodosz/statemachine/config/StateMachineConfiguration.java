package io.rodosz.statemachine.config;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import io.rodosz.statemachine.enums.Events;
import io.rodosz.statemachine.enums.States;

@Configuration
@EnableStateMachine
public class StateMachineConfiguration extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
            .withStates()
                .initial(States.STATE1)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(States.STATE1).target(States.STATE2)
                .event(Events.EVENT1)
                .and()
            .withExternal()
                .source(States.STATE2).target(States.STATE3)
                .event(Events.EVENT2).and()
            .withExternal()
                .source(States.STATE3).target(States.STATE4)
                .event(Events.EVENT3).and()
            .withExternal()
                .source(States.STATE4).target(States.STATE5)
                .event(Events.EVENT4).and()
            .withExternal()
                .source(States.STATE5).target(States.STATE1)
                .event(Events.EVENT5);
    }
}
