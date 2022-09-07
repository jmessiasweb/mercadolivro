package br.com.mercadolivro.controller.request

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class PostPurchaseResquest(

    @field:NotNull
    @field:Positive
    val customerId: Int,

    @field:NotNull
    val bookIds: Set<Int>

)