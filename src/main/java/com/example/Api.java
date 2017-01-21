package com.example;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Api<X> {
    public void call1(){
        // works
        RestTemplate rest = new RestTemplate();
        ParameterizedTypeReference<Fixer> myBean = new ParameterizedTypeReference<Fixer>() {};
        ResponseEntity<Fixer> response = rest.exchange("http://api.fixer.io/latest", HttpMethod.GET, null, myBean);
    }

    public void call2(){
        // returns hash map
        RestTemplate rest = new RestTemplate();
        ParameterizedTypeReference<X> myBean = new ParameterizedTypeReference<X>() {};
        ResponseEntity<X> response = rest.exchange("http://api.fixer.io/latest", HttpMethod.GET, null, myBean);
    }

    public ResponseEntity call3(ParameterizedTypeReference reference){
        // works
        RestTemplate rest = new RestTemplate();
        return rest.exchange("http://api.fixer.io/latest", HttpMethod.GET, null, reference);
    }
}
