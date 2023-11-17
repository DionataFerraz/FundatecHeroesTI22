package br.com.fundatec.fundatecheroti22.login.domain

fun String.isValidEmail():Boolean {
    return contains("@") && contains("com")
}