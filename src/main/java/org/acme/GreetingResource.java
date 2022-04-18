package org.acme;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.reactive.mutiny.Mutiny;

import io.smallrye.mutiny.Uni;

@Path("/hello-particles")
@io.smallrye.common.annotation.NonBlocking
public class GreetingResource {

    @Inject
    Mutiny.Session mutinySession;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello Particle";
    }

    @GET
    @Path("/particles")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<List<ParticleEntity>> getAllParticles() {
        return mutinySession
                .createNamedQuery( "Particles.findAll", ParticleEntity.class )
                .getResultList();
    }


    @GET
    @Path("/particlesjson")
    @Produces({MediaType.TEXT_HTML})
    public Uni<List<ParticleEntity>> getAllParticlesJson() {
        return mutinySession
                .createNamedQuery( "Particles.findAll", ParticleEntity.class )
                .getResultList();
    }

    @Transactional
    @POST
    @Path("/particle/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Response> addParticles(@PathParam("name") String name) {


        ParticleEntity particle = new ParticleEntity();
        particle.setName(name);

        return mutinySession
                .persist(particle)
                .chain(mutinySession::flush)
                .map(ignore -> Response.ok(particle).status(201).build());
    }

}