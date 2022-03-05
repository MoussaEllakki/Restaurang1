package moussa.ellakki

import AllClasses.KitchenAdapter
import AllClasses.OrderADapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moussa.ellakki.databinding.FragmentOrderInformationBinding
import moussa.ellakki.databinding.FragmentSignInBinding


class OrderInformationFragment : Fragment() {

    lateinit var binding: FragmentOrderInformationBinding

    var kitchenAdapter = KitchenAdapter()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOrderInformationBinding.inflate(inflater, container, false)

      return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

             var kitchen_recyclerView = binding.allOrderrecyclerView
              kitchen_recyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, true)
               kitchen_recyclerView.adapter = kitchenAdapter





    }







}