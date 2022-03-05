package AllClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moussa.ellakki.R

class KitchenAdapter : RecyclerView.Adapter<KitchenViewHolder>() {

    var  orderAdapter = OrderADapter()

  var guests = mutableListOf<Guest>()

      var table = Table()

    override fun getItemCount(): Int {
        return guests.size
    }

    override fun onBindViewHolder(holder: KitchenViewHolder, position: Int) {


        holder.recyclerView_for_orderDetalier.layoutManager = LinearLayoutManager(holder.itemView.context)

         holder.recyclerView_for_orderDetalier.adapter = orderAdapter
        holder.textView_for_orderDetalier.text =  "xx"



    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitchenViewHolder{

        val viewHolder = KitchenViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_for_all_order_recyclerview , parent, false)
        )
        return viewHolder
    }


}


class   KitchenViewHolder(view: View) : RecyclerView.ViewHolder(view) {


 var recyclerView_for_orderDetalier = view.findViewById<RecyclerView>(R.id.recyclerview_for_orderDetalier)
 var textView_for_orderDetalier = view.findViewById<TextView>(R.id.textView_for_orderDetalier)

}



class OrderADapter : RecyclerView.Adapter<OrderViewHolder>() {


    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {


        holder.order_text.text = "Lax"


        holder.itemView.setOnClickListener{


         holder.order_text.text  = "finished"

        }


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




