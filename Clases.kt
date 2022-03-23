import kotlin.math.PI
fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)
    with(squareCabin)
    {
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room?: ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
    }
    println("\n")
    with(roundHut){
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room?: ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
    }
    println("\n")
    with(roundTower){
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room?: ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
    }


}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
	}
    abstract fun floorArea():Double
}
class SquareCabin(residents: Int, val length:Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6
    override fun floorArea():Double{
        return length*length
    }
}
open class RoundHut(residents:Int, val radius:Double):Dwelling(residents){
	override val buildingMaterial = "Straw"
	override val capacity = 4
    override fun floorArea():Double{
        return PI * radius * radius
    }
}
class RoundTower(residents: Int, radius: Double, val floors:Int = 2): RoundHut(residents, radius){
	override val buildingMaterial ="Stone"
	override val capacity = 4 * floors
    override fun floorArea():Double{
        return super.floorArea()*floors
    }
}
