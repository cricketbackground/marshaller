package com.example.marshaller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {

    @JsonIgnore
    @Builder.Default
    protected HttpStatus status = HttpStatus.OK;

    @Builder.Default
    protected String message = "success";

}
