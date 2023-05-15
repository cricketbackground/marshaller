package com.example.marshaller.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true, value = {"numbers"}, allowSetters = true)
public class DummyMessage2 extends BaseRequest {

    private String numbers;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public List<String> getTokens() {
        if (StringUtils.isBlank(this.numbers)) return Collections.emptyList();
        return List.of(this.numbers.split(";\\s*"));
    }
}
