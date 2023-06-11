package com.laureanti.vknewsclient.domain.usecases

import com.laureanti.vknewsclient.domain.repository.NewsFeedRepository

class LoadNextDataUseCase(
    private val repository: NewsFeedRepository
) {
    suspend operator fun invoke(){
        repository.loadNextData()
    }
}