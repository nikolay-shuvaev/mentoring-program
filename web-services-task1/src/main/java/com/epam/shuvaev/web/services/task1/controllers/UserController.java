package com.epam.shuvaev.web.services.task1.controllers;

import com.epam.shuvaev.web.services.task1.dto.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by Nikolay Shuvaev on 20.03.2017
 */
@Path("user")
public class UserController {
    // Simplify Service and DAO layers
    private static Map<Long, User> storage = new HashMap<>();
    private static Long counter = 0L;

    @Context
    Request request;
    /*
    Please, write Rest web services for User directory that provide CRUD operations on User.
    User information should contain at least: first name, last name, login and email.
     For creation of the user, please, use XML, for user update JSON format. Create also Rest service to upload
     and download user logo as Image. The application should be implemented and deploy on application server.
     You can use any Rest implementation (Jersey, Restlet, etc.). To test your application, please, use jersey
     Rest client that will cover all operations. User data can be saved anywhere, database is not required.
     */

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createUser(User newUser) {
        Optional<Response> errorResponse = validate(newUser);

        if (errorResponse.isPresent()) {
            return errorResponse.get();
        }

        newUser.setId(++counter);
        storage.put(newUser.getId(), newUser);

        return Response.status(Response.Status.CREATED).entity(newUser.getId()).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_XML)
    public Response updateUser(@PathParam("id") Long id, User newUser) {

        if (storage.containsKey(id)) {
            User user = storage.get(id);
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setEmail(newUser.getEmail());
            storage.put(id, user);

            return Response.ok().build();
        }

        return Response.status(Response.Status.BAD_REQUEST).entity("User with id " + id + " does not exist.").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getAllUsers() {
        return new ArrayList<>(storage.values());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getUser(@PathParam("id") Long id) {
        if (storage.containsKey(id)) {
            return Response.ok(storage.get(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("No user with id " + id).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteUser(@PathParam("id") Long id) {
        if (storage.containsKey(id)) {
            storage.remove(id);
            return Response.ok().build();
        }

        return Response.status(Response.Status.BAD_REQUEST).entity("User with id " + id + " does not exist.").build();
    }

    private Optional<Response> validate(User newUser) {
        if (newUser.getLogin() == null) {
            return Optional.ofNullable(
                    Response.status(Response.Status.BAD_REQUEST).entity("Login is not presented.").build());
        }

        if (storage.values().stream()
                .anyMatch(user ->
                        user.getLogin().equals(newUser.getLogin()))) {
            return Optional.ofNullable(
                    Response.status(Response.Status.BAD_REQUEST).entity("Login is already presented. Login: "
                            + newUser.getLogin()).build());
        }

        return Optional.empty();
    }
}
