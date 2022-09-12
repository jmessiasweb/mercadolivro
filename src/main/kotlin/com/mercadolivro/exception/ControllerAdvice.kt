package br.com.mercadolivro.exception

import br.com.mercadolivro.controller.response.ErroResponse
import br.com.mercadolivro.controller.response.FielErrorResponse
import br.com.mercadolivro.enums.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErroResponse> {
        val erro =  ErroResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            null

        )
        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErroResponse> {
        val erro =  ErroResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null

        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<ErroResponse> {
        val erro =  ErroResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            Errors.ML001.message,
            Errors.ML001.code,
            ex.bindingResult.fieldErrors.map { FielErrorResponse(it.defaultMessage ?: "invalid", it.field) }

        )
        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}