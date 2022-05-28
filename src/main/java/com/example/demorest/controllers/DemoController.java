package com.example.demorest.controllers;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.example.demorest.models.Demo;
import com.example.demorest.services.DemoService;

import org.springframework.stereotype.Component;

@Component
@Path("/")
public class DemoController {
    private DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;

        this.demoService.add(new Demo("uno", Math.random()));
        this.demoService.add(new Demo("dos", Math.random()));
        this.demoService.add(new Demo("tres", Math.random()));
        this.demoService.add(new Demo("cuatro", Math.random()));
        this.demoService.add(new Demo("cinco", Math.random()));
        this.demoService.add(new Demo("seis", Math.random()));
    }

    @GET
    @Path("/demos")
    @Produces("application/json")
    public List<Demo> ListarTodos() {
        return demoService.getAll();
    }

    @GET
    @Path("/demos/{nombre}")
    @Produces("application/json")
    public Demo listarUno(@PathParam("nombre") String nombre) {
        return demoService.get(nombre);
    }

    @POST
    @Path("/demos")
    @Produces("application/json")
    @Consumes("application/json")
    public Response meterDemo(Demo demo) {
        demoService.add(demo);
        return Response.created(
                URI.create("/demos/" + demo.getNombre())).build();
    }
}
