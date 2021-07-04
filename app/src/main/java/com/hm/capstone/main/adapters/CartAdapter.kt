package com.hm.capstone.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hm.capstone.databinding.CartCardBinding
import com.hm.capstone.entities.Products
import com.hm.capstone.main.viewmodels.CartViewModel
import com.squareup.picasso.Picasso

class CartAdapter (var mContext: Context, var cartList:List<Products>, var viewModel: CartViewModel)
    : RecyclerView.Adapter<CartAdapter.CardViewHolder>() {

    inner class CardViewHolder(cardViewBinding: CartCardBinding)
        : RecyclerView.ViewHolder(cardViewBinding.root){
        var cardView: CartCardBinding = cardViewBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = CartCardBinding.inflate(layoutInflater,parent,false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val product = cartList.get(position)

        holder.cardView.cartObject = product

        val url = product.product_image_url
        Picasso.get().load(url).into(holder.cardView.cartImg)


        holder.cardView.deleteIcon.setOnClickListener {
            viewModel.updateCart(product.product_id, 0)
            Toast.makeText(mContext, "Ürün Sepeten Çıkarıldı!", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}