package com.example.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Header {
    private String authHeader;
    private String source;
    private String tid;
}
