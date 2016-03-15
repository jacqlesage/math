/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmeticetude;

import java.util.ArrayList;

/**
 *
 * @author James
 */
public class InputObject {

    private String[] numIn;
    private int result;
    private char opType;

    public InputObject(String[] numIn, int result, char opType) {

        this.numIn = numIn;
        this.result = result;
        this.opType = opType;

    }

    public String[] getNumIn() {
        return numIn;
    }

    public void setNumIn(String[] numIn) {
        this.numIn = numIn;
    }

    public int getResult() {
        return result;
    }

    public void setResult(char result) {
        this.result = result;
    }

    public char getOpType() {
        return opType;
    }

    public void setOpType(char opType) {
        this.opType = opType;
    }

    /**
     * Returns the amount of all the numbers added together. An easy one to test
     * for.
     *
     * The result if adding all the numbers together is larger than the result
     * we know we need to look at * or - reducing some options.
     *
     * @param x
     * @return int vale of numbers added up
    *
     */
    public static int addAllNumbersTogether(InputObject x) {
        String[] numIn;
        int result = x.getResult();
        int temp = 0;
        
        numIn = x.getNumIn();

        for (int i = 0; i < numIn.length; i++) {
            temp += Integer.parseInt(numIn[i]);
            // return result if it equals the result then can use it
        }

        return temp;
    }

    /**
     * Returns the amount of all the numbers multiplied together. An easy one to
     * test for.
     *
     * The result if mutliplying all the numbers together is still less than the
     * result we know we know impossible
     *
     * @param x
     * @return int vale of numbers added up
    *
     */
    public static int timesNumbersTogether(InputObject x) {
        String[] numIn;
        int result = x.getResult();
        Integer temp = 1;
        numIn = x.getNumIn();

        for (int i = 0; i < numIn.length; i++) {
            System.out.println("numint " + numIn[i]);
            temp *= Integer.parseInt(numIn[i]);
            System.out.println("in temp for times " + temp);
            // return result if it equals the result then can use it
        }

        return temp;
    }

    /**
     * Returns the amount of all the numbers multiplied together. An easy one to
     * test for.
     *
     * The result if multiplying all the numbers together is larger than the
     * result we know we need to look at * or - reducing some options.
     *
     * We now know if all of the numbers multiplied is still less than the
     * result then result = impossible
     *
     * @param x input from the text file
     * @return int vale of numbers added up
    *
     */
    public static int testPairsOfNums(InputObject x) {
        String[] numIn;
        ArrayList<String[]> resultArray = new ArrayList<String[]>();
        int result = x.getResult();
        int temp = 0;
        int temp1 = 0;
       
        //int 
        numIn = x.getNumIn();
        int reducingResult = result;
        for (int i = 0; i < numIn.length; i++) {

            temp = Integer.parseInt(numIn[i]);

            if (temp == numIn.length) {

            } else {
                temp1 = Integer.parseInt(numIn[i + 1]);

                if (temp * temp1 > result && numIn[i] == numIn[0]) {
                //then we know that that combination is bust - no use to us
                    //we then need to store those indexes, if it is the first number
                    //wthe we know that it is a X + , instead of X * .
                    String[] s = new String [1];
                    s[0] = numIn[0] + " " + "+" + " ";
                    resultArray.add(s);
                }

                if (temp * temp1 > result) {
                    
                    //then we want to move onto the next ? 
                    
                }
                
                if (temp * temp1 < result) {
                    //then we want to use it 
                    //minus that from the result as a temp variable
                    //and try the other pairs if it is short we know that 
                    //that must be incorrect so add a plus
                    
                    reducingResult -= temp*temp1;
                    //if we are checking the second to last number then we know we 
                    //either need to + or * the last number to see if we get 
                    //the correct answer if not we know that the selection we chose
                    //must be a +, now a *.
                    if(temp1 == numIn.length-2)
                    {
                        if(temp * temp1 + numIn.length == result){
                            //then we know the last two number + this one makes 
                            //the result so add that piece to the string
                            String[] s = new String [1];
                            s[1] = temp +" " + "*"+ " "+ temp1 + " " + "+" + numIn.length;
                            
                            resultArray.add(s);
                        }
                    
                    }
                    
                    
                }

                System.out.println("temp " + temp);
                System.out.println(temp1);
                // return result if it equals the result then can use it
            }

        }
        return temp;

    }
}
