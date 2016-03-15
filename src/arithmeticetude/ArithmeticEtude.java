/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmeticetude;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class ArithmeticEtude {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // The name of the file to open.
        String fileName = "C:\\Users\\James\\Documents\\NetBeansProjects\\ArithmeticEtude\\src\\arithmeticetude\\input.txt";

        // This will reference one line at a time
        String line = null;
        int lineCount = 1;
        String [] numIn = null;
        String posAndResult = "";
        String []temp;
        int result = 0;
        char opType = ' ';
        ArrayList<InputObject> scene = new ArrayList<>();
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                if(lineCount % 2 > 0){
                
                //convert these to ints - next step - then put in object???
                numIn = line.split(" ");
                System.out.println("numIn1" + numIn[0]);
                System.out.println("numIn2" + numIn[1]);
                System.out.println("numIn3" + numIn[2]);
                
                //System.out.println("numIn" + numIn);
                }
                if(lineCount % 2 == 0){
                
                    posAndResult = line;
                    //System.out.println("in mod statement" + posAndResult);
                    //while(res Character.isS){}
                    //capture the result at first space eg before the opType
                    temp = posAndResult.split(" ");
                    //place it as int
                    result = Integer.parseInt(temp[0]);
                    System.out.println("the result :" + result);
                    opType = line.charAt(line.length()-1);
                    System.out.println("optype" + opType);
                    
                    InputObject calc = new InputObject(numIn, result, opType);
                    
                    scene.add(calc);
                    
                }
                
                //need to place each scenairo into an arraylist like ants after line two
                lineCount ++;
                
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        InputObject calc = new InputObject(numIn, result, opType);
        System.out.println("ArrayList size " + scene.size());
        
        switch (opType){
        
            case 'N':
                int output = InputObject.timesNumbersTogether(calc);
                System.out.println("in output " + output);
                if(output  < result){
                
                    System.out.println("Impossible");
                }
               
                InputObject.addAllNumbersTogether(calc);
                InputObject.testPairsOfNums(calc);
                
                break;
                
             case 'L':
                break;
        }
    
    }
}
        
    
    
