
package javacodes;

import java.util.*;

public class ProduConsum{
    
    public static void main(String []args)throws InterruptedException
            
    {
        Queue q=new Queue();
        
        Producer p=new Producer(q);
        
        Consumer c=new Consumer(q);
        
        Thread pt=new Thread(p);
        
        Thread ct=new Thread(c);
        
        pt.start();
        
        ct.start();
        
        pt.join();
        
        ct.join();
        
        System.out.println("Existing main Thread");
    }
}
class Producer implements Runnable
{
    Queue queue;
    
    Producer(Queue queue)
    {
        this.queue=queue;
        
        
    }
    public void run()
    {
        int i=0;
        
        while(i<=20)
        {
            queue.set(i);
            
            i++;
        }
        System.out.println("Existing Producer Thread");
        
        queue.producerAlive=false;
    }
}
class Consumer implements Runnable
{
    Queue queue;
    
    Consumer(Queue queue)
    {
        this.queue=queue;
    }
    public void run()
    {
        while(queue.producerAlive)
        {
            queue.get();
        }
        System.out.println("Existing Consumer Thread");
    }
}
class Queue
{
    int n=0;
    
    boolean valueset=false;
    
    boolean producerAlive=true;
    
    synchronized void get()
    {
        if(!valueset)
        {
            try {
                wait();
                
            } catch (InterruptedException e) {
                
                System.out.println("Error");
            }
        }
        valueset=false;
        
        System.out.println("Got"+" "+this.n);
        
        notify();
    }
    synchronized void set(int n)
    {
        if(valueset)
        {
            try {
                
                wait();
                
            } catch (InterruptedException e) {
                
                System.out.println("Value set");
            }
        }
        this.n=n;
        
        valueset=true;
        
        notify();
    }
}