package edu.ukma.lecture2

@JvmInline
value class ResponseCode(private val code: Int) {
    fun isInformational(): Boolean = code in 100 until 200
    fun isSuccess(): Boolean = code in 200 until 300
    fun isRedirection(): Boolean = code in 300 until 400
    fun isClientError(): Boolean = code in 400 until 500
    fun isServiceError(): Boolean = code in 500 until 600
}

fun processResponse(responseId: Int, responseCode: Int) {}

fun processResponse(responseId: Int, responseCode: ResponseCode) {}