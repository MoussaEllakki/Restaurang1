package moussa.ellakki

import AllClasses.DishesAdapter
import AllClasses.DrinkAdapter
import AllClasses.ExtraAdapter
import AllClasses.ViewModelID


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.activityViewModels

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import moussa.ellakki.databinding.FragmentOrderBinding


class OrderFragment : Fragment() {

    var dishesAdapter = DishesAdapter()
    var drinkAdapter = DrinkAdapter()
    var extraAdapter = ExtraAdapter()

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

        var menuRecyclerView = view.findViewById<RecyclerView>(R.id.menu_recyclerView)
        menuRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        menuRecyclerView.adapter = dishesAdapter
        dishesAdapter.dishes = model.dishes

        var drinkRecyclerView = view.findViewById<RecyclerView>(R.id.drink_recyclerView)
        drinkRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        drinkRecyclerView.adapter = drinkAdapter
        drinkAdapter.drinks = model.drinks

        var extraRecyclerView = view.findViewById<RecyclerView>(R.id.extra_recyclerView)
        extraRecyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        extraRecyclerView.adapter = extraAdapter
        extraAdapter.extras = model.extras
    }

}