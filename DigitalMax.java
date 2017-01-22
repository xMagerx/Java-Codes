package javacodes;

import java.util.*;

public class DigitalMax {
    
    public static void main(String[] agrs)
    {
        Scanner in=new Scanner(System.in);
        
        System.out.println("Enter a number :");
        
        int n=in.nextInt();
        
        int temp=0,a;
        
        
        int[] arr={8,9,8,9,9,9,8,9,8,9};
        
        while(n>0)
            
        {
            a=n%10;
            
            temp=temp*10+arr[a];
            
            n=n/10;
        }
        int ans=0;
        
        while(temp>0)
        {
            a=temp%10;
            
            ans=ans*10+a;
            
            temp=temp/10;
        }
        System.out.println("Maximum no:"+" "+ans);
    }
}
