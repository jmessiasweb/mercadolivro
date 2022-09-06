package br.com.mercadolivro.validation

import br.com.mercadolivro.service.CustomerService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailAvalibleValidator(var customerService: CustomerService): ConstraintValidator<EmailAvalible, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()){
            return false
        }
        return customerService.emailAvailable(value)
    }

}
