package lectures.week1basics

object StringOperations extends App {
  val myString: String = "Hello, world!"
  println(myString.length)
  println(myString.charAt(2))
  println(myString.substring(1,2))
  println(myString.split(" ").toList)
  println(myString.startsWith("He"))
  println(myString.replace("!","."))
  println(myString.toLowerCase())
  println(myString.toUpperCase())
  println(myString.reverse)
  println(myString.take(2))
  println(s"sos $myString")
  println(s"sos ${myString + myString}")
  println(raw"sos $myString") //raw used for \t
  println('a' +: "lol" :+ 's')
  println("a"++"b"++"a" :++"gg")
  println("a" + "b")
}
