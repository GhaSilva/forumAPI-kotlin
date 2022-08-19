package br.com.ghabriel.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
