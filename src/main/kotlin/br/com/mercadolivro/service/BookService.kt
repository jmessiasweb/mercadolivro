package br.com.mercadolivro.service

import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.repositoy.BookRepository
import com.mercadolivro.model.BookModel
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository

) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun findActives(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO)

    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {
        val book = findById(id)

        book.status = BookStatus.CANSELADO

        bookRepository.save(book)
    }

}
