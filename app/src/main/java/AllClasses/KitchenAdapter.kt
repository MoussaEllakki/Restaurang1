package AllClasses

import android.graphics.Color
import android.graphics.Color.red
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moussa.ellakki.OrderInformationFragment
import moussa.ellakki.R

class KitchenAdapter : RecyclerView.Adapter<KitchenViewHolder>() {

   lateinit var table  : Table


    override fun getItemCount(): Int {
        return table.guests.size
    }

    override fun onBindViewHolder(holder: KitchenViewHolder, position: Int) {

         var guestOrderIKitchen = GuestOrderIKitchen()
        var recyclerView_for_order_i_kitchen = holder.itemView.findViewById<RecyclerView>(R.id.RV_order)
        recyclerView_for_order_i_kitchen.layoutManager = LinearLayoutManager(holder.itemView.context)
        recyclerView_for_order_i_kitchen.adapter = guestOrderIKitchen
         guestOrderIKitchen.guest = table.guests[position]
        holder.orderView.text = "Guest " + table.guests[position].guestnumber

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitchenViewHolder {

        val viewHolder = KitchenViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_view, parent, false)
        )
        return viewHolder
    }
}


class KitchenViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var orderView = view.findViewById<TextView>(R.id.textView_i_recyclerVieworder)


}


class GuestOrderIKitchen : RecyclerView.Adapter<OrderViewHolder>() {


      var guest =  Guest()

    override fun getItemCount(): Int {
        return guest.orders.size
    }



    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {



        holder.orderView.text = guest.orders[position].name


        holder.itemView.setOnClickListener {

            if (guest.orders[position].finished == false) {

                holder.orderView.text = guest.guestnumber +"F " + position .toString()
                guest.orders[position].finished = true
                holder.orderView.setBackgroundColor(Color.GREEN)



            } else {
                holder.orderView.text = guest.guestnumber +" D " +position .toString()
                guest.orders[position].finished = false
                holder.orderView.setBackgroundColor(Color.RED)

            }






        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {

        val viewHolder = OrderViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_for_order_i_orderinformation_fragment, parent, false)
        )
        return viewHolder
    }
}


class OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var orderView = view.findViewById<TextView>(R.id.view_for_order_i_orderInformation)


}





