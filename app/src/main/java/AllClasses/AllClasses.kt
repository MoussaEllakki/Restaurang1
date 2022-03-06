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


    fun fillWholeOrder(){
        this.sum = 0.0

        for(order in orders){
            this.sum += order.pris
        }
    }

    var guestnumber = ""

}



class Table {

    var available = true
    var wholesum = 0.0
    var tableNumber = ""
    var  orderFinished = false
    var haveOrder = false
    var guests = mutableListOf<Guest>()
    var tableorders = mutableListOf<Order>()


    fun fillTablePrice(){

        this.wholesum = 0.0
     for ( guest in guests){

         this.wholesum += guest.sum
     }

    }


    fun filWholeOrder (guests : List<Guest>){

        for (guest in guests){

            for (guestOrder in guest.orders){


                this.tableorders.add(guestOrder)

            }


        }
    }


}


class Order(){

    var namn = ""
     var pris = 0.0
     var finished = false

}

class Restaurant{

    var tables = mutableListOf<Table>()
    var dishes = mutableListOf<Dish>()
    var drinks = mutableListOf<Drink>()
    var extras = mutableListOf<Extra>()
    var restaurantID = ""

}




