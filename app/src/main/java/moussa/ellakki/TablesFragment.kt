package moussa.ellakki

import AllClasses.IsRightRestaurantID
import AllClasses.ViewModelID
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.database.DatabaseReference
import moussa.ellakki.databinding.FragmentTablesBinding

class TablesFragment : Fragment() {

    lateinit var binding: FragmentTablesBinding
    val model: ViewModelID by activityViewModels()
    val tableAdapter = TableAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTablesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

          openView()

        val haveBroughtAllt = Observer<Boolean> {
            if (it == true) {
                tableAdapter.tables = model.tables
                tableAdapter.notifyDataSetChanged()
            }
        }
        model.haveBroughtAllTables.observe(viewLifecycleOwner, haveBroughtAllt)
    }



    fun openView(){

        var tableRecyclerView = binding.recyclerViewForTables
        tableRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 3)
        tableRecyclerView.adapter = tableAdapter
        tableAdapter.model = model
        tableAdapter.tables = model.restaurant.tables

    }

}