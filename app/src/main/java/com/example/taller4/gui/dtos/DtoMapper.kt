package com.example.taller4.gui.dtos

import com.example.taller4.database.entities.Book

class DtoMapper {
    companion object {
        fun mapToDto(book: Book): BookDTO =
            BookDTO(
                id = book.id,
                title = book.title,
                edition = book.edition,
                isbn = book.isbn,
                summary = book.summary,
                cover = book.cover
            )
    }
}