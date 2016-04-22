package com.cardinalhealth.fuse.api

import retrofit.http.Body
import retrofit.http.POST

import javax.xml.ws.Response


interface GoogleApi {

    @POST("/gcm/send")
    Map sendGcmMessage(@Body Map body)

}