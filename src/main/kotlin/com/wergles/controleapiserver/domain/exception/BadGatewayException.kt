package com.wergles.controleapiserver.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_GATEWAY)
class BadGatewayException(msg: String) : RuntimeException(msg)
