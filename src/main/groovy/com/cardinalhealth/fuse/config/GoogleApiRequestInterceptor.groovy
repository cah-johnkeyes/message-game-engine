package com.cardinalhealth.fuse.config

import retrofit.RequestInterceptor

class GoogleApiRequestInterceptor implements RequestInterceptor {

    private String authHeader

    public GoogleApiRequestInterceptor(String apiKey) {
        authHeader = "key=$apiKey"
    }

    @Override
    public void intercept(RequestInterceptor.RequestFacade request) {
        request.addHeader("Authorization", authHeader)
        request.addHeader("Content-Type", "application/json")
    }

}
