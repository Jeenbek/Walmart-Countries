package com.walmart.countries.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walmart.countries.CountryRepository
import com.walmart.countries.model.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {
    private val _countries = MutableLiveData<Response<List<Country>>>()
    val countries: LiveData<Response<List<Country>>> = _countries

    init {
        initCountries()
    }

    private fun initCountries() {
        viewModelScope.launch {
            _countries.value = countryRepository.getCountries()
        }
    }
}
