package com.calendly;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.core.Configuration;

public class CalendlyConfiguration extends Configuration {

    @JsonProperty("logging")
    public void getLoggingInf() {

    }
}
