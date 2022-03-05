package AllClasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import moussa.ellakki.OrderFragment
import moussa.ellakki.R


class FinishedAdapter : RecyclerView.Adapter<FinishedViewHolder>() {


    var  finishedOrder = mutableListOf<Table>()



    override fun getItemCount(): Int {
        return finishedOrder.size
    }

    override fun onBindViewHolder(holder: FinishedViewHolder, position: Int) {


        holder.table_number.text = finishedOrder[position].tableNumber
        holder.table_image.setImageResource(R.drawable.tablegreen)




    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinishedViewHolder {

        val viewHolder = FinishedViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.table_layout , parent, false)
        )
        return viewHolder
    }


}


class  FinishedViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    val table_number = view.findViewById<TextView>(R.id.table_number_textview)
    val table_image = view.findViewById<ImageView>(R.id.table_image)




}



class DosentFinishedAdapter : RecyclerView.Adapter<DosentFinishedViewHolder>() {


    var  DosentfinishedOrder = mutableListOf<Table>()
    var bundle = Bundle()

    override fun getItemCount(): Int {
        return DosentfinishedOrder.size
    }

    override fun onBindViewHolder(holder: DosentFinishedViewHolder, position: Int) {



        holder.table_number.text = DosentfinishedOrder[position].tableNumber
        holder.table_image.setImageResource(R.drawable.tablegreen)


        holder.itemView.setOnClickListener{



            bundle.putString("tableNumber",  DosentfinishedOrder[position].tableNumber)

            holder.itemView.findNavController()
                .navigate(R.id.action_kitchenFragment_to_orderInformationFragment)


        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DosentFinishedViewHolder {

        val viewHolder = DosentFinishedViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.table_layout , parent, false)
        )
        return viewHolder
    }





}



class  DosentFinishedViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    val table_number = view.findViewById<TextView>(R.id.table_number_textview)
    val table_image = view.findViewById<ImageView>(R.id.table_image)

}
