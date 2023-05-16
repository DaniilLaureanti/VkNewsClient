package com.laureanti.vknewsclient.data.mapper

import com.laureanti.vknewsclient.data.model.NewsFeedResponseDto
import com.laureanti.vknewsclient.domain.FeedPost
import com.laureanti.vknewsclient.domain.StatisticItem
import com.laureanti.vknewsclient.domain.StatisticType
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.math.absoluteValue

class NewsFeedMapper {

    fun mapResponseToPost(responseDto: NewsFeedResponseDto): List<FeedPost> {
        val result = mutableListOf<FeedPost>()
        val posts = responseDto.newsFeedContent.posts
        val groups = responseDto.newsFeedContent.groups

        for (post in posts) {
            val group = groups.find { it.id == post.communityId.absoluteValue } ?: break
            val feedPost = FeedPost(
                id = post.id,
                communityName = group.name,
                publicationDate = mapTimestampToDate(post.date * 1000),
                communityImageUrl = group.imageUrl,
                contentText = post.text,
                contentImageUrl = post.attachments?.firstOrNull()?.photo?.photoUrls?.lastOrNull()?.url,
                statistics = listOf(
                    StatisticItem(type = StatisticType.LIKES, post.likes.count),
                    StatisticItem(type = StatisticType.VIEWS, post.views.count),
                    StatisticItem(type = StatisticType.SHARES, post.reposts.count),
                    StatisticItem(type = StatisticType.COMMENTS, post.comments.count)
                ),
                isFavourite = post.isFavourite
            )
            result.add(feedPost)
        }

        return result
    }

    private fun mapTimestampToDate(timestamp: Long): String{
        val date = Date(timestamp)
        return SimpleDateFormat("dd MMMM yyyy, hh:mm", Locale.getDefault()).format(date)
    }
}