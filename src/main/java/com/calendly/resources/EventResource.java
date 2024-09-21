package com.calendly.resources;

import com.calendly.dto.CreateEventRequest;
import com.calendly.services.SchedulingService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import javax.inject.Inject;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/events")
public class EventResource {
    private SchedulingService schedulingService;

    @Inject
    public EventResource(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @POST
    public void bookSlot(CreateEventRequest request) {
        schedulingService.createEvent(request);
    }
}
