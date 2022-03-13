package AllClasses

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import moussa.ellakki.R





class AdapterInfoToGetPaid  : RecyclerView.Adapter<GetPaidInfoViewHolder>() {


        var guests = mutableListOf<Guest>()


      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):GetPaidInfoViewHolder{
            val vh = GetPaidInfoViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.view_getpaidinfo, parent, false)
            )
            return vh
        }


        override fun getItemCount(): Int {
            return  guests.size
        }


        override fun onBindViewHolder(holder:GetPaidInfoViewHolder, position: Int) {


             holder.guestprice.text = "Guest "+ guests[position].guestnumber + " Price: "+ guests[position].sum
             holder.guestInfodetails.text = guests[position].wholeOrder


        }







    }

    class GetPaidInfoViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {


        val guestprice = view.findViewById<TextView>(R.id.infoTextView_getPaidInfo)
        val guestInfodetails = view.findViewById<TextView>(R.id.info_detail_getPaidInfo)

    }






