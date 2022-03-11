package AllClasses

import android.graphics.Color
import android.graphics.Color.red
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import moussa.ellakki.R

class KitchenAdapter : RecyclerView.Adapter<KitchenViewHolder>() {


      var table = Table()



    override fun getItemCount(): Int {
        return table.tableorders.size
    }

    override fun onBindViewHolder(holder: KitchenViewHolder, position: Int) {

        holder.orderView.text = table.tableorders[position].name

        holder.itemView.setOnClickListener{


            if (table.tableorders[position].finished == false){

                table.tableorders[position].finished = true
                holder.orderView.setBackgroundColor(Color.GREEN)

            }
            else{
                holder.orderView.setBackgroundColor(Color.RED)

                table.tableorders[position].finished = false
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitchenViewHolder{

        val viewHolder = KitchenViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_for_order_i_orderinformation_fragment, parent, false)
        )
        return viewHolder
    }
}


class   KitchenViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var orderView = view.findViewById<TextView>(R.id.view_for_order_i_orderInformation)



}





