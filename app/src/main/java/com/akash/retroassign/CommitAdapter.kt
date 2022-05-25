package com.akash.retroassign

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akash.retroassign.DataClass.Commits

class CommitAdapter(context : Context, val commits:List<Commits>) : RecyclerView.Adapter<CommitAdapter.myViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view  = inflater.inflate(R.layout.item_view,parent,false)

        return myViewHolder(view)
    }
    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.txt1.text =commits.get(position).author.login
        holder.txt2.text =commits.get(position).sha.subSequence(0,9)
        holder.txt3.text =commits.get(position).commit.message.take(50)
        holder.itemView.setOnClickListener(){
            val intent = Intent(holder.itemView.context,DetailPage::class.java)
                intent.putExtra("sha",commits.get(position).sha)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
     return commits.size
    }
    class myViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var txt1 = itemView.findViewById<TextView>(R.id.tv1)
        var txt2 = itemView.findViewById<TextView>(R.id.tv2)
        var txt3 = itemView.findViewById<TextView>(R.id.tv3)
    }


}

