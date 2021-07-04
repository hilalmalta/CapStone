package com.hm.capstone.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hm.capstone.databinding.SaleCardBinding
import com.hm.capstone.entities.Products
import com.hm.capstone.main.viewmodels.SalesViewModel
import com.squareup.picasso.Picasso

class SalesAdapter (var mContext: Context, var saleList:List<Products>, var viewModel: SalesViewModel)
    : RecyclerView.Adapter<SalesAdapter.CardViewHolder>() {

    inner class CardViewHolder(cardViewBinding: SaleCardBinding)
        : RecyclerView.ViewHolder(cardViewBinding.root){
        var cardView: SaleCardBinding = cardViewBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = SaleCardBinding.inflate(layoutInflater,parent,false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val product = saleList.get(position)

       holder.cardView.saleObject = product

        val url = product.product_image_url
        Picasso.get().load(url).into(holder.cardView.saleProductImg)


//        holder.cardView.deleteIcon.setOnClickListener {
//            viewModel.updateCart(product.product_id, 0)
//        }


    }

    override fun getItemCount(): Int {
        return saleList.size
    }
}