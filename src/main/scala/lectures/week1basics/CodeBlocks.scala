package lectures.week1basics

object CodeBlocks extends App {
    //result code block is a result last expression line in code block
    val codeBlock = {
      val someVal = 1
      val y = 2
      if(someVal+y>0) true else false
    }
  println(codeBlock)
  val codeBlockString = {
    val someVal = 1
    val y = 2
    if(someVal+y>0) true else false
    "Hello world"
  }
  println(codeBlockString)
}
