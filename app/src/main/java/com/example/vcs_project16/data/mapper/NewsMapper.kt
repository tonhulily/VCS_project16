package com.example.vcs_project16.data.mapper

import com.example.vcs_project16.data.local.entity.NewsEntity
import com.example.vcs_project16.data.remote.dto.NewsDto
import com.example.vcs_project16.domain.model.News

fun NewsDto.toEntity(): NewsEntity {
    return NewsEntity(
        articleUrl = url ?: "",
        title = title ?: "",
        description = description ?: "",
        content = content ?: "",
        imageUrl = urlToImage ?: "",
        author = author ?: "Unknown",
        source = source?.name ?: "",
        publishedAt = publishedAt ?: "",
        updatedAt = System.currentTimeMillis()
    )
}

fun NewsEntity.toDomain(): News {
    return News(
        articleUrl = articleUrl,
        title = title,
        description = description,
        content = content,
        imageUrl = imageUrl,
        author = author,
        source = source,
        publishedAt = publishedAt
    )
}