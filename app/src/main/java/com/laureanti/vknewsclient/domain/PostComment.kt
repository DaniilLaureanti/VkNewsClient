package com.laureanti.vknewsclient.domain

import com.laureanti.vknewsclient.R

data class PostComment(
    val id: Int = 0,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.avatar_comment,
    val commentText: String = "Long comment text",
    val publicationDate: String = "14:00 "

)
