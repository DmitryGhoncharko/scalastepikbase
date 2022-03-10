package lectures.week1basics

import scala.annotation.tailrec

object Recursion extends App{
//  Например, вот таким while-циклом мы можем напечатать слово n раз.
  var i = 0
  while (i < 3) {
    println("hello")
    i += 1
  }
//  Циклы нам не подходят - это мы выяснили. Но что тогда вместо них? А вместо них - рекурсия.
  // При рекурсии мы можем доволоьно быстро получить переполнение стека, поэтому лучше использовать хвостовую рекурсию
def factorial(n: Int): Int = {
  if (n <= 0) 1
  else n * factorial(n - 1)
}

  println(factorial(3))
    //Хвостовая рекурсия
//  Как писать функции в стиле хвостовой рекурсии
//  1. Определяете функцию. Назовем ее основной.
//
//  2. Внутри основной функции прописываете еще одну функцию. Назовем ее вспомогательной.
//
//  3. В качестве аргументов вспомогательной функции указываете число вызовов (этот аргумент совпадает с одним из аргументов основной функции) - плюс аккумулятор, который будет содержать конечный результат.
//
//  4.  Прописываете код с рекурсией в теле вспомогательной функции с использованием аккумулятора (так, чтобы значение постепенно накапливалось)
//
//  5. Вызываете вспомогательную функцию из основной функции. Не забудьте указать начальное значение аккумулятора, задающее отправную точку всех вычислений. Используйте аргумент по умолчанию для оптимизации кода.
def factorialWithTailRecursion(n: Int): Int = {
  @tailrec
  def loop(x: Int, accumulator: Int = 1): Int = {
    if (x <= 1) accumulator
    else loop(x-1, x*accumulator)
  }

  loop(n)
}
  def powerOfTwo(powerOf:Int):BigInt = {
    @tailrec
    def loop(currentPowerOf:Int, accumulator:BigInt=2):BigInt = {
      if(currentPowerOf==1) accumulator
      else loop(currentPowerOf-1, 2*accumulator)
    }
    loop(powerOf)
  }
  println(powerOfTwo(6))
  def calculateResult(x:Int, y:Int, n:Int):Int = {
    @tailrec
    def loop(x:Int = x, y:Int = y, n:Int, accumulator:Int=x):Int = {
      if(n<=0) accumulator
      else {
        loop(x,y,n-1,accumulator+y)
      }
    }
    loop(x,y,n)
  }
  def printNumberByNumberLength(number:Int) : Unit = {
    val numberLength:Int = number.toString.length
    @tailrec
    def loop(numberLength:Int, number:Int): Unit = {
      if(numberLength<=1){
        ()
      }
      else {
        print(number + " ")
        loop(numberLength-1,number)
      }
    }
    loop(numberLength, number)
    print(number + " is the result")
  }
  val res = calculateResult(100,2,7)
  printNumberByNumberLength(res)
  var input : String = "fdsf sdf asdf dsf  "
  def result(input:String) : String = {
    val arrayString:Array[String] = input.trim.split("\\s+")
    val arrayStringLength:Int = arrayString.length
    @tailrec
    def loop(arrayReversedLength:Int, arrayReversed:Array[String], accumulator:String=""): String = {
      if(arrayReversedLength<=1) {
        accumulator + arrayReversed(arrayReversedLength-1)
      }
      else{
        loop(arrayReversedLength-1, arrayReversed, accumulator + arrayReversed(arrayReversedLength-1) + " ")
      }
    }
    loop(arrayStringLength, arrayString)
  }
  print(result(input).trim)
}
