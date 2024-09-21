package com.calendly;

import com.calendly.db.availability.AvailabilityDao;
import com.calendly.db.availability.InMemAvailabilityDao;
import com.calendly.db.user.InMemUserDao;
import com.calendly.db.user.UserDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class CalendlyModule extends AbstractModule {
    private final CalendlyConfiguration configuration;

    public CalendlyModule(CalendlyConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    protected void configure() {
        bind(UserDao.class).to(InMemUserDao.class);
        bind(AvailabilityDao.class).to(InMemAvailabilityDao.class);
    }

//    @Provides
//    @Singleton
//    public JedisPool provideJedisPool() {
//        return new JedisPool(
//                new JedisPoolConfig(),
//                "localhost",
//                6379,
//                10000
//        );
//    }

    @Provides
    @Singleton
    public ObjectMapper provideObjectMapper() {
        return new ObjectMapper();
    }

    @Provides
    @Singleton
    public CalendlyConfiguration provideConfiguration() {
        return configuration;
    }
}
