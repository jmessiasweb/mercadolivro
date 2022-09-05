package br.com.mercadolivro.exeption

class BadRequestException(override val message: String, val errorCode: String): Exception() {
}