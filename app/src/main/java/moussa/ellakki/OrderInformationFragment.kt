package moussa.ellakki

import AllClasses.DosentFinishedAdapter
import AllClasses.KitchenAdapter
import AllClasses.Table
import AllClasses.ViewModelID
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class OrderInformationFragment : Fragment() {


    var kitchenAdapter = KitchenAdapter()



    val model: ViewModelID by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_information, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)






        var recyclerViewOrderFragment = view.findViewById<RecyclerView>(R.id.RV_i_orderinformationFragment)

        recyclerViewOrderFragment.layoutManager = GridLayoutManager(requireActivity(), 3)

        recyclerViewOrderFragment.adapter = kitchenAdapter




        kitchenAdapter.test = model.test




    }









}