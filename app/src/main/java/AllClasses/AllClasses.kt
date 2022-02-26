package AllClasses

class Dish (var name : String? = "" , var pris : Double? = 0.0) {

}

class Drink (var name : String? = "" , var pris : Double? = 0.0){


}

class Extra(var name : String? = "" , var pris : Double? = 0.0){

}

class Guest {

    var guestnumber = ""
    var guestsum = 0.0
    var guestorder = ""

}

class Table {

    var available = true
    var Wholeorder = ""
    var wholesum = 0.0

    var guests = mutableListOf<Guest>()


    fun fillOrder (guest : Guest){

      guests.add(guest)

    }






}


class Order(){




  companion object{

      var guests = mutableListOf<Guest>()

      var guest = Guest()


      fun fillOrder(order : String){

        guest.guestorder += order

      }


      fun sendOrder(){

          this.guests.add(this.guest)

         this.guest.guestorder = ""
      }



  }




}





