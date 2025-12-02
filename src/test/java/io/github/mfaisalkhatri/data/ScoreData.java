package io.github.mfaisalkhatri.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ScoreData {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Score")
    private double score;
}