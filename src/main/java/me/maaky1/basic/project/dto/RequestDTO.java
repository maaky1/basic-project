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
    private String operationName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime requestAt;
    private T requestPayload;

    @Builder(builderMethodName = "newBuilder")
    public RequestDTO(String requestId, String operationName, LocalDateTime requestAt , T requestPayload) {
        this.requestId = requestId;
        this.operationName = operationName;
        this.requestAt = requestAt;
        this.requestPayload = requestPayload;
    }
}
