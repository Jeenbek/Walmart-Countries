package com.walmart.countries

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.walmart.countries.ui.CountryAdapter
import com.walmart.countries.ui.CountryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var countriesAdapter: CountryAdapter
    private lateinit var countriesListView: RecyclerView
    private lateinit var errorTextView: TextView
    private val countryViewModel: CountryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countriesListView = findViewById(R.id.countries_list)
        errorTextView = findViewById(R.id.error_message)
        countriesAdapter = CountryAdapter()
        countriesListView.adapter = countriesAdapter
        countryViewModel.countries.observe(this) { countriesResponse ->
            if (countriesResponse.isSuccessful && !countriesResponse.body().isNullOrEmpty()) {
                countriesAdapter.addCountries(countriesResponse.body()!!)
                countriesListView.visibility = View.VISIBLE
                errorTextView.visibility = View.INVISIBLE
            } else {
                with(errorTextView) {
                    text = getString(R.string.loadingDataFailed)
                    visibility = View.VISIBLE
                }
                countriesListView.visibility = View.INVISIBLE
            }
        }
    }
}
