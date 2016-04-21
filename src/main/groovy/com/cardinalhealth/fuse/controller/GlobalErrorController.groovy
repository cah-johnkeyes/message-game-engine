package com.cardinalhealth.fuse.controller

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE

@ControllerAdvice
class GlobalErrorController {

    @ResponseStatus(NOT_ACCEPTABLE)
    @ExceptionHandler(IllegalArgumentException)
    void handleIllegalArgument() {}

}
