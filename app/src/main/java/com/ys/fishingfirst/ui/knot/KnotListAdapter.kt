package com.ys.fishingfirst.ui.knot

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ys.fishingfirst.R

class KnotListAdapter(private val context: Context) : RecyclerView.Adapter<KnotListAdapter.KnotHolder>(){
    lateinit var navController : NavController

    var datas = mutableListOf<KnotData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KnotHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_knot_list_item,parent,false)


        return KnotHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: KnotHolder, position: Int) {

        val item = datas[position]
        val listener = View.OnClickListener {it ->
            setClickListner(it, item)
        }

        holder.bind(listener,datas[position])
    }

    private fun setClickListner(it: View, item: KnotData) {
        val bundle = bundleOf("param1" to item.name)//DATA를 navigate를 통해 전달한다.
        navController.navigate(R.id.knotTargetListFragment,bundle)

    }

    inner class KnotHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var view: View = view
        private val txtName: TextView = itemView.findViewById(R.id.tv_rv_name)
        private val knotImage: ImageView = itemView.findViewById(R.id.img_rv_photo)

        fun bind(listener: View.OnClickListener,item: KnotData) {
            view.setOnClickListener(listener)
            txtName.text = item.name
            Glide.with(itemView).load(item.img).into(knotImage)
        }
    }
}
