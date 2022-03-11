package moussa.ellakki

import AllClasses.*
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class OrderInformationFragment : Fragment() {


    var kitchenAdapter = KitchenAdapter()
    val model: ViewModelID by activityViewModels()
    var sendToFirebase = SendToFirebase()

    lateinit var table: Table


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

        var recyclerViewOrderFragment =
            view.findViewById<RecyclerView>(R.id.RV_i_orderinformationFragment)
        recyclerViewOrderFragment.layoutManager = GridLayoutManager(requireActivity(), 3)
        recyclerViewOrderFragment.adapter = kitchenAdapter

        table = requireArguments().getParcelable<Table>("table")!!
        kitchenAdapter.table = table


        view.findViewById<Button>(R.id.button_order_finished).setOnClickListener {
            controlIfAllOrderFinished(view)
        }


    }


    fun controlIfAllOrderFinished(view: View) {

        for (orders in table.tableorders) {

            if (orders.finished == false) {

                sendMsg("Whole order is dosent finished", requireActivity())
                return
            }
        }

        sendToFirebase.finishOrder(table.tableNumber, model.restaurantID)
        view.findNavController().popBackStack()

    }

    fun sendMsg(msg: String, ctx: Context) {

        val builder = AlertDialog.Builder(ctx)
        builder.setTitle("Message")
        builder.setMessage(msg)
        builder.setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->

        }

        builder.show()
    }


}