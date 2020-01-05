/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amz;

/**
 *
 * @author Dotmons
 */
class GCD
{
    public int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE
        int resultSet = arr[0];
        
        for (int i=1; i<num; i++){
            resultSet = gcdValue(arr[i], resultSet);
            
            if (resultSet ==1){
                return 1;
            }
        }
        return resultSet;
    }
    // METHOD SIGNATURE ENDS
    
    public int gcdValue(int arr, int n){
        return (arr==0)? n : gcdValue(n%arr, arr);
    }
	
}