package AllClasses

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import AllClasses.IsRightRestaurantID

class ViewModelID : ViewModel() {

    lateinit var database: DatabaseReference

    var tables = mutableListOf<Table>()
    var dishes = mutableListOf<Dish>()
    var drinks = mutableListOf<Drink>()
    var extras = mutableListOf<Extra>()

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

        database.child("Restaurant").child(restaurantId)
            .child("Bords").get().addOnSuccessListener {

                for (childsnap in it.children) {

                    val table = childsnap.getValue<Table>()
                    tables.add(table!!)
                }
            }
    }


    fun getDishes(restaurantId: String) {
        database.child("Restaurant").child(restaurantId)
            .child("Dishes").get().addOnSuccessListener {

                for (childsnap in it.children) {

                    val dish = childsnap.getValue<Dish>()
                    dishes.add(dish!!)
                }
            }
    }

    fun getDirinks(restaurantId: String) {

        database.child("Restaurant").child(restaurantId)
            .child("Drinks").get().addOnSuccessListener {
                for (childsnap in it.children) {
                    val drink = childsnap.getValue<Drink>()
                    drinks.add(drink!!)
                }
            }
    }


    fun getExtra(restaurantId: String) {

        database.child("Restaurant").child(restaurantId)
            .child("Extras").get().addOnSuccessListener {

                for (childsnap in it.children) {

                    val extra = childsnap.getValue<Extra>()
                    extras.add(extra!!)
                }
            }
    }


}


