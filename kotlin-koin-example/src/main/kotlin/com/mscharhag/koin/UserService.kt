package com.mscharhag.koin

class UserService(
    private val addressValidator: AddressValidator
) {

    fun createUser(username: String, address: Address) {
        val valid = addressValidator.validate(address)
        println("Creating user, valid: $valid")
    }
}