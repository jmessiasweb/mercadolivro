package br.com.mercadolivro.service

import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.enums.Errors
import br.com.mercadolivro.exception.NotFoundException
import br.com.mercadolivro.repositoy.BookRepository
import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {


    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable)

    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow{ NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code) }
    }

    fun delete(id: Int) {
        val book = findById(id)

        book.status = BookStatus.CANSELADO

        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)


    }
    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        for (book in books ) {
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)
    }

    fun findAllByIds(bookIds: Set<Int>): List<BookModel> {
       return bookRepository.findAllById(bookIds).toList()
    }

    fun purchase(books: MutableList<BookModel>) {
        books.map {
            it.status = BookStatus.VENDIDO
        }
        bookRepository.saveAll(books)
    }

}
