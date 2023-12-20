package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val id: String,
    val volumeInfo: VolumeInfo,
    val saleInfo: SaleInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    val description: String,
    val imageLinks: ImageLinks? = null,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
    val pageCount: Int,
    val averageRating: Float,
) {
    fun allAuthors() : String {
        var x= ""
        for (author in authors) {
            x += "$author, "
        }
        return x.trimEnd(',', ' ')
    }
}

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
)


@Serializable
data class SaleInfo(
    val country: String,
    val listPrice: ListPrice?
) {
    val getPrice : String
        get() = "${listPrice?.amount ?: "N/A"} ${listPrice?.currencyCode ?: "N/A"}"

}

@Serializable
data class ListPrice(
    val amount: Float?,
    val currencyCode: String? = ""
)