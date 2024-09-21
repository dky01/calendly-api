package com.calendly.resources;

import com.calendly.dto.CreateUserRequest;
import com.calendly.models.User;
import com.calendly.services.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import javax.inject.Inject;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserService userService;

    @Inject
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    public void createUser(CreateUserRequest request) {
        userService.addUser(request.toNewUser());
    }

    @GET
    @Path("/{userId}")
    public User getUser(
            @PathParam("userId") String userId
    ) {
        System.out.println("here " + userService.getUser(userId));
        return userService.getUser(userId);
    }
}
