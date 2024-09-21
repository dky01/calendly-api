package com.calendly;

import com.calendly.resources.AvailabilityResource;
import com.calendly.resources.EventResource;
import com.calendly.resources.UserResource;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class CalendlyApplication extends Application<CalendlyConfiguration> {

    private Injector injector;
    @Override
    public void run(CalendlyConfiguration configuration, Environment environment) {
        environment.jersey().register(new CalendlyExceptionMapper());
        injector = Guice.createInjector(new CalendlyModule(configuration));
//        runAdditional(environment, injector.getInstance(Jdbi.class));
        environment.jersey().register(injector.getInstance(UserResource.class));
        environment.jersey().register(injector.getInstance(AvailabilityResource.class));
        environment.jersey().register(injector.getInstance(EventResource.class));
    }

    @Override
    public void initialize(Bootstrap<CalendlyConfiguration> bootstrap) {
    }

    public static void main(String[] args) {
        try {
            new CalendlyApplication().run(args);
        } catch (Exception e) {
            System.out.printf("Error starting application %s", e);
        }
    }
}
