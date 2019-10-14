// Convention :
// fonction : commence en minuscule
// Mot dans la fonction : commence avec une majuscule
// Class : commence par une majuscule

// HelloWorld object
object HelloWorld {
  def main(args: Array[String]) : Unit = {
    println("Hello, world!")
  }
}

// Celsius to Fahrenheit
var Celsius = 22.5 ;
var Fahrenheit = (x:Double) => (x * 8/5) + 32 ;
Fahrenheit(Celsius)

// Same with Int format
var Celsius = 22.5 ;
var Fahrenheit_int = (x:Double) => ((x * 8/5) + 32).asInstanceOf[Int] ;
Fahrenheit_int(Celsius)

// Print a string
var Montant =  2.7255;
println(s"Vous devez $Montant $$")

// Simplifier l'écriture de ces 2 lignes
var flag : Boolean = false;
var result : Boolean = !flag

// Convertir un nombre en un caractère, un string,
// un double, puis revenez à un Int !!!!!!!!!!!!!!
var nombre:Double = 33.4;
var caract:Char = nombre.asInstanceOf[Char];
var str = (s"$caract");
var doubl:Double = nombre.asInstanceOf[Double];
var integer:Int = nombre.asInstanceOf[Int];

//---------------------Loop and Pattern -----------------------------
// Un chaine en entrée, écrivez un matching pattern qui retournera la même chaine de caractère si elle n'est
//pas vide, ou bien la chaîne "n/a" si elle est vide
var chaine:String = "Coucou c'est moi"
def matching(args: String)  {
  if (args == chaine) println(s"$args")
  else println(s"n/a")
}
matching("Coucou c'est moi")
matching("Coucou c'est pas moi")

// Étant donné un double, écrivez une expression pour retourner "plus grand" s'il est supérieur à zéro,
//"même" s'il est égal à zéro, et "moins" s'il est inférieur à zéro.
// Qu'en est-il des matching pattern ?
def comparaison_nbr(args:Double): Unit = {
  if (args > 0 ) println(s"Plus grand")
  else if (args == 0) println(s"Même")
  else println(s"Moins")
}
comparaison_nbr(-5)

// with matching patterns method
object ComparaisonToZero {
  // main method
  def main(args: Int) {
    println(test(args));
  }
  // method containing match keyword
  def test(args:Int): String = args match {
    case args if args == 0 => "Même"
    case args if (args > 0) => "Supérieur"
    case args if (args < 0) => "Inférieur"
  }
}

ComparaisonToZero.main(5)

// Ecrire une expression pour convertir une des valeurs d'entrée cyan, magenta, jaune en leurs équivalents
//hexadécimaux à six caractères sous forme de chaîne. Que pouvez-vous faire pour gérer les conditions
//d'erreur ?
def CouleurConvertion(args:String): String = args match {
    case "cyan" => "#00FFFF"
    case "magenta" => "#FF00FF"
    case "jaune" => "ffff00"
    case _ => "error"
}
CouleurConvertion("cyan")

// Imprimez les chiffres de 1 à 100, chaque ligne contenant un groupe de cinq chiffres
def ImpressionChiffres(args:Int) : Unit = {
  var counter: Int = 1;
  while(counter < 101) {
    var repeat: Int = 0;
    while(repeat < args){
      print(counter + " ");
      counter = counter + 1
      repeat = repeat + 1
    }
      println();
  }
}
ImpressionChiffres(5)

def ImpressionChiffresBis(args:Int) : Unit = {
  for(counter <- 1 to 100 by 5) {
    for(i <- counter to (counter + args - 1)){
      print(i + " ");
    }
      println()
  }
}
ImpressionChiffresBis(5)

// Ecrivez une expression pour imprimer les nombres de 1 à 100, sauf pour les multiples de 3, imprimer
//"type" et pour les multiples de 5, imprimer "safe". Pour les multiples de 3 et 5, écrivez "typesafe"
def ImpressionChiffresNotMultiple() : Unit = {
  for(number <- 1 to 101) {
     if (number % 3 == 0 && number %5 == 0) println("typesafe")
     else if (number % 5 ==0) println("safe")
     else println("type")
  }
}
ImpressionChiffresNotMultiple()

//------------------- fonctions, fonctions récursives, fonctions typées, méthodes ----------------
//










