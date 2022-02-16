package moussa.ellakki

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelID : ViewModel() {

    val restaurantId : MutableLiveData<String> by lazy {

       MutableLiveData<String>()
    }



}