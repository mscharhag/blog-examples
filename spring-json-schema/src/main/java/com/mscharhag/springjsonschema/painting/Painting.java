package com.mscharhag.springjsonschema.painting;

import java.util.List;

public class Painting {
    private String name;
    private String artist;
    private String description;
    private Dimension dimension;
    private List<String> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Painting{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", description='" + description + '\'' +
                ", dimension=" + dimension +
                ", tags=" + tags +
                '}';
    }
}
