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

  private static void printInitialMessage(){
    printInConsole("------------------------------------------------------");
    printInConsole("------------------------------------------------------");
    printInConsole("-----------HOLA BIENVENIDO A ESTE CAJERO--------------");
    printInConsole("------------------------------------------------------");
    printInConsole("------------------------------------------------------");

    printInConsole("---------INDICA LA CANTIDAD QUE QUIERES RETIRAR--------");
  }

  public static void printInConsole(String message){
    System.out.println(message);
  }


  public static void main(String args[]){


    Scanner scanner = new Scanner(System.in);

    printInitialMessage();

    int quantity = scanner.nextInt();
    
    boolean isDivisibleByFive = quantity%5==0;

    if(isDivisibleByFive){
       if(quantity>=50){
        int bills = quantity/50;
        int rest = quantity&50;
        printInConsole("SUS billete son: " + bills);
        printInConsole("SUS resto son: " + rest);
       }

    }



  }


}