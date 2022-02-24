package AllClasses


class Dish(var name: String? = null, var pris: Double? = null) {

}

class Drink(var name: String? = null, var pris: Double? = null) {


}

class Extra(var name: String? = null, var pris: Double? = null) {

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

class Restaurant {

    var restaurantID = ""
    var tables = mutableListOf<Table>()

}


