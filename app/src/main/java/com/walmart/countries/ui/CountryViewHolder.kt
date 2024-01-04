package com.walmart.countries.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.walmart.countries.R
import com.walmart.countries.model.Country

class CountryViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val name = view.findViewById<TextView>(R.id.name)
    private val region = view.findViewById<TextView>(R.id.region)
    private val code = view.findViewById<TextView>(R.id.code)
    private val capital = view.findViewById<TextView>(R.id.capital)

    fun bind(country: Country) {
        name.text = view.resources.getString(R.string.country_name, country.name)
        region.text = country.region
        code.text = country.code
        capital.text = country.capital
    }
}
