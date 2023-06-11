package com.laureanti.vknewsclient.presentation.comments

import com.laureanti.vknewsclient.domain.entity.FeedPost
import com.laureanti.vknewsclient.domain.entity.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}