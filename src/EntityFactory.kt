import java.util.*

/*
interface IdProvider {
    fun getId(): String
}

class Entity private constructor (val id: String) {
    // companion object
    companion object Factory : IdProvider {
        override fun getId(): String {
            return "123"
        }
        const val id = "id"
        fun create() = Entity(getId())

    }
}

fun main() {
    val entity = Entity.Factory.create()
    Entity.id
}*/


// Object Declarations: is a convenient way of creating threads saved singletons within Kotlin.

// enum class
enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}


object EntityFactory {
   // fun create() = Entity("id", "name")
   fun create(type: EntityType): Entity {
       val id = UUID.randomUUID().toString()
       val name = when(type) {
           //EntityType.EASY -> "Easy"
           EntityType.EASY -> type.name // reference the class name directly
           EntityType.MEDIUM -> type.getFormattedName()
           EntityType.HARD -> "Hard"
           EntityType.HELP -> type.getFormattedName()
       }
       // return Entity(id, name)
       // when using sealed class section below:
       return when (type) {
           EntityType.EASY -> Entity.Easy(id, name)
           EntityType.MEDIUM -> Entity.Medium(id, name)
           EntityType.HARD -> Entity.Hard(id, name, multiplier = 2f)
           EntityType.HELP -> Entity.Help
       }
   }
}

/*class Entity (val id: String, val name: String) {
    override fun toString(): String {
        return "id:$id name:$name"
    }
}*/

// Sealed Class: allows us to define restricted class hierarchies. That means we could define a set number of classes
// all extending a base type, but those classes will be the only ones that can extend that base type.
sealed class Entity {
    // can also use onject declaration within sealed class:
    object Help : Entity() {
        val name = "Help"
    }
    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()
}

// Extension Functions
fun Entity.Medium.printInfo() {
    println("Medium class: $id")
}

// Extension Properties

val Entity.Medium.info: String
    get() = "some info"

/*
fun main() {
    */
/*val entity = EntityFactory.create(EntityType.EASY)
    println(entity)

    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
    println(mediumEntity)*//*


    val entity: Entity = EntityFactory.create(EntityType.HELP)
    val msg = when (entity) {
        Entity.Help -> "Help class"
        is Entity.Easy -> "Easy class"
        is Entity.Medium -> "Medium class"
        is Entity.Hard -> "Hard class"
    }
    println(msg)
}*/

// Data Classes: are Kotlin's way of providing very concise, immutable data types. It means it is going to
// generate methods as equals hashcode into string automatically for us. This allows us to perform a quality
// comparisons on instances of these data classes and treat them as equal if the data they contain is equal.

fun main() {
    val entity1 = EntityFactory.create(EntityType.EASY)
    val entity2 = EntityFactory.create(EntityType.EASY)

    val entity3 = EntityFactory.create(EntityType.MEDIUM)
    if (entity3 is Entity.Medium) {
        entity3.printInfo()
        entity3.info
    }
    // Entity.Medium("id", "name").printInfo()

    /*if (entity1 == entity2) {
        println("they are equal")
    } else {
        println("they are not equal")
    }*/
}

