import java.util.*;
public class non_fractional_knapsack{
    static int[][] table;
    public static int max(int x,int y){
        return x>y?x:y;
    }
    public static int  knapsack_solve(int[] weight,int[] value,int index,int capacity){
        if(capacity==0||index==0)
        return 0;
        if(weight[index]>capacity){
            return knapsack_solve(weight,value,index-1,capacity);
        }
        if(table[index-1][capacity]==0)
        table[index-1][capacity]=knapsack_solve(weight,value,index-1,capacity);
        int exclude=table[index-1][capacity];
        if(table[index-1][capacity-weight[index]]==0)
        table[index-1][capacity-weight[index]]=knapsack_solve(weight, value, index-1, capacity-weight[index]);
        int include=table[index-1][capacity-weight[index]]+value[index];
        return max(exclude,include);
        
    }
    public static void main(String args[]) {
        // Dummy input
        int[] value = { 60,100,120};
        int[] weight = { 10,20,30};
        int capacity = 50;
        table=new int[value.length+1][capacity+1];
        // Number of items
        int n = weight.length;

        // Solve the knapsack problem
        int maxValue = knapsack_solve(weight, value, n-1, capacity);

        // Print the result
        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}