package com.example.vcs_project16.utils

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
fun String.toNewsDate(): String {
    return try {
        val date = OffsetDateTime.parse(this)
        date.format(
            DateTimeFormatter.ofPattern(
                "MMMM d, yyyy",
                Locale.ENGLISH
            )
        )
    } catch (_: Exception) {
        this
    }
}
fun String.cleanContent(): String {
    return this.replace(
        Regex("\\[\\+\\d+ chars]"),
        ""
    ).trim()
}