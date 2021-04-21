package com.example.contactlistapp.ui

import com.example.contactlistapp.data.db.entities.ShoppingItem


interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)

}