package moussa.ellakki

import AllClasses.Message
import AllClasses.Restaurant
import AllClasses.Table
import AllClasses.ViewModelID
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class TableAdapter : RecyclerView.Adapter<TableViewHolder>() {

    var tables = mutableListOf<Table>()
    var bundle = Bundle()
    var restaurant = Restaurant()
    var message = Message()
    lateinit var model: ViewModelID


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

        bookAndCancelTable(holder, position)

    }


    fun bookAndCancelTable(holder: TableViewHolder, position: Int) {

        val number = position + 1
        val numberToString = number.toString()
        holder.table_number.text = numberToString

        if (tables[position].available == true) {

            holder.table_image.setImageResource(R.drawable.tablegreen)

            holder.itemView.setOnClickListener {

                restaurant.bookTable(position.toString(), model.restaurantID)

                bundle.putString("tableNumber", numberToString)
                model.updateAllTabels(model.restaurantID)

                holder.itemView.findNavController()
                    .navigate(R.id.action_tablesFragment_to_orderFragment, bundle)
            }

        } else {

            holder.table_image.setImageResource(R.drawable.tablered)

            holder.itemView.setOnClickListener {

                sendMsg(message.tableBusy, holder.itemView.context, position.toString())
            }

        }

    }

    fun sendMsg(msg: String, ctx: Context, tableNumber: String) {

        val builder = AlertDialog.Builder(ctx)
        builder.setTitle("Message")
        builder.setMessage(msg)
        builder.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->

            restaurant.removeBooking( tableNumber, model.restaurantID)

            model.updateAllTabels(model.restaurantID)
        }
        builder.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->

        }
        builder.show()
    }



}

class TableViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {

    val table_number = view.findViewById<TextView>(R.id.table_number_textview)
    val table_image = view.findViewById<ImageView>(R.id.table_image)

}


