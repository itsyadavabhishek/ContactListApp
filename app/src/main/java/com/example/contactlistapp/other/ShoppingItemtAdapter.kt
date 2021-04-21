package com.example.contactlistapp.other

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistapp.R
import com.example.contactlistapp.data.db.entities.ShoppingItem
import com.example.contactlistapp.ui.AddDialogListener
import com.example.contactlistapp.ui.AddShoppingItemDialog
import com.example.contactlistapp.ui.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemtAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemtAdapter.ShoppingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]


        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"

        holder.itemView.ivfav.isChecked = curShoppingItem.checked



        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        val context: Context = holder.itemView.tvName.context



        holder.itemView.ivEdit.setOnClickListener {
            AddShoppingItemDialog(
                context,
                object : AddDialogListener {
                    override fun onAddButtonClicked(curShoppingItem: ShoppingItem) {
                        holder.itemView.tvName.text = curShoppingItem.name
                        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"
                        holder.itemView.ivfav.isChecked = curShoppingItem.checked

                        viewModel.update(curShoppingItem)
                    }
                }).show()


        }


    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}