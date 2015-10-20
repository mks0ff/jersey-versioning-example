package com.accor.examples.resource;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.accor.examples.model.Track;
import com.accor.examples.model.TrackV2;

@Provider
@Produces("application/vnd.musicstore-v2+json")
public class TrackResourceV2Impl implements TrackResource, ContextResolver<TrackResource> {
    public List<Track> index() {
        return new LinkedList<Track>() {
            {
                add(new TrackV2("Wu-Tang", "Da Mystery of ChessBoxin'", 150, 1983));
                add(new TrackV2("Wu-Tang", "C.R.E.A.M", 291, 1986));
            }
        };
    }

    public Track get(int id) {
        return new TrackV2("Wu-Tang", "4th Chamber", 150, 1941);
    }

    public TrackResource getContext(Class<?> type) {
        return this;
    }
}
