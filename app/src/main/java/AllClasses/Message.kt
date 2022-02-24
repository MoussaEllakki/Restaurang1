

package AllClasses

import android.app.Activity
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog



class Message {


    fun sendMsg(msg : String , act : Activity){


        val builder = AlertDialog.Builder(act)
        builder.setTitle("Message")
        builder.setMessage(msg)
        builder.setPositiveButton("OK", { dialogInterface: DialogInterface, i: Int ->
        })
        builder.show()
    }



}


