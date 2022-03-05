package AllClasses

class Dish (var name : String? = "" , var pris : Double? = 0.0) {

}

class Drink (var name : String? = "" , var pris : Double? = 0.0){


}

class Extra(var name : String? = "" , var pris : Double? = 0.0){

}

class Guest {

    var sum = 0.0
    var orders = mutableListOf<Order>()
    var wholeOrder = ""

    fun fillWholeOrder(){
        this.sum = 0.0
        this.wholeOrder = ""
        for(order in orders){
            this.sum += order.pris

            this.wholeOrder += order.namn + " - "
        }
    }

    var guestnumber = ""

}



class Table {

    var available = true
    var Wholeorder = ""
    var wholesum = 0.0
    var tableNumber = ""
    var  orderFinished = false
    var haveOrder = false
    var guests = mutableListOf<Guest>()



    fun fillTablePrice(){

        this.wholesum = 0.0
     for ( guest in guests){

         this.wholesum += guest.sum
     }

    }
    fun filWholeOrder (guest : List<Guest>){

        for (guest in guests){

            for (guestOrder in guest.orders){


                this.Wholeorder += guestOrder.namn + " "
            }


        }
    }
}


class Order(var namn : String , var pris : Double){


}






