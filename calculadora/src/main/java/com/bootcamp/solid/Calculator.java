package com.bootcamp.solid;
public class Calculator {
    public void calculate(Object operation) throws Exception {
      
        
    	
    	if (operation == null) {
            throw new Exception("Can not perform operation");
        }
        
   
        
       
    }

    public static void main(String[] args) throws Exception {



        Suma add = new Suma(10,5);
       

        System.out.println("Resultado calculator: " +  add.Operation());

        Substraction sb = new Substraction(10,5);


        System.out.println("Resultado susbration " +  sb.Operation());

        Multiplication ml = new Multiplication(10,5);
      

        System.out.println("Resultado multiplication " +  ml.Operation());

        Dividir dv = new Dividir(10,5);

        System.out.println("Resultado division " +  dv.Operation());
    	
    	
    	
    }

}