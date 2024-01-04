package com.walmart.countries

import com.walmart.countries.model.Country
import com.walmart.countries.net.AppService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryRepository @Inject constructor(
    private val appService: AppService
) {
    suspend fun getCountries(): Response<List<Country>> {
        return appService.countries()
    }
}
