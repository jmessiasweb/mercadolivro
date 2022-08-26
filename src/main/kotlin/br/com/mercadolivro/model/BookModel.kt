package com.mercadolivro.model

import br.com.mercadolivro.enums.BookStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? =  null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null

)