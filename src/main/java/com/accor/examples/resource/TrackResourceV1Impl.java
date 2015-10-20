package com.accor.examples.resource;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.accor.examples.model.Track;
import com.accor.examples.model.TrackV1;

@Provider
@Produces("application/vnd.musicstore-v1+json")
public class TrackResourceV1Impl implements TrackResource, ContextResolver<TrackResource> {
    public Track get(int id) {
        return new TrackV1("Wu-Tang", "4th Chamber", "5:30", 1980);
    }

    public List<Track> index() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TrackResource getContext(Class<?> type) {
        return this;
    }
}
