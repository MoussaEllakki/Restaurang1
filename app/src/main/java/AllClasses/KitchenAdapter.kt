package AllClasses

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

    var test = ""
    var model =  ViewModelID ()

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: KitchenViewHolder, position: Int) {

        holder.orderView.text = model.test


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitchenViewHolder{

        val viewHolder = KitchenViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_for_orders_in_kitchen, parent, false)
        )
        return viewHolder
    }


}


class   KitchenViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    var orderView = view.findViewById<TextView>(R.id.order_textview)


}





