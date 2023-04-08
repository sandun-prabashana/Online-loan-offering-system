package com.bumblebee.project.utility.Util2;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardResponse {
    String code;
    String message;
    Object data;


}
