package ro.siit.proiectgrupa17;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Builder

@Data

public class Post {
    private List<String> pictures;
    private int likes;
    private List<String> comments;
    private int impressions;
    private List<String> addLinks;

    Post likes(int value) {
        this.likes = value;
        return this;
    }

}
