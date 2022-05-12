package com.wergles.controleapiserver.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
class BusinessException(msg: String) : RuntimeException(msg)
