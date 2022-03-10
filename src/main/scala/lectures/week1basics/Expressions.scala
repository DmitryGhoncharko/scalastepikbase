package lectures.week1basics

object Expressions extends App {
  //in scala all is expression
  val aCondition = true
  val ifExpressionValue = if(aCondition) "Condition true" else "False condition"
  println(ifExpressionValue)
  //Unit in Scala as void in Java
  val someVal : Unit = println("hello")

  val myPrint: Unit = print("Hello")
  print(myPrint)
}
