package br.com.mercadolivro.controller.response

import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.model.CustomerModel
import java.math.BigDecimal

data class BookResponse (

    val id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status: BookStatus? = null

  )