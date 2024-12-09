package me.maaky1.basic.project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GenericResponseDTO<T> {

    private String status;
    private String code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
