package javacodes;

import java.util.Scanner;

public class TicTacToe {
    
    public static void main(String args[])
    {
        int flag=0;
        
        Scanner in=new Scanner(System.in);
        
        System.out.println("Enter name\nPlayer 1 :");
        
        String name1=in.nextLine();
        
        System.out.println("Player 2 :");
        
        String name2=in.nextLine();
        
        char[][] m=new char[3][3];Setm(m);
        
        
        int r,c,count=0,u=1;
        
        while(count<=9)
        {
            if(count==9)
                
                break;
            
            RefPos(u);
            
            r=in.nextInt();
            
            c=in.nextInt();
            
            if(m[r][c]!=' ')
                
                continue;
            
            count++;
            
            if(u==1)
            {
                m[r][c]='0';
                
                u=2;Printm(m);
            }
            else if(u==2)
            {
                m[r][c]='x';
                
                u=1;Printm(m);
            }
            if(count>=5)
            {
              flag=Check(m);
              
              if(flag>0)
              {
                  if(u==1)
                      
                  {System.out.println("\nPlayer 2 : "+name2+", Won!!");return;}
                  
                  else
                      
                  {System.out.println("\nPlayer 1 : "+name1+", Won!!");return;}
              }
            }
        }
        System.out.println("\nMatch Drawn - Tie!!");
    }
    public static int Check(char[][] m)
    {   
        
        for(int i=0;i<3;i++)
        {
            if((m[i][0]==m[i][1])&&(m[i][0]==m[i][2])&&(m[i][1]==m[i][2])&&(m[i][0]==m[i][2])&&m[i][0]!=' ')
                
                return 1;
            
            if((m[0][i]==m[1][i])&&(m[0][i]==m[2][i])&&(m[1][i]==m[2][i])&&(m[i][0]==m[2][i])&&m[0][i]!=' ')
                
                return 2;
        }
          if((m[0][0]==m[1][1])&&(m[0][0]==m[2][2])&&(m[1][1]==m[2][2])&&(m[0][0]==m[2][2])&&m[0][0]!=' ')
              
                return 3;
          
        if((m[2][0]==m[1][1])&&(m[2][0]==m[0][2])&&(m[1][1]==m[0][2])&&(m[2][0]==m[1][1])&&m[2][0]!=' ')
            
                return 4;
        return 0;
    }
    public static void Printm(char[][] m)
    {
        System.out.println("\n\n\n\n\n");
        
        for(int i=0;i<3;++i)
            
        {   
            System.out.print("\t\t\t");
            
            for(int j=0;j<3;j++)
            {
                System.out.print(m[i][j]);
                
                if(j!=2)
                    
                    System.out.print(" | ");
            }
            if(i!=2)
                
                System.out.println("\n\t\t\t__|___|___");
        }
    }
    public static void Setm(char[][] m)
    {
        for(int i=0;i<3;++i)
        {
            for(int j=0;j<3;++j)
            {
                m[i][j]=' ';
            }
        }
    }
    public static void RefPos(int u)
    {
        //System.out.println("\nReference Position:\n");
        
        //System.out.println("(0,0) | (0,1)  | (0,2)");
        
        //System.out.println("______|________|______");
        
        //System.out.println("(1,0) | (1,1)  | (1,2)");
        
        //System.out.println("______|________|______");
        
        //System.out.println("(2,0) | (2,1)  | (2,2)");
        
        System.out.println("Player "+u+", Enter values:");       
    }
}
