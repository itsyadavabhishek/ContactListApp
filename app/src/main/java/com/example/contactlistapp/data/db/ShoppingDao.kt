package com.example.contactlistapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contactlistapp.data.db.entities.ShoppingItem


@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Update
    suspend fun replace(item: ShoppingItem)



    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>


}