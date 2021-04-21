package com.example.contactlistapp.data.repositiries

import com.example.contactlistapp.data.db.ShoppingDatabase
import com.example.contactlistapp.data.db.entities.ShoppingItem


class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    suspend fun replace(item:ShoppingItem) = db.getShoppingDao().replace(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}