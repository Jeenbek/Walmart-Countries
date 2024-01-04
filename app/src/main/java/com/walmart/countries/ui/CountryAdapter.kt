package com.walmart.countries.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.walmart.countries.R
import com.walmart.countries.model.Country

class CountryAdapter: RecyclerView.Adapter<CountryViewHolder>() {
    private var countries: List<Country> = emptyList()

    fun addCountries(countries: List<Country>) {
        this.countries = countries
        notifyItemRangeChanged(0, countries.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(itemView)
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }
}
