package com.laureanti.vknewsclient.domain.usecases

import com.laureanti.vknewsclient.domain.entity.AuthState
import com.laureanti.vknewsclient.domain.entity.FeedPost
import com.laureanti.vknewsclient.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.StateFlow

class GetAuthStateFlowUseCase(
    private val repository: NewsFeedRepository
) {
    operator fun invoke(): StateFlow<AuthState> {
        return repository.getAuthStateFlow()
    }
}