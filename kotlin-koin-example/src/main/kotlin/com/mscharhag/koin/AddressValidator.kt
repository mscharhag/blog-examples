package com.mscharhag.koin

interface AddressValidator {
    fun validate(address: Address): Boolean
}