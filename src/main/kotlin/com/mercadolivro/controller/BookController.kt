package br.com.mercadolivro.controller

import br.com.mercadolivro.controller.request.PostBookRequest
import br.com.mercadolivro.controller.request.PutBookRequest
import br.com.mercadolivro.controller.response.BookResponse
import br.com.mercadolivro.extesion.toBookModel
import br.com.mercadolivro.extesion.toResponse
import br.com.mercadolivro.service.BookService
import br.com.mercadolivro.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("book")
class BookController(private val bookService: BookService,
                     private val customerService: CustomerService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: PostBookRequest) {
        val customer = customerService.findById((request.customerId))
        bookService.create(request.toBookModel(customer))

    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.findAll(pageable).map { it.toResponse() }
    }

    @GetMapping("/active")
    fun findActives(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> =
        bookService.findActives(pageable).map { it.toResponse() }


    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookResponse {
        return bookService.findById(id).toResponse()

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.findById(id)
        bookService.update(book.toBookModel(bookSaved))
    }
}