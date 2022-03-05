

package AllClasses

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

class Message {


    var tableBusy = "this Table is not availble if you want to use it press yes , but you gonna remove whole its order" +
            "otherwise press no to take another one"

    var UserDosentOrder = "This guest Doesnt order, do you want to send order anyway?"

    var sendOrderConfimation = "Are you sure you want to send order?"

    fun sendMsg(msg : String , act : Activity){
        val builder = AlertDialog.Builder(act)
        builder.setTitle("Message")
        builder.setMessage(msg)
        builder.setPositiveButton("OK", { dialogInterface: DialogInterface, i: Int -> })
        builder.show()
    }




}


