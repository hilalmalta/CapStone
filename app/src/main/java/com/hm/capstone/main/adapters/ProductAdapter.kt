package com.hm.capstone.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hm.capstone.databinding.ProductCardBinding
import com.hm.capstone.entities.Products
import com.hm.capstone.main.fragments.ProductsFragmentDirections
import com.hm.capstone.main.viewmodels.ProductsViewModel
import com.squareup.picasso.Picasso

class ProductAdapter (var mContext: Context, var productList:List<Products>, var viewModel: ProductsViewModel)
    : RecyclerView.Adapter<ProductAdapter.CardViewHolder>() {

    inner class CardViewHolder(cardViewBinding: ProductCardBinding)
        : RecyclerView.ViewHolder(cardViewBinding.root){
        var cardView:ProductCardBinding = cardViewBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = ProductCardBinding.inflate(layoutInflater,parent,false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val product = productList.get(position)

        holder.cardView.productObject = product

        holder.cardView.cardView.setOnClickListener {
            val gecis = ProductsFragmentDirections.actionProductsFragmentToDetailFragment(product)
            Navigation.findNavController(it).navigate(gecis)
        }

        holder.cardView.addToCartButton.setOnClickListener {
            viewModel.updateCart(product.product_id, 1)
            Toast.makeText(mContext, "Sepete Eklendi!", Toast.LENGTH_SHORT).show()
        }


        val url = product.product_image_url
        Picasso.get().load(url).into(holder.cardView.productImg)

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}