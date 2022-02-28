package AllClasses

class Dish (var name : String? = "" , var pris : Double? = 0.0) {

}

class Drink (var name : String? = "" , var pris : Double? = 0.0){


}

class Extra(var name : String? = "" , var pris : Double? = 0.0){

}

class Guest {


    var orders = mutableListOf<Order>()

    var guestnumber = ""

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


class Order(var namn : String , var pris : Double){




}





