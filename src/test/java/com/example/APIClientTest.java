package com.example;


import com.example.operation.APIClient;
import com.example.request.APIRequest;
import com.example.request.Header;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class APIClientTest {


    private APIClient client;
    private APIRequest request;

    @Before
    public void setUp(){
        this.client = new APIClient();
        this.request = APIRequest.builder()
                        .requestBody("{}")
                                .url("http://localhost:8080/workflow/start")
                                        .header(Header.builder()
                                                .authHeader("authHeader")
                                                .tid("tid")
                                                .source("lib")
                                                .build()).build();
    }

    @Test
    public void postQuery(){
            String response = client.postQuery(request);
            assert StringUtils.equals(response,"{workflow-started}");
    }

}
