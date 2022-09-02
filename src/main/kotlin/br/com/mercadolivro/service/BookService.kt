package br.com.mercadolivro.service

import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.exeption.NotFoundException
import br.com.mercadolivro.repositoy.BookRepository
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {


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
        return bookRepository.findById(id).orElseThrow{ NotFoundException("Book [${id}] not exists", "ML-0001 ") }
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

}
