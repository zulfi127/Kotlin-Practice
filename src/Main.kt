
// top-level variables
/*val name: String = "James"
var greeting: String? = null*/


//fun main() {
////    val name: String = "James"  /** local level variables **/
//    if (greeting != null) {
//        println(greeting)
//    } else {
//        println("Hi there!")
//    }
//    println(name)
//}

//fun main() {
//    when (greeting ) {
//        null -> println("Hi there!")
//        else -> println(greeting)
//    }
//    println(name)
//}

/*fun main() {
//    val greetingToPrint = if (greeting != null) greeting else "Hi there!"
    val greetingToPrint = when (greeting) {
        null -> "Hi there!"
        else -> greeting
    }
    println(greetingToPrint)
    println(name)
}*/

// Functions
/*fun getGreeting(): String {
    return "Hello Kotlin"
}*/

/*fun getGreeting(): String = "Hello Kotlin"   // this is a single expression function.
//fun getGreeting() = "Hello Kotlin"  // this is even more simplified single expression function.

fun sayHello(): Unit {      // unit is absence of any useful type. It is similar to saying that it returns nothing useful. Since it is redundant, we can remove "unit" from our function.
    println(getGreeting())
}

fun main() {
    println("Hello World!")
    println(getGreeting())
    sayHello()
}*/

// Defining function parameters:

/*fun sayHello(itemToGreet: String) {
    // val msg = "Hello " + itemToGreet
    val msg = "Hello $itemToGreet"  // string template
    println(msg)
}*/

//fun sayHello(itemToGreet:String) = println("Hello $itemToGreet") // make it a single expression function with string template

// update with two parameters:
// fun sayHello(greeting:String, itemToGreet:String) = println("$greeting $itemToGreet")

/*fun main() {
    sayHello("Hey", "Kotlin!")
    sayHello("Hello", "World!")
}*/

// Collections and Iteration
/*
fun main() {
    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    println(interestingThings.size)
    println(interestingThings[0])
    println(interestingThings.get(0))


   */
/* for (interestingThing in interestingThings) {
        println(interestingThing)
    }*//*


    */
/*interestingThings.forEach {
        println(it)
    }*//*


    */
/*interestingThings.forEach { interestingThing ->     // lambda syntax within Kotlin for iteration
        println(interestingThing)
    }*//*


    interestingThings.forEachIndexed { index, interestingThing ->
        println("$interestingThing is at index $index")
    }
}
*/


//fun main() {
//    // collections are immutable by default in Kotlin, that means we cannot change these collections.
//    /*val interestingThings = listOf("Kotlin", "Programming", "Comic Books")
//    interestingThings.forEach { interestingThing ->
//        println(interestingThing)
//    }*/
//
//    // but, we can use mutable variation of such collections, for example: "mutableListOf"
//    val interestingThings = mutableListOf("Kotlin", "Programming", "Comic Books")
//    interestingThings.add("Boardgames")
//    /*interestingThings.forEach { interestingThing ->
//        println(interestingThing)
//    }*/
//    sayHello("Hi", interestingThings)
//
//    // map contains pairs
//    // val map = mapOf ( 1 to "a", 2 to "b", 3 to "c" )
//    val map = mutableMapOf ( 1 to "a", 2 to "b", 3 to "c" )
//    map.put(4, "d")
//    map.forEach {key, value -> println("$key $value")}
//
//
//}

 /*fun sayHello(greeting:String, itemsToGreet:List<String>) {
     itemsToGreet.forEach { itemToGreet ->
         println("$greeting $itemToGreet") }
 }
*/
// vararg, named arguments & default parameter values
// by using vararg, we eliminate the need to always pass in a value after the initial
fun sayHello(greeting:String, vararg itemsToGreet:String) {
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting $itemToGreet") }
}

/*fun main() {
    *//*val interestingThings = listOf("Kotlin", "Programming", "Comic Books")
    sayHello("Hi", "Kotlin", "Programming", "Comic Books")*//*
    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    sayHello("Hi", *interestingThings ) // use the spread operator "*" to pass in an array of existing values to a vararg parameter.
} */

// named argument

fun greetPerson(greeting: String, name: String) = println("$greeting $name")
// fun greetPerson(greeting: String = "Hello", name: String = "Furhat") = println("$greeting $name")

fun main() {
    greetPerson("Hi", "Faruk")
    greetPerson(name = "Faruk", greeting = "Hi") // named parameters with "=" allows us to pass in the values in any order.
    // greetPerson()
    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    sayHello(itemsToGreet = interestingThings, greeting ="Hi")
}

// Classes



