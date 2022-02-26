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
    }



    fun sendOrderToKitchen(table: Table , tableNumber: String , restaurantId: String){





    }




}