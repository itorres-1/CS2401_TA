package Lab2;
/**
* Tanabe, Maria
* Lab1
* Dr. Julio Cesar Urenda
* Isaac Torres
* 6/27/2017
* Manipulating Matrices
*/
public class Tanabe2{

  //TODO Please consider using intelliJ as you are senselessly losing points for code indention,
  //TODO Javadoc comments misnamed, compile errors, etc.

/**
* This method called sum takes two 2D arrays and returns their summation.
* @param intA This is the first paramter to sum method.
* @param intB This is the second paramter to sum method.
* @return int This returns the sum of A and B.
*/
public static int [][] sum(int[][] A, int[][] B){
  int rows = A.length;
  int columns = A[0].length;
  int[][] C = new int [rows][columns];
  for (int i = 0; i < rows; i++){
      for (int j = 0; j < columns; j++){
           C[i][j] = A[i][j] + B[i][j];
      }
  }
  return C;
}
/**
* This method called difference takes two 2D arrays and returns their difference.
* @param intA This is the first paramter to difference method.
* @param intB This is the second paramter to difference method.
* @return int This returns the difference of A and B.
*/
public static int [][] difference(int[][] A, int[][] B){
  int rows = A.length;
  int columns = A[0].length;
  int[][] C = new int [rows][columns];
  for (int i = 0; i < rows; i++){
       for (int j = 0; j < columns; j++){
         C [i][j] = A[i][j] - B[i][j];
       }
  }
  return C;
}
/**
* This method called intMultiplication takes one 2D arrays and one integer and returns the product.
* @param intA This is the first paramter to intMultiplication method.
* @param B This is the second paramter to intMultiplication method.
* @return int This returns the product of A and B.
*/public static int [][] intMultiplication(int[][] A, int B){
  int rows = A.length;
  int columns = A[0].length;
  int [][] C = new int [rows][columns];
  for (int i = 0; i < rows; i++){
       for (int j = 0; j < columns; j++){
         C [i][j] = (A[i][j] * B);
       }
  }
  return C;
}
/**
* This method called matrixProduct takes two 2D arrays and returns their product.
* @param intA This is the first paramter to matrixProduct method.
* @param intB This is the second paramter to matrixProductmethod.
* @return int This returns the difference of A and B.
*/
public static int [][] matrixProduct(int[][] A, int [][]B){
  try{
    if (A[0].length != B.length) throw new Exception("Dimensions don't match");
    int [][] C = new int[A.length][B[0].length];
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B[0].length; j++) {
        for (int k = 0; k < A[0].length; k++) {
          C[i][j] += A[i][k] * B[k][j];
        }
      }
    }
    return C;
  } catch (Exception e) {
    return null;
  }
}
/**
* This method called tanspose transforms a matrix by turning all of the rows into columns and vice-versa.
* @param int A This is the only paramter of this method
* @return returns a new double array
*/
public static int [][] transpose(int [][] A){
  int rows = A.length;
  int columns = A[0].length;
  int[][] C = new int[columns][rows];
  for(int i = 0; i < columns; i++){
    for(int j = 0; j < rows; j++){
      C[i][j] = A[j][i];
    }
  }
  return C;
}
/**
* This method called isSmmetric checks if a matrix is symmetrical.
* @param int A is the only 2D array taken as a parameter
* @return returns true or false
*/
public static Boolean isSymmetric (int[][] A){
  for( int row=0; row < A.length; row++ ){
    for( int col=0; col < row; col++ ){
      if( A[row][col] != A[col][row] ){
        return false;
      }
    }
  }
return true;
}

public static int[][] pow(int[][] A, int k){
  int[][] missing = {{0}};
  return missing;
}
}
