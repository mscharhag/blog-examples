package com.mscharhag.koin

class AddressValidatorImpl : AddressValidator {

    override fun validate(address: Address): Boolean {
        // decide if address is valid ;-)
        return Math.random() < 0.8
    }

}