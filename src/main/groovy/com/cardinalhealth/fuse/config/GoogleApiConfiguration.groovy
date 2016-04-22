package com.cardinalhealth.fuse.config

import com.cardinalhealth.fuse.api.GoogleApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit.RestAdapter
import retrofit.client.OkClient

import static retrofit.RestAdapter.LogLevel.BASIC

@Configuration
class GoogleApiConfiguration {

    @Value('${google.api.key}')
    private String googleApiKey

    @Value('${google.api.url}')
    private String googleApiUrl

    @Bean
    GoogleApi googleApi(OkClient okClient,
                        GoogleApiRequestInterceptor googleApiRequestInterceptor) {
        return new RestAdapter.Builder()
                .setClient(okClient)
                .setRequestInterceptor(googleApiRequestInterceptor)
                .setEndpoint(googleApiUrl)
                .setLogLevel(BASIC)
                .build()
                .create(GoogleApi)
    }

    @Bean
    OkClient okClient() {
        return new OkClient()
    }

    @Bean
    GoogleApiRequestInterceptor googleApiRequestInterceptor() {
        return new GoogleApiRequestInterceptor(googleApiKey)
    }
}
