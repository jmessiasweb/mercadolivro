package br.com.mercadolivro.repositoy

import br.com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {

    fun findByStatus(status: BookStatus): List<BookModel>
}