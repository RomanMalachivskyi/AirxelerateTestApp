package com.airxelerate.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenResult {

    @NonNull
    private String jwtToken;
}
