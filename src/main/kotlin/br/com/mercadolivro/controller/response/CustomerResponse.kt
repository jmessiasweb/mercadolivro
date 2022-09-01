package br.com.mercadolivro.controller.response

import br.com.mercadolivro.enums.CustomerStatus

data class CustomerResponse(
    val id: Int? = null,

    var name: String,

    var email: String,

    var status: CustomerStatus

)
