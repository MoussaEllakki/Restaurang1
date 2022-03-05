package AllClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moussa.ellakki.R

class KitchenAdapter : RecyclerView.Adapter<KitchenViewHolder>() {



 var adapterx = OrderADapter()

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: KitchenViewHolder, position: Int) {


        holder.rv.layoutManager = LinearLayoutManager(holder.itemView.context)

        holder.rv.adapter = adapterx


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitchenViewHolder{

        val viewHolder = KitchenViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_for_all_order_recyclerview , parent, false)
        )
        return viewHolder
    }


}


class   KitchenViewHolder(view: View) : RecyclerView.ViewHolder(view) {


 var rv = view.findViewById<RecyclerView>(R.id.RV)


}



class OrderADapter : RecyclerView.Adapter<OrderViewHolder>() {


    override fun getItemCount(): Int {
        return 22
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {


        holder.order_text.text = "xxxxxxx"

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {

        val viewHolder = OrderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_for_order_i_order_recyclerview, parent, false)
        )
        return viewHolder
    }





}



class  OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var order_text = view.findViewById<TextView>(R.id.order_textview_i_order_recyclerview)

}




