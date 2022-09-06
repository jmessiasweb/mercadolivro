package br.com.mercadolivro.controller.request

import br.com.mercadolivro.validation.EmailAvalible
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class PostCustumerRequest(

    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,

    @field:Email(message = "E-mail deve ser valido")
    @EmailAvalible
    var email: String
)