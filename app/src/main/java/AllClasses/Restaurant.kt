package AllClasses

import androidx.fragment.app.activityViewModels
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Restaurant {


    var tables = mutableListOf<Table>()

    lateinit  var database : DatabaseReference

    init {
        database = Firebase.database.reference
    }

    fun bookTable(tableNumber : String , restaurantId: String){
        database.child("Restaurant").child(restaurantId)
            .child("Bords").child(tableNumber).child("available").setValue(false)

    }


    fun removeBooking(tableNumber : String , restaurantId: String){
        database.child("Restaurant").child(restaurantId)
            .child("Bords").child(tableNumber).child("available").setValue(true)

        var guests = mutableListOf<Guest>()
        database.child("Restaurant").child(restaurantId).child("Bords")
            .child(tableNumber).child("Guests").setValue(guests)

        database.child("Restaurant").child(restaurantId).child("Bords").child(tableNumber).
        child("wholeOrder").setValue("")

        database.child("Restaurant").child(restaurantId).child("Bords").child(tableNumber).
        child("wholesum").setValue(0.0)


        database.child("Restaurant").child(restaurantId).child("Bords").child(tableNumber).
        child("haveOrder").setValue(false)
    }


    fun sendOrder( table : Table ,guests: List<Guest> , tableNumber: String , restaurantId: String){

        var tableNr = tableNumber.toInt() - 1
        var tableNumberToString = tableNr.toString()

        database.child("Restaurant").child(restaurantId).child("Bords").child(tableNumberToString).
        child("wholesum").setValue(table.wholesum)

        database.child("Restaurant").child(restaurantId).child("Bords").child(tableNumberToString).
        child("tableNumber").setValue(tableNumber)

        database.child("Restaurant").child(restaurantId).child("Bords").child(tableNumberToString).
        child("haveOrder").setValue(true)

        database.child("Restaurant").child(restaurantId).child("Bords")
            .child(tableNumberToString).child("Guests").setValue(guests)



    }






}