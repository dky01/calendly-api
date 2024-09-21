package com.calendly.resources;

import com.calendly.dto.AddAvailabilityRequest;
import com.calendly.dto.AvailabilitySummary;
import com.calendly.models.Slot;
import com.calendly.services.SchedulingService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import javax.inject.Inject;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/user-availability")
public class AvailabilityResource {
    private SchedulingService schedulingService;

    @Inject
    public AvailabilityResource(SchedulingService availabilityService) {
        this.schedulingService = availabilityService;
    }

    @POST
    public void addAvailability(AddAvailabilityRequest request) {
        schedulingService.addAvailabilitySlots(request);
    }

    @GET
    @Path("/{userId}")
    public AvailabilitySummary getSummary(
            @PathParam("userId") String userId,
            @QueryParam("date") String date
    ) {
        return schedulingService.getAvailabilitySummary(userId, date);
    }

    @GET
    @Path("/{userId1}/overlap/{userId2}")
    public List<Slot> getOverlaps(
            @PathParam("userId1") String userId1,
            @PathParam("userId2") String userId2,
            @QueryParam("date") String date
    ) {
        return schedulingService.getCommonAvailableSlots(userId1, userId2, date);
    }
}
