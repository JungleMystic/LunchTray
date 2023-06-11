package com.lrm.lunchtray.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.lrm.lunchtray.data.DataSource

class OrderViewModel: ViewModel() {

    val menuItems = DataSource.menuItems

    // Default values for item prices
    private var previousMCPrice = 0
    private var previousSDPrice = 0
    private var previousSnackPrice = 0

    // Default tax rate
    private val taxRate = 0.10

    private val _mainCourse = MutableLiveData<MenuItem?>()
    val mainCourse: LiveData<MenuItem?> = _mainCourse

    private val _sideDish = MutableLiveData<MenuItem?>()
    val sideDish: LiveData<MenuItem?> = _sideDish

    private val _snacks = MutableLiveData<MenuItem?>()
    val snacks: LiveData<MenuItem?> = _snacks

    private val _subtotal = MutableLiveData(0)
    val subtotal: LiveData<Int> = _subtotal

    private val _tax = MutableLiveData(0.0)
    val tax: LiveData<String> = _tax.map { _tax.value.toString() }

    private val _total = MutableLiveData(0.0)
    val total: LiveData<String> = _total.map { _total.value.toString() }

    fun setMainCourse(mainCourse: String) {
        if (_mainCourse.value != null){
            previousMCPrice = _mainCourse.value!!.price
        }

        if (_subtotal.value != null) {
            _subtotal.value = (_subtotal.value)?.minus(previousMCPrice)
        }

        _mainCourse.value = menuItems[mainCourse]

        updateSubtotal(_mainCourse.value!!.price)
    }

    fun setSideDish(sideDish: String) {
        if (_sideDish.value != null) {
            previousSDPrice = _sideDish.value!!.price
        }

        if (_subtotal.value != null) {
            _subtotal.value = (_subtotal.value)?.minus(previousSDPrice)
        }

        _sideDish.value = menuItems[sideDish]

        updateSubtotal(_sideDish.value!!.price)
    }

    fun setSnack(snack: String) {
        if (_snacks.value != null) {
            previousSnackPrice = _snacks.value!!.price
        }

        if (_snacks.value != null) {
            _subtotal.value = (_subtotal.value)?.minus(previousSnackPrice)
        }

        _snacks.value = menuItems[snack]

        updateSubtotal(_snacks.value!!.price)
    }

    private fun updateSubtotal(itemPrice: Int) {
        if (_subtotal.value != null) {
            _subtotal.value = (_subtotal.value)?.plus(itemPrice)
        } else {
            _subtotal.value = itemPrice
        }

        calculateTaxAndTotal()
    }

    fun calculateTaxAndTotal(){
        _tax.value = (_subtotal.value)?.times(taxRate)

        _total.value = (_subtotal.value)?.plus(_tax.value!!)
    }

    fun resetOrder() {
        previousMCPrice = 0
        previousSDPrice = 0
        previousSnackPrice = 0

        _mainCourse.value = null
        _sideDish.value = null
        _snacks.value = null

        _subtotal.value = 0
        _tax.value = 0.0
        _total.value = 0.0
    }
}