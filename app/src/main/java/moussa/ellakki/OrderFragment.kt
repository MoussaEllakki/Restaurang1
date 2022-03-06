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
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import moussa.ellakki.databinding.FragmentOrderBinding


class OrderFragment : Fragment() {

    var guest = Guest()
    var sendToFirebase = SendToFirebase()
    var table = Table()
    var message = Message()

    var dishesAdapter = DishesAdapter()
    var drinkAdapter = DrinkAdapter()
    var extraAdapter = ExtraAdapter()
    var guestOrdersAdapter = GuestOrdersAdapter()

    lateinit var orderRecyclerView: RecyclerView

    var tableNumber = ""
    var guests = mutableListOf<Guest>()

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

        tableNumber = requireArguments().getString("tableNumber").toString()
        binding.buttonSendOrder.text = "send ordet for table $tableNumber"

        showMenue()
        showPrices()

        binding.buttonNext.setOnClickListener {

            if (guest.sum == 0.0) {

                message.sendMsg(
                    "You havent taken order for guest " + (guests.size + 1).toString(),
                    requireActivity()
                )
            } else {

                var removeGuest = Guest()
                guests.add(guest)
                guest.guestnumber = (guests.size).toString()
                guest = removeGuest
                table.guests.add(guest)
                showPrices()
            }
        }


        binding.buttonSendOrder.setOnClickListener {
            if (table.wholesum == 0.0) {
                message.sendMsg("There is no order", requireActivity())
            } else {

                if (guest.sum == 0.0){

                    sendMsg2(message.UserDosentOrder, view)
                }
                else {
                    guests.add(guest)
                    sendMsg2(message.sendOrderConfimation,view)
                }

            }
        }
    }


    fun showMenue() {

        table.guests.add(guest)

        var menuRecyclerView = binding.menuRecyclerView
        menuRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        menuRecyclerView.adapter = dishesAdapter
        dishesAdapter.dishes = model.restaurant.dishes
        dishesAdapter.orderFragment = this

        var drinkRecyclerView = binding.drinkRecyclerView
        drinkRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        drinkRecyclerView.adapter = drinkAdapter
        drinkAdapter.drinks = model.restaurant.drinks
        drinkAdapter.orderFragment = this

        var extraRecyclerView = binding.extraRecyclerView
        extraRecyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        extraRecyclerView.adapter = extraAdapter
        extraAdapter.extras = model.restaurant.extras
        extraAdapter.orderFragment = this

        orderRecyclerView = binding.ordersRecyclerView
        orderRecyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        orderRecyclerView.adapter = guestOrdersAdapter
    }


    fun countPrices() {
        guest.fillWholeOrder()
        table.fillTablePrice()
        showPrices()
    }

    fun showPrices() {
        var guestNumber = guests.size + 1
        var tableSum = table.wholesum.toString()
        var guestSum = guest.sum.toString()
        guestOrdersAdapter.orders = guest.orders
        guestOrdersAdapter.notifyDataSetChanged()

        binding.priceGuestTextview.text  = "Guest " + guestNumber.toString() + " whole sum : " + guestSum
        binding.priceTableTextview.text  = "Table " + tableNumber + " whole sum : " + tableSum
        binding.guestNumberTextview.text = "Guest number " + guestNumber + " Orders"
    }

    fun sendMsg2(msg: String, view: View) {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Message")
        builder.setMessage(msg)
        builder.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->

            table.filWholeOrder(guests)
            guest.guestnumber = (guests.size).toString()
            var removeGuest = Guest()
            guest = removeGuest

            table.guests = guests

            sendToFirebase.sendOrder(table , tableNumber, model.restaurantID)
            view.findNavController().popBackStack()
        }
        builder.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
        }
        builder.show()
    }

}
