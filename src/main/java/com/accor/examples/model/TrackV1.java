package com.accor.examples.model;

public class TrackV1 implements Track {
    private final String artistName;
    private final String length;
    private final String title;
    private final int year;

    public TrackV1(String artistName, String title, String length, int year) {
        this.artistName = artistName;
        this.length = length;
        this.title = title;
        this.year = year;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public Object getLength() {
        return length;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return year;
    }
}
