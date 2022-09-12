package br.com.mercadolivro.controller.request

import java.math.BigDecimal

data class PutBookRequest (
    var nome: String?,
    var price: BigDecimal?

)