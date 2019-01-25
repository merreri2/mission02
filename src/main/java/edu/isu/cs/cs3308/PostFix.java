package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.LinkedStack;

import static java.lang.Integer.parseInt;

/**
 * Postfix expression evaluator.
 *
 * @author Isaac Griffith
 */
public class PostFix {

    /**
     * Evaluates the provided postfix expression and returns the answer. If the
     * provided string is null, empty, or only contains whitespace then return
     * 0;
     *
     * @param postfix A string representing an postfix notation expression where
     * each item is separated by a space.
     * @return value of the postfix express or 0 if the postfix expression is null,
     * empty, or contains only whitespace.
     */
    public static int evalPostFix(String infix) {
        //throw new UnsupportedOperationException("Not supported yet.");
        //Create an empty stack
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        //if string is null return 0
        if (infix == null || infix.trim().isEmpty()){
            return 0;
        }
        else {
            //Create a string array to hold infix split by ' '
            String [] tempArray = infix.split(" ");
            int temp = 0;
            //Iterate through the tempArray
            for(int count = 0; count < tempArray.length; count++){
                //check if the string at index count is equal to one of the arithmetic operators
                //if it isn't we know the contents of the string is an integer, so we parse it to an int and push it onto the stack
                if (!tempArray[count].equals("+") && !tempArray[count].equals("-") && !tempArray[count].equals("*") && !tempArray[count].equals("/")){
                    stack.push(parseInt(tempArray[count]));
                }
                else if (tempArray[count].equals("+")){
                    isNull(stack.peek());
                    int temp1 = stack.pop();
                    isNull(stack.peek());
                    int temp2 = stack.pop();
                    temp = temp2 + temp1;
                    stack.push(temp);
                }
                else if (tempArray[count].equals("-")){
                    isNull(stack.peek());
                    int temp1 = stack.pop();
                    isNull(stack.peek());
                    int temp2 = stack.pop();
                    temp = temp2 - temp1;
                    stack.push(temp);
                }
                else if (tempArray[count].equals("*")){
                    isNull(stack.peek());
                    int temp1 = stack.pop();
                    isNull(stack.peek());
                    int temp2 = stack.pop();
                    temp = temp2 * temp1;
                    stack.push(temp);
                }
                else if (tempArray[count].equals("/")){
                    isNull(stack.peek());
                    int temp1 = stack.pop();
                    isNull(stack.peek());
                    int temp2 = stack.pop();
                    temp = temp2 / temp1;
                    stack.push(temp);
                }

                //write another method to check each int poping off the stack to make sure the stack has an int on it, if not, throw the required exception

            }
            return stack.peek();
        }


    }

    private static void isNull(Integer toCheck) throws IllegalArgumentException{
        if (toCheck == null){
            throw new IllegalArgumentException();
        }
    }

        }
