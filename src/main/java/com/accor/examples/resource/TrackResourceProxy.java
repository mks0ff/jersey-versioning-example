package com.accor.examples.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Providers;

import com.accor.examples.model.Track;

@Path("{version:(v[0-9])?}{p:/?}track") // optional uri version
@Resource
public class TrackResourceProxy implements TrackResource {
    private TrackResource trackResource;

    public TrackResourceProxy(@Context Providers providers, @Context HttpHeaders httpHeaders) {
        for (MediaType mediaType : httpHeaders.getAcceptableMediaTypes()) {
            ContextResolver<TrackResource> trackResourceResolver = providers.getContextResolver(TrackResource.class, mediaType);

            if (trackResourceResolver != null) {
                trackResource = trackResourceResolver.getContext(null);
            }
        }
        if (trackResource == null) // if no accept header then get the latest implementation
            trackResource = new TrackResourceV2Impl();
    }

    public List<Track> index() {
        return trackResource.index();
    }

    public Track get(int id) {
        return trackResource.get(id);
    }
}
