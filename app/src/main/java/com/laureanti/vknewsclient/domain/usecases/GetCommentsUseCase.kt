package com.laureanti.vknewsclient.domain.usecases

import com.laureanti.vknewsclient.domain.entity.FeedPost
import com.laureanti.vknewsclient.domain.entity.PostComment
import com.laureanti.vknewsclient.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.StateFlow

class GetCommentsUseCase(
    private val repository: NewsFeedRepository
) {
    operator fun invoke(feedPost: FeedPost): StateFlow<List<PostComment>>{
        return repository.getComments(feedPost)
    }
}