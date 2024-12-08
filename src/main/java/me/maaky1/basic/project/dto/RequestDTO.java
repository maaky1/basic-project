package me.maaky1.basic.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class RequestDTO<T> {

    private String requestId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime requestAt;
    private T requestPayload;

    @Builder(builderMethodName = "newBuilder")
    public RequestDTO(String requestId, LocalDateTime requestAt , T requestPayload) {
        this.requestId = requestId;
        this.requestAt = requestAt;
        this.requestPayload = requestPayload;
    }
}
