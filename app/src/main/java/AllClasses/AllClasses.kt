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

}



