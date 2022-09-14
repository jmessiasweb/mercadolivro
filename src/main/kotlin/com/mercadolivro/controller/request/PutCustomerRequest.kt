package com.mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest(

    @field:NotEmpty(message = "Nome deve ser informado")
    val name: String,

    @field:Email(message = "E-mail deve ser valido")
    val email: String

)
