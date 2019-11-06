package au.com.appetiser.itunes.domain.repository

import au.com.appetiser.itunes.domain.Usage

interface UsageRepository {

    suspend fun load(): Usage?
}