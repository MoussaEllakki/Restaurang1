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
    var dishes = mutableListOf<Dish>()
    var drinks = mutableListOf<Drink>()
    var extras = mutableListOf<Extra>()




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

    fun getAllTabel(restaurantId: String) {

        tables.clear()
        database.child("Restaurant").child(restaurantId)
            .child("Bords").get().addOnSuccessListener {

                for (childsnap in it.children) {

                    val table = childsnap.getValue<Table>()
                    tables.add(table!!)
                }

            }
    }

    fun getDishes(restaurantId: String) {
        dishes.clear()
        database.child("Restaurant").child(restaurantId).child("Dishes").get()
            .addOnSuccessListener {

                for (childsnap in it.children) {
                    val dish = childsnap.getValue<Dish>()
                    dishes.add(dish!!)
                }
            }
    }

    fun getDirinks(restaurantId: String) {

        drinks.clear()
        database.child("Restaurant").child(restaurantId)
            .child("Drinks").get().addOnSuccessListener {
                for (childsnap in it.children) {
                    val drink = childsnap.getValue<Drink>()
                    drinks.add(drink!!)
                }
            }
       }


    fun getExtra(restaurantId: String) {

        extras.clear()
        database.child("Restaurant").child(restaurantId)
            .child("Extras").get().addOnSuccessListener {

                for (childsnap in it.children) {

                    val extra = childsnap.getValue<Extra>()
                    extras.add(extra!!)
                }
            }
    }


    fun updateAllTabels(restaurantId: String) {

        tables.clear()
        database.child("Restaurant").child(restaurantId)
            .child("Bords").get().addOnSuccessListener {

                for (childsnap in it.children) {
                    val table = childsnap.getValue<Table>()
                    tables.add(table!!)
                }

                haveBroughtAllTables.value = true
            }


    }





}


