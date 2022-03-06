package AllClasses

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import AllClasses.IsRightRestaurantID
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import moussa.ellakki.TableAdapter

class ViewModelID : ViewModel() {

    lateinit var database: DatabaseReference

    var tables = mutableListOf<Table>()


    var restaurant = Restaurant()

    val haveBroughAllGuests : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


    val isThereChanges : MutableLiveData<IsThereChanges> by lazy {
        MutableLiveData<IsThereChanges>()
    }

    val haveBroughtAllTables : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val isThereREstaurantID: MutableLiveData<IsRightRestaurantID> by lazy {
        MutableLiveData<IsRightRestaurantID>()
    }


    var restaurantID = ""

    init {
        database = Firebase.database.reference
    }


    fun controllid(restaurangID: String) {


        database.child("AllRestaurant").get().addOnSuccessListener {

            for (childsnap in it.children) {

                val restaurantIdInFirebase = childsnap.getValue<String>()
                if (restaurangID == restaurantIdInFirebase) {
                    isThereREstaurantID.value = IsRightRestaurantID.yes
                    return@addOnSuccessListener
                }
            }

            isThereREstaurantID.value = IsRightRestaurantID.no
        }
    }



    fun updateAllTabels(restaurantId: String) {

        tables.clear()
        database.child("Restaurant").child(restaurantId)
            .child("tables").get().addOnSuccessListener {

                for (childsnap in it.children) {
                    val table = childsnap.getValue<Table>()
                    tables.add(table!!)
                }

                haveBroughtAllTables.value = true

            }
    }



    fun getAllt(restaurantId: String){


        database.child("Restaurant").child(restaurantId).get().addOnSuccessListener {

           var  res = it.getValue<Restaurant>()!!

            this.restaurant = res


        }


    }


    fun listenToTables(){


        database.child("Restaurant").child(this.restaurantID)
            .child("tables").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    tables.clear()
                    for (table in dataSnapshot.children) {

                        var table2 = table.getValue<Table>()
                        tables.add(table2!!)


                    }

                   isThereChanges.value = IsThereChanges.yes
                }


                override fun onCancelled(error: DatabaseError) {

                }

            })


    }





}


