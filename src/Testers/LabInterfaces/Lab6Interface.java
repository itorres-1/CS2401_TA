package Testers.LabInterfaces;

/**
 * Author: Isaac Torres
 * Date: 7/20/17.
 * Course: CS 2401 Elementary Data Structures
 */

/**
 * An interface to ensure that the everyone in the class
 * adheres to the exact same method signature(s) thus ensuring
 * code compatibility with the TA's code.
 */
public interface Lab6Interface {
    /**
     * A method that given a string containing any natural number N
     * or the characters: +, −, ∗, /, ∧, representing a postfix expression
     * where operands and operations are separated by spaces, computes and
     * returns the result using a list-based implementation.
     * @param str the string representing the postfix expression.
     * @return the result of the postfix expression, otherwise null
     * if the expression cannot be computed.
     */
    public Double listPrefixCalc(String str);
    /**
     * A method that given a string containing any natural number N
     * or the characters: +, −, ∗, /, ∧, representing a postfix expression
     * where operands and operations are separated by spaces, computes and
     * returns the result using a array-based implementation.
     * @param str the string representing the postfix expression.
     * @return the result of the postfix expression, otherwise null
     * if the expression cannot be computed.
     */
    public Double arrayPrefixCalc(String str);
}
