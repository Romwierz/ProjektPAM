package com.example.pamprojcw

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter :  RecyclerView.Adapter<HomeAdapter.ViewHolder>
{

    private lateinit var activity: Activity
    var arrayList = ArrayList<String>()



    constructor (activity:Activity, arrayList : ArrayList<String> ) {
        this.activity = activity
        this.arrayList = arrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       //initialize view
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_drawer_prototype, parent, false)

        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      //set text on textView
        holder.textView.text = arrayList[position]
        holder.textView.setOnClickListener(View.OnClickListener() {


            fun onClick (v:View){

                val position : Int = holder.adapterPosition

                when(position) {
                       0 ->
                        activity.startActivity(Intent(activity,HomeActivity::class.java )
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                        1 ->
                            activity.startActivity(Intent(activity, UserPreferencesActivity::class.java )
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                }

            }
        })
    }

    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         val textView: TextView = itemView.findViewById(R.id.text_view_item_drawer)


    }

}