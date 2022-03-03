package moussa.ellakki

import AllClasses.*
import android.content.Context
import android.content.DialogInterface


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import moussa.ellakki.databinding.FragmentOrderBinding



class OrderFragment : Fragment() {

    var guest =  Guest()
    var restaurant = Restaurant()
    var table = Table()
    var message = Message()

     var wholeOrder = ""
     var pricePerGuest = 0.0
     var priceWholeTable = 0.0

    lateinit var database : DatabaseReference

      var dishesAdapter = DishesAdapter()
      var drinkAdapter = DrinkAdapter()
      var extraAdapter = ExtraAdapter()

    var tableNumber = ""

    var guests  = mutableListOf<Guest>()

    lateinit var binding: FragmentOrderBinding
    val model: ViewModelID by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        showMenue()
        tableNumber = requireArguments().getString("tableNumber").toString()


        binding.buttonSendOrder.text = "send ordet for table $tableNumber"




        binding.priceGuestTextview.text = "Guest 1 price is:   0.0"
        binding.priceTableTextview.text = "Table " + tableNumber +  "price is: 0.0"

        binding.buttonNext.setOnClickListener {
            var removeGuest = Guest()


            guests.add(guest)
            guest.guestnumber = (guests.size).toString()
            guest = removeGuest


        }



        binding.buttonSendOrder.setOnClickListener {


          if (priceWholeTable == 0.0){

             message.sendMsg("There is no order", requireActivity())


          }

            else{

                sendMsg2("Are you sure you have taken whole order?", view)
            }
        }
    }




    fun showMenue() {



        var menuRecyclerView = binding.menuRecyclerView
        menuRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        menuRecyclerView.adapter = dishesAdapter
        dishesAdapter.dishes = model.dishes
       dishesAdapter.orderFragment = this

        var drinkRecyclerView = binding.drinkRecyclerView
        drinkRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        drinkRecyclerView.adapter = drinkAdapter
        drinkAdapter.drinks = model.drinks
        drinkAdapter.orderFragment = this

        var extraRecyclerView = binding.extraRecyclerView
        extraRecyclerView.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        extraRecyclerView.adapter = extraAdapter
        extraAdapter.extras = model.extras
        extraAdapter.orderFragment = this

    }


    fun sendMsg2(msg: String , view : View) {

        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Message")
        builder.setMessage(msg)
        builder.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->

            guests.add(guest)
            guest.guestnumber = (guests.size ).toString()
            var removeGuest = Guest()
            guest = removeGuest
            restaurant.sendOrder(guests, tableNumber, model.restaurantID)
            view.findNavController().popBackStack()


        }
        builder.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->

        }
        builder.show()
    }



     fun showOrderPrice(){
         binding.priceGuestTextview.text = guest.sum.toString()
         binding.priceTableTextview.text = table.wholesum.toString()

     }






}