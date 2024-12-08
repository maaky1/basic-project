package me.maaky1.basic.project.util;

import me.maaky1.basic.project.dto.RequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CommonUtil {

    public synchronized static RequestDTO constructRequestPayload(String requestId,
                                                                  LocalDateTime requestAt,
                                                                  Object requestPayload) {

        return RequestDTO.newBuilder()
                .requestId(requestId != null ? requestId : UUID.randomUUID().toString())
                .requestAt(requestAt != null ? requestAt : LocalDateTime.now())
                .requestPayload(requestPayload)
                .build();
    }
}
