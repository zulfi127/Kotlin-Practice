interface PersonInfoProvider {
    val providerInfo: String

    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}


open class BasicInfoProvider: PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "Basic Info Provider"

    open val sessionIdPrefix = "Session"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

/*fun main() {
    //val provider = BasicInfoProvider()
    val provider = FancyInfoProvider()
    provider.sessionIdPrefix

    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)
}

// Type Checking And Smart Casts

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("not a session info provider")
    } else {
        println("is a session info provider")
        // (infoProvider as SessionInfoProvider).getSessionId() // "as" is a keyword to cast sth to another type.
        infoProvider.getSessionId()  // the compiler is performing a smart cast.
    }
}*/

fun main() {
    // create an object expression:
   val provider = object : PersonInfoProvider {
       override val providerInfo: String
       get() = "New Info Provider"

       fun getSessionId() = "id"
   }
    provider.printInfo(Person())
    provider.getSessionId()

}