package AllClasses

import androidx.fragment.app.activityViewModels
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SendToFirebase {




    lateinit  var database : DatabaseReference

    init {
        database = Firebase.database.reference
    }


    fun bookTable(tableNumber : String , restaurantId: String){
        database.child("Restaurant").child(restaurantId)
            .child("tables").child(tableNumber).child("available").setValue(false)

    }


    fun removeBooking(tableNumber : String , restaurantId: String){
        var table = Table()

        database.child("Restaurant").child(restaurantId)
            .child("tables").child(tableNumber).setValue(table)

     /////////
    }


    fun sendOrder( table : Table , tableNumber: String , restaurantId: String){

        var tableNr = tableNumber.toInt() - 1
        var tableNumberToString = tableNr.toString()

        database.child("Restaurant").child(restaurantId).child("tables").child(tableNumberToString).
        child("wholesum").setValue(table.wholesum)

        database.child("Restaurant").child(restaurantId).child("tables").child(tableNumberToString).
        child("tableNumber").setValue(tableNumber)

        database.child("Restaurant").child(restaurantId).child("tables").child(tableNumberToString).
        child("haveOrder").setValue(true)

        database.child("Restaurant").child(restaurantId).child("tables")
            .child(tableNumberToString).child("guests").setValue(table.guests)


        database.child("Restaurant").child(restaurantId).child("tables").child(tableNumberToString)
        .child("tableorders").setValue(table.tableorders)





    }






}