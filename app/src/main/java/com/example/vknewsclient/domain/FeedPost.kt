package com.example.vknewsclient.domain

import com.example.vknewsclient.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "dev/null",
    val publicationDate: String = "12:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contextText: String = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, 966),
        StatisticItem(type = StatisticType.SHARES, 7),
        StatisticItem(type = StatisticType.COMMENTS, 8),
        StatisticItem(type = StatisticType.LIKES, 27)
    )
)
