package com.nrp.hammersystemstesttask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nrp.hammersystemstesttask.model.Pizza
import com.nrp.hammersystemstesttask.network.FoodApi
import kotlinx.coroutines.launch

enum class FoodApiStatus { LOADING, ERROR, DONE }

class FoodViewModel: ViewModel() {

    private val _status = MutableLiveData<FoodApiStatus>()
    val status: LiveData<FoodApiStatus> = _status

    private val _foodObjects = MutableLiveData<List<Pizza>>()
    val foodObjects: LiveData<List<Pizza>> = _foodObjects

    private val _currentFood = MutableLiveData<Pizza>()
    val currentFood: LiveData<Pizza> = _currentFood

    init {
        getFood()
    }

    fun getFood() {
        viewModelScope.launch {
            _status.value = FoodApiStatus.LOADING
            try {
                _foodObjects.value = FoodApi.retrofitService.getPhotos()
                _status.value = FoodApiStatus.DONE
            } catch (e: Exception) {
                _status.value = FoodApiStatus.ERROR
                _foodObjects.value = listOf()
            }
        }
    }

    fun updateCurrentFood(food: Pizza) {
        _currentFood.value = food
    }
}