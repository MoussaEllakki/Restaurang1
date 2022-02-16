package moussa.ellakki

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import moussa.ellakki.databinding.FragmentSignInBinding
import moussa.ellakki.databinding.FragmentTablesBinding


class TablesFragment : Fragment() {

    lateinit var binding: FragmentTablesBinding
    val model: ViewModelID by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTablesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val restaurangIdObserver = Observer<String> {
            binding.restaurantIDTextview.text = model.restaurantId.value
        }

        model.restaurantId.observe(requireActivity(), restaurangIdObserver)
    }


}