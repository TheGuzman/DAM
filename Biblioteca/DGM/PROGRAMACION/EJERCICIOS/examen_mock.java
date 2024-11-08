package EJERCICIOS;

import java.util.Scanner;


// Realiza un programa que simule el funcionamiento de un cajero automático. El programa
// solicitará al usuario el importe en efectivo que desea retirar, que será un número entero de
// euros (€). El programa calculará el número mínimo de billetes de 50, 20, 10 y 5 euros para
// obtener dicho importe y presentará la información al usuario.
// Si el importe introducido por el usuario no es múltiplo de 5 se informará también al usuario
// del importe que el cajero no es capaz de satisfacer por no disponer de billetes de esa
// cantidad. Por ejemplo, si el usuario introduce 78 €, el programa informará de que se
// retirarán 75 € en los billetes que corresponda y que 3 € no se pueden retirar por no existir
// billetes tan pequeños.


public class examen_mock{

  private static int fiftyBills;
  private static int twentiesBills;
  private static int tensBills;
  private static int fiveBills;


  private static void clearConsole(){
    System.out.print("\033\143");
  }


  private static void printInitialMessage(){
    printInConsole("------------------------------------------------------");
    printInConsole("------------------------------------------------------");
    printInConsole("-----------HOLA BIENVENIDO A ESTE CAJERO--------------");
    printInConsole("------------------------------------------------------");
    printInConsole("------------------------------------------------------");
    printInConsole("---------INDICA LA CANTIDAD QUE QUIERES RETIRAR--------");
  }


  private static void printResult(){

    printInConsole("------------------------------------------------------");
    printInConsole("------------------------------------------------------");
    printInConsole("-----------------TUS BILLETES SON---------------------");
    printInConsole("------------------------------------------------------");
    printInConsole("------------------------------------------------------");
    printInConsole("-----------------------DE 50: " + fiftyBills + "----------------------");
    printInConsole("------------------------------------------------------");
    printInConsole("-----------------------DE 20: " + twentiesBills + "-----------------------");
    printInConsole("------------------------------------------------------");
    printInConsole("-----------------------DE 10: " + tensBills + "-----------------------");
    printInConsole("------------------------------------------------------");
    printInConsole("-----------------------DE 5: " + fiveBills + "------------------------");

  }


  private static int calculateBills(int quantity){
        fiftyBills = quantity/50;
        int fiftiesRest = quantity%50;
        twentiesBills = fiftiesRest/20;
        int twentiesRest = fiftiesRest % 20;
        tensBills = twentiesRest/10;
        int tesnsRest = twentiesRest % 10;
        fiveBills = tesnsRest/5;
        int fiveRest = tesnsRest%5;
        return fiveRest;
  }


  public static void printInConsole(String message){
    System.out.println(message);
  }


  public static void main(String args[]){


    Scanner scanner = new Scanner(System.in);

    printInitialMessage();

  

    int quantity = scanner.nextInt();
    
    boolean isDivisibleByFive = quantity%5==0;
    int restOfQuantity = quantity%5;
    clearConsole();

    if(isDivisibleByFive){
 
    calculateBills(quantity);
    printResult();
    scanner.close();
    return;
    }

    printInConsole("EL NÚMERO " + quantity + " NO ES DIVISIBLE POR 5, PUEDES SACAR " + (quantity - restOfQuantity));
    int rest = calculateBills(quantity);

    printInConsole("VAS A SACAR " + (quantity - restOfQuantity) + " PORQUE NO HAY BILLETES TAN PEQUEÑOS PARA " + rest + " EUROS");

    printResult();
    

    scanner.close();

  }


}