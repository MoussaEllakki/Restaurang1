package AllClasses

import android.app.Activity
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import moussa.ellakki.OrderFragment
import moussa.ellakki.R




class DishesAdapter : RecyclerView.Adapter<DishesViewHolder>() {


    var dishes = mutableListOf<Dish>()


    lateinit var orderFragment: OrderFragment



    override fun getItemCount(): Int {
        return dishes.size
    }

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {


        holder.foodType.text = dishes[position].name + " " + dishes[position].pris.toString()


           var order = Order(dishes[position].name!!, dishes[position].pris!!)


        holder.butonPlus.setOnClickListener{

             orderFragment.guest.orders.add(order)

          }

         holder.buttonMinus.setOnClickListener{

            orderFragment.guest.orders.remove(order)

         }




    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {

        val viewHolder = DishesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_for_menu, parent, false)
        )
        return viewHolder
    }






}

class DishesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
   // var foodprice = view.findViewById<TextView>(R.id.food_price_textview)
    var foodType = view.findViewById<Button>(R.id.food_button)
    var butonPlus = view.findViewById<Button>(R.id.button_plus)
    var buttonMinus = view.findViewById<Button>(R.id.button_minus)
}


class DrinkAdapter : RecyclerView.Adapter<DrinksViewHolder>() {

    lateinit var orderFragment: OrderFragment

    var drinks = mutableListOf<Drink>()

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {

        holder.foodType.text = drinks[position].name + " " + drinks[position].pris.toString()

        var order = Order(drinks[position].name!!, drinks[position].pris!!)

        holder.butonPlus.setOnClickListener{

            orderFragment.guest.orders.add(order)

        }

        holder.buttonMinus.setOnClickListener{

            orderFragment.guest.orders.remove(order)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val viewHolder = DrinksViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_for_menu, parent, false)
        )
        return viewHolder
    }
}

class DrinksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
   // var foodprice = view.findViewById<TextView>(R.id.food_price_textview)
    var foodType = view.findViewById<Button>(R.id.food_button)
    var butonPlus = view.findViewById<Button>(R.id.button_plus)
    var buttonMinus = view.findViewById<Button>(R.id.button_minus)

}


class ExtraAdapter : RecyclerView.Adapter<ExtraViewHolder>() {

    var extras = mutableListOf<Extra>()
    lateinit var orderFragment: OrderFragment

    override fun getItemCount(): Int {
        return extras.size
    }

    override fun onBindViewHolder(holder: ExtraViewHolder, position: Int) {

        holder.foodType.text = extras[position].name + " " +extras[position].pris.toString()

        var order = Order(extras[position].name!!, extras[position].pris!!)

        holder.butonPlus.setOnClickListener{

            orderFragment.guest.orders.add(order)

        }

        holder.buttonMinus.setOnClickListener{

            orderFragment.guest.orders.remove(order)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtraViewHolder {
        val viewHolder = ExtraViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_for_menu, parent, false)
        )
        return viewHolder
    }
}

class ExtraViewHolder(view: View) : RecyclerView.ViewHolder(view) {

  //  var foodprice = view.findViewById<TextView>(R.id.food_price_textview)
    var foodType = view.findViewById<Button>(R.id.food_button)
    var butonPlus = view.findViewById<Button>(R.id.button_plus)
    var buttonMinus = view.findViewById<Button>(R.id.button_minus)



}








