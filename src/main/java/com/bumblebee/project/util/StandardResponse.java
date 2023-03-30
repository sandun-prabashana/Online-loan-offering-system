package com.bumblebee.project.util;

import lombok.*;

@Getter
@Setter
@Data
public class StandardResponse {
    String code;
    String message;
    Object data;

    public StandardResponse() {
    }

    public StandardResponse(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
