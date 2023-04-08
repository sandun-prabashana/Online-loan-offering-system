package com.bumblebee.project.dto;
/*
 * @author Yohan Samitha
 * @since 4/2/2023
 */

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayLoadDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sessionId;
    private String userName;
    private String tabId;
    private Date expiresTime;

    public PayLoadDTO(String sessionId, String userName) {
        this.sessionId = sessionId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
