package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Defect {
    @SerializedName("title")
    private String title;
    @SerializedName("actual_result")
    private String actualResult;
    private int severity;
    @SerializedName("id")
    private int id;
}
