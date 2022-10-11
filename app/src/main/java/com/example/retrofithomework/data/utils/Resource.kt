package com.example.retrofithomework.data.utils

data class Resource<out T>(var status: Status, var data: @UnsafeVariance T?, var message: String?) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String,data: T?): Resource<T> {
            return Resource(Status.ERROR,data , msg)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null)
        }

    }

}
