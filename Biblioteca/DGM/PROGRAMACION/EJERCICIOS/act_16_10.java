package Biblioteca.DGM.PROGRAMACION.EJERCICIOS;

import java.util.Scanner;

public class act_16_10 {
  
  static void printMessageInConsole(String message){
    System.out.println(message);
  }
  
  public static final String CONSTANT_VARIABLE = "ESTO ES UNA CONSTANTE";
  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    printMessageInConsole("Introduce un byte");
    Byte byteInput = scanner.nextByte();


    printMessageInConsole("Introduce un short");
    Short shortInput = scanner.nextShort();

    printMessageInConsole("Introduce un long");
    Long longInput = scanner.nextLong();

    printMessageInConsole("Introduce un entero");
    int intInput = scanner.nextInt();


    printMessageInConsole("Introduce un numero decimal");
    float firstDecimalInput = scanner.nextFloat();


    printMessageInConsole("Introduce otro numero decimal");
    float secondDecimalInput = scanner.nextFloat();

    
    
    printMessageInConsole("Introduce una nota");
    int mark = scanner.nextInt();


        
    printMessageInConsole("Introduce una dia");
    int day = scanner.nextInt();

    
    boolean isGreaterThan = firstDecimalInput>secondDecimalInput;
    
    
    printMessageInConsole("Esto es un byte: " + byteInput);
    printMessageInConsole("Esto es un short: " + shortInput);
    printMessageInConsole("Esto es un long: " + longInput);
    printMessageInConsole("Esto es un entero: " + intInput);
    printMessageInConsole("El primer número decimal es mayor que el segundo?: " + isGreaterThan);
    printMessageInConsole(CONSTANT_VARIABLE);
    
    if(mark<5){
      printMessageInConsole("Suspenso");
    }
    else if(mark==5){
      printMessageInConsole("Aprobado");
    }
    else if(mark==6){
      printMessageInConsole("Bien");
    }
    else if(mark>6&&mark<=8 ){
      printMessageInConsole("Notable");
    }
    else if(mark>8&&mark<=10 ){
      printMessageInConsole("Sobresaliente");
    }


    switch (day) {
      case 1->printMessageInConsole("Lunes");
      case 2->printMessageInConsole("Martes");
      case 3->printMessageInConsole("Miercoles");
      case 4->printMessageInConsole("Jueves");
      case 5->printMessageInConsole("Viernes");
      case 6->printMessageInConsole("Sabado");
      case 7->printMessageInConsole("Domingo");
      default-> printMessageInConsole("Introduce un número del 1 al 7");
      
    }


  }
  
}
