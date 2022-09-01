package br.com.mercadolivro.exeption

import br.com.mercadolivro.controller.response.ErroResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControleAdvice {

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, request: WebRequest): ResponseEntity<ErroResponse> {
        val erro =  ErroResponse(
            400,
            "Este recurso não existe",
            "0001",
            null

        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }
}