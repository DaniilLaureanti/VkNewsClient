package com.laureanti.vknewsclient.presentation.news

import com.laureanti.vknewsclient.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial: NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()

//    data class Comments(
//        val feedPost: FeedPost,
//        val comments: List<PostComment>
//    ) : HomeScreenState()
}