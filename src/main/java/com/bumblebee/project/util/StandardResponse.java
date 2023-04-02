package com.bumblebee.project.util;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardResponse {
    String code;
    String message;
    Object data;


}
