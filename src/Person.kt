/*class Person (_firstName: String, _lastName: String) {
    val firstName: String = _firstName
    val lastName: String = _lastName

    // initialize the property values
    *//*init {
        firstName = _firstName
        lastName = _lastName
    }*//*
}*/

// define a first name and last name properties within the primary constructor directly.
/*class Person(val firstName: String, val lastName: String) {
    init {
        println("init 1")
    }
    // create a secondary constructor
    constructor(): this(firstName = "Peter", lastName = "Parker") {
        println("secondary constructor")
    }
    init {
        println("init 2")
    }
}*/

class Person(val firstName: String = "Peter", val lastName: String = "Parker") {
    var nickName: String? = null
        set(value) {
            field = value
            println("the new nickname is $value")
        }
        get() {
            println("the returned value of nickname is $field")
            return field
        }

    fun printInfo() {
        // val nickNameToPrint = if(nickName != null) nickName else "no nickname"
        val nickNameToPrint = nickName ?: "no nickname" // "?:" is called Elvis operator and Caitlyn. It checks whats on the left side of the Elvis operator. If that side of the expression is not null, the go ahead and return that. Otherwise, return what is on the right side of the expression.
        println("$firstName ($nickNameToPrint) $lastName")
    }
}

// Visibility Modifiers - Public/Private/Protected/Public

//