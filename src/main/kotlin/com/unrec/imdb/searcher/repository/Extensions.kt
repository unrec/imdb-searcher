package com.unrec.imdb.searcher.repository

fun String.toIntList() = this.split(",").map { it.toInt() }
