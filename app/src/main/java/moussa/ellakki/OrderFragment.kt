package moussa.ellakki

import AllClasses.*


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.activityViewModels

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import moussa.ellakki.databinding.FragmentOrderBinding

var guestxx = Guest()

class OrderFragment : Fragment() {

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
        binding.tableNumberIOrderFragment.text = "Yor are taking order for table " + tableNumber

        binding.orderGuidTextview.text = "Take order for guest 1"



        binding.buttonNext.setOnClickListener {

            var guest = Guest()
            guests.add(guestxx)
            guestxx = guest

            var guestnumber = guests.size + 1

            binding.orderGuidTextview.text = "Take order for guest " + guestnumber.toString()

        }

        binding.buttonSendOrder.setOnClickListener {

            var restaurant = Restaurant()

            guests.add(guestxx)

            restaurant.sendOrder(guests, tableNumber, model.restaurantID)


        }


    }






    fun showMenue() {



        var menuRecyclerView = binding.menuRecyclerView
        menuRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        menuRecyclerView.adapter = dishesAdapter
        dishesAdapter.dishes = model.dishes


        var drinkRecyclerView = binding.drinkRecyclerView
        drinkRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        drinkRecyclerView.adapter = drinkAdapter
        drinkAdapter.drinks = model.drinks


        var extraRecyclerView = binding.extraRecyclerView
        extraRecyclerView.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        extraRecyclerView.adapter = extraAdapter
        extraAdapter.extras = model.extras


    }







}