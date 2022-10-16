package com.nrp.hammersystemstesttask.data

import com.nrp.hammersystemstesttask.R

class Datasource() {

    fun loadCategories(): List<Int> {
        return listOf<Int>(
            R.string.category1,
            R.string.category2,
            R.string.category3,
            R.string.category4,
            R.string.category5,
            R.string.category6,
            R.string.category7)
    }
}