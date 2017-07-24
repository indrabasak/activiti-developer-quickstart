package com.basaki.example.activiti;

import java.util.Date;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * {@code AutomatedDataDelegate} is a Java task responsible for “Generic and
 * Automated Data Entry” (a faux backend call).
 * <p/>
 *
 * @since 7/24/17
 */
@SuppressWarnings({"squid:S106"})
public class AutomatedDataDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        Date now = new Date();
        //Sets a process variable, autoWelcomeTime, with the current time.
        execution.setVariable("autoWelcomeTime", now);

        //Retrieves a process variable, fullName, and prints it out in the console.
        System.out.println("Faux call to backend for ["
                + execution.getVariable("fullName") + "]");
    }
}
