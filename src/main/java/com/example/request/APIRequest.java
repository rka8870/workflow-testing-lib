package com.example.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIRequest {
    private String url;
    private Header header;
    private String requestBody;
}
