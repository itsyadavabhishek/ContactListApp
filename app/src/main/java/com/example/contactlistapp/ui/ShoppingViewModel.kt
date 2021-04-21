package com.example.contactlistapp.ui

import androidx.lifecycle.ViewModel
import com.example.contactlistapp.data.db.entities.ShoppingItem
import com.example.contactlistapp.data.repositiries.ShoppingRepository

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun upsert(item: ShoppingItem) =
        GlobalScope.launch {
            repository.upsert(item)
        }
    fun update(item: ShoppingItem)=
        GlobalScope.launch {
            repository.replace(item)
        }

    fun delete(item: ShoppingItem) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()

}