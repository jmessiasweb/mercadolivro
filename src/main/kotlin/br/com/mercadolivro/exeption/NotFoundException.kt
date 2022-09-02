package br.com.mercadolivro.exeption

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}