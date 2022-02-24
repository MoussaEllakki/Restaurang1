package moussa.ellakki

import AllClasses.Table
import AllClasses.ViewModelID
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class TableAdapter : RecyclerView.Adapter<TableViewHolder>() {

    var tables = mutableListOf<Table>()
    var bundle = Bundle()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val vh = TableViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.table_layout, parent, false)
        )
        return vh
    }


    override fun getItemCount(): Int {
        return tables.size
    }


    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {

        val number = position + 1
        val numberToString = number.toString()

        holder.table_number.text = numberToString
        holder.table_image.setImageResource(R.drawable.tablegreen)

        holder.itemView.setOnClickListener {



            bundle.putString("tableNumber", numberToString)
            holder.itemView.findNavController()
                .navigate(R.id.action_tablesFragment_to_orderFragment, bundle)
        }
    }

}

class TableViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {

    val table_number = view.findViewById<TextView>(R.id.table_number_textview)
    val table_image = view.findViewById<ImageView>(R.id.table_image)

}


