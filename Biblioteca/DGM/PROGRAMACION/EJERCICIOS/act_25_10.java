package EJERCICIOS;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class act_25_10{



  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    init(scanner);
    }
  

static void printMessageInConsole(String message){
  System.out.println(message);
}


static void clearConsole(){
  System.out.print("\033\143");
}


public static void init(Scanner scanner){
  

printMessageInConsole("HOLA BIENVENIDO A ESTE PROGRAMA");
printMessageInConsole("INTRODUCE UN NUMERO PARA SELECCIONAR UNA OPCION");
printMessageInConsole("1. CALCULADORA");
printMessageInConsole("2. IMC");
printMessageInConsole("3. DESCUENTOS");
printMessageInConsole("4. PAR O IMPAR");
printMessageInConsole("5. CAJERO AUTOMATICO");


int menuOption = scanner.nextInt();


switch (menuOption) {
  case 0:
    
    break;
    case 1:
    new Calculator(scanner).init(); 
    break;

    case 2:
    clearConsole();
    new IMCCalculator(scanner).init();
    break;

    case 3:
    clearConsole();
    new Discount(scanner).init();
    break;

    case 4:
    clearConsole();
    new EvenOrOdd(scanner).init();
    break;

    case 5:
    clearConsole();
    new ATM(scanner).init(); 
    break;


  default:
    break;
}

printMessageInConsole("-------------------------------------------------");
printMessageInConsole("#################################################");
printMessageInConsole("#################################################");
printMessageInConsole("¿QUIERES ACCEDER A OTRO PROGRAMA?" );
printMessageInConsole("S/N" );
printMessageInConsole("#################################################");
printMessageInConsole("#################################################");


String anotherOperation = scanner.next();



if(anotherOperation.toLowerCase().equals("s") || anotherOperation.toLowerCase().equals("si")){
  clearConsole();
  init(scanner);
}

}




private static class Calculator{


  public static Scanner calculatorScanner;


  public static double firstNumber;
  public static double secondNumber;

  public Calculator(Scanner scanner){
    calculatorScanner = scanner;
  }


  public double sum(){
    return firstNumber + secondNumber;
  }
  public double substract(){
    return firstNumber - secondNumber;
  }


  public double multiply(){
    return firstNumber * secondNumber;
  }


  
  public double divide(){
    return firstNumber / secondNumber;
  }





public void init(){
  clearConsole();
  printMessageInConsole("---------------------------------");
  printMessageInConsole("---------------------------------");
  printMessageInConsole("HOLA BIENVENIDO A LA CALCULADORA");
  printMessageInConsole("---------------------------------");
  printMessageInConsole("---------------------------------");


  printMessageInConsole("INTRODUCE EL PRIMER NUMERO");
  firstNumber = calculatorScanner.nextDouble();
  printMessageInConsole("INTRODUCE UNA OPERACION: + , - , * , / ");
  char operation = calculatorScanner.next().charAt(0);
  printMessageInConsole("INTRODUCE EL SEGUNDO NUMERO");
  secondNumber = calculatorScanner.nextDouble();
  HashMap<Character, Callable<Double>> myMap = new HashMap<Character, Callable<Double>>();

  myMap.put('+', this::sum);
  myMap.put('-', this::substract);
  myMap.put('*', this::multiply);

  myMap.put('/', this::divide);


  Callable<Double> method= myMap.get(operation);

  try {
    clearConsole();
    double result =  method.call(); 
    printMessageInConsole("EL RESULTADO DE " + firstNumber +" " + operation + " " +secondNumber);

    printMessageInConsole("ES: " + result);
} catch (Exception e) {
    e.printStackTrace();
}
printMessageInConsole("-------------------------------------------------");
printMessageInConsole("#################################################");
printMessageInConsole("#################################################");
printMessageInConsole("¿QUIERE REALIZAR OTRA OPERACION?" );
printMessageInConsole("S/N" );
printMessageInConsole("#################################################");
printMessageInConsole("#################################################");
String anotherOperation = calculatorScanner.next();

if(anotherOperation.toLowerCase().equals("s") || anotherOperation.toLowerCase().equals("si")){
  clearConsole();
  init();
}
clearConsole();


  }



}
private static class ATM{

  static Scanner atmscanner;

  public ATM(Scanner scanner){
    atmscanner = scanner;

  }
  
  public void init(){
  
    
    printMessageInConsole("-------------BIENVENIDO A SU CAJERO-------------");
    printMessageInConsole("#################################################");
    printMessageInConsole("#################################################");
    printMessageInConsole("INTRODUCE UN NUMERO PARA SELECCIONAR UNA OPCION");
    printMessageInConsole("#################################################");
    printMessageInConsole("#################################################");


    printMessageInConsole("1. CONSULTAR SALDO");
    printMessageInConsole("2. DEPOSITAR DINERO");
    printMessageInConsole("3. SACAR DINERO");
    printMessageInConsole("4. SALIR DEL CAJERO");
    
    printMessageInConsole("-------------------------------------------------");


    int userOption = atmscanner.nextInt();

    switch (userOption) {
        case 1:
        printMessageInConsole("SU SALDO ACTUAL ES DE " + getBalance() + " EUROS" );
        break;

        case 2:
        printMessageInConsole("¿QUE CANTIDAD EN EUROS DESEA INTRODUCIR?" );
        double quantity = atmscanner.nextDouble();
        deposit(quantity);
        break;

        case 3:
        try{
          printMessageInConsole("¿QUE CANTIDAD EN EUROS DESEA SACAR?" );
          double withdraw = atmscanner.nextDouble();
          withdrawal(withdraw);
          break;
        }catch(Exception e){
          printMessageInConsole(e.getMessage());
          init();
          break;
        }

        case 4:
        return;
    
    
      default:
        break;

  }
  
  printMessageInConsole("-------------------------------------------------");
  printMessageInConsole("#################################################");
  printMessageInConsole("#################################################");
  printMessageInConsole("¿QUIERE REALIZAR OTRA OPERACION?" );
  printMessageInConsole("S/N" );
  printMessageInConsole("#################################################");
  printMessageInConsole("#################################################");
  String anotherOperation = atmscanner.next();
  
  if(anotherOperation.toLowerCase().equals("s") || anotherOperation.toLowerCase().equals("si")){
    clearConsole();
    init();
  }
  clearConsole();


}


  private double balance = 200;

  private void addToBalance(double deposit){
    balance +=deposit;
  }

  private void setBalance(double quantity){
    balance =quantity;
  }

  private double getBalance(){
    return balance;
  } 

  public void deposit(double money){
    addToBalance(money);
    printMessageInConsole("USTED HA DEPOSITADO  LA CANTIDAD DE: " + money + " EUROS" );
    printMessageInConsole("SU SALDO ACTUAL ES DE " + getBalance() + " EUROS" );
  }

  public void withdrawal(double quantity) throws Exception{
    if(quantity>balance){
      printMessageInConsole("ESTA OPERACION NO PUEDE REALIZARSE. EL IMPORTE ES SUPERIOR AL BALANCE");
      throw new Exception("OPERACION NO REALIZADA");
    }
    double currentBalance = getBalance() - quantity;
    setBalance(currentBalance);
    printMessageInConsole("USTED HA SACADO  LA CANTIDAD DE: " + quantity + " EUROS" );
    printMessageInConsole("SU SALDO ACTUAL ES DE " + getBalance() + " EUROS" );
  }

}

private static class EvenOrOdd{

  public static Scanner evenOrOddscanner;

  public EvenOrOdd(Scanner scanner){

    evenOrOddscanner = scanner;
  }

  
  private static void evenOrOdd(int number){
    if(number%2==0){
      printMessageInConsole("EL NÚMERO " + number + " ES PAR");
      return;
    }
    

    printMessageInConsole("EL NÚMERO " + number + " ES IMPAR");

  }

  public void init(){


    printMessageInConsole("HOLA BIENVENIDO A ESTE PROGRAMA PARA CALCULAR SI UN NUMERO ES PAR O IMPAR");
    printMessageInConsole("INTRODUCE UN NUMERO");

    int number = evenOrOddscanner.nextInt();

    evenOrOdd(number);

    

    printMessageInConsole("-------------------------------------------------");
    printMessageInConsole("#################################################");
    printMessageInConsole("#################################################");
    printMessageInConsole("¿QUIERES VOLVER A INTRODUCIR UN NÚMERO?" );
    printMessageInConsole("S/N" );
    printMessageInConsole("#################################################");
    printMessageInConsole("#################################################");
    String anotherOperation = evenOrOddscanner.next();

if(anotherOperation.toLowerCase().equals("s") || anotherOperation.toLowerCase().equals("si")){
  clearConsole();
  init();
}
clearConsole();



  }
}

private static class IMCCalculator{

  public  Scanner imcScanner;
  

  public IMCCalculator (Scanner scanner){
    imcScanner = scanner;
  }
  
  public void init(){


  
      printMessageInConsole("--------BIENVENIDO A SU CALCULADORA DE iMC-------");
      printMessageInConsole("#################################################");
      printMessageInConsole("#################################################");
      printMessageInConsole("-------------------------------------------------");

  
  
      printMessageInConsole("INTRODUCE TU ALTURA EN CM: ");
      double height = imcScanner.nextDouble();

        
      printMessageInConsole("INTRODUCE TU PESO EN KG: ");
      double weight = imcScanner.nextDouble();


      double imc = weight / (Math.pow(height/100, 2));

      if(imc<18.5){
        printMessageInConsole("TU PESO ES BAJO PARA TU ALTURA");
      }

      else if(imc>=18.5 && imc<25){
        printMessageInConsole("TU PESO ES EL IDEAL PARA TU ALTURA");
      }
      
      else if(imc>=25 && imc<30){
        printMessageInConsole("TU PESO ES ALTO PARA TU ALTURA");
      }
      else{
        printMessageInConsole("TU PESO ES MUY ALTO PARA TU ALTURA");
      }

    
      clearConsole();
      printMessageInConsole("-------------------------------------------------");
      printMessageInConsole("#################################################");
      printMessageInConsole("#################################################");
      printMessageInConsole("¿QUIERES CONSULTAR OTRA VEZ?" );
      printMessageInConsole("S/N" );
      printMessageInConsole("#################################################");
      printMessageInConsole("#################################################");
      String anotherOperation = imcScanner.next();
    
      if(anotherOperation.toLowerCase().equals("s") || anotherOperation.toLowerCase().equals("si")){
        clearConsole();
        init();
      }
  
  
  }
}

private static class Discount{

  public static Scanner discountScanner;



  public Discount(Scanner scanner){
    discountScanner = scanner;
  }

  public void init(){

    printMessageInConsole("INTRODUCE EL PRECIO DEL ARTICULO");
    double articlePrice = discountScanner.nextDouble();

    printMessageInConsole("INTRODUCE EL DESCUENTO QUE QUIERES APLICAR AL ARTICULO");
    double discount = discountScanner.nextDouble();


    if(discount <0 || discount>100){
      printMessageInConsole("NO PUEDE SER SUPERIOR AL 100%, INTRODUCE UN NÚMERO VALIDO");
      discount = discountScanner.nextDouble();
    }

    double discountresult = (articlePrice*discount)/100;

    double resultprice = articlePrice-discountresult;

    printMessageInConsole("EL PRECIO FINAL ES DE : " + resultprice  + "EUROS" );

    
    printMessageInConsole("-------------------------------------------------");
    printMessageInConsole("#################################################");
    printMessageInConsole("#################################################");
    printMessageInConsole("¿QUIERES CALCULAR EL PRECIO OTRA VEZ?" );
    printMessageInConsole("S/N" );
    printMessageInConsole("#################################################");
    printMessageInConsole("#################################################");
    String anotherOperation = discountScanner.next();
    
    if(anotherOperation.toLowerCase().equals("s") || anotherOperation.toLowerCase().equals("si")){
      clearConsole();
      init();
    }
      clearConsole();



  }






}
}
