import java.util.Scanner ;
import java.util.ArrayList;
class Game
{
       Scanner sc=new Scanner(System.in);


       int game[]={1,2,3,4,5,6,7,8,9,10} ;   //for the games;
       String days[]={"Monday" ,"Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};  //for days
       String day,ga;   // To compare day
       int balance;      //for balance
       boolean flag=true;
       int ID;

       Game(int balance,String day,int ID)   // constructor for initializing
      {
          this.day=day;
          this.balance=balance;
          this.ID=ID;
      }

      void input()
     {
         System.out.println("From Where You Want to start ( G1 or G10 ) ");
         ga=sc.nextLine();
      }

     int checkday()   // It will check the day and retuns day position
    {
        int res=0;
        for(int i=0;i<days.length;i++)
        {
            if(days[i].equals(day))
            {
                res=i;
                break;
            }
            
        }
       return res;
    }

      int checkgame()
     {
          int g=0;
            if(ga.equals("G1") || ga.equals("g1"))
              {
                      flag=true;
                      g=1;
               }
               else //if(ga.equals("G10"))
                      {
	       flag=false;
                           g=10;
                       }
             return g;

     }   
     void playgame()     // It will mainly focous on if the balance is less than charge then user must add balance otherwise he can't play game
     {
        
            int d=checkday();  //index postition of that particular day
            int charge;   //game occurs charge
            int g=checkgame();     //For game Count;
            char ch ; //for more game or not
            int amount;
           
         do{
            if(d<=4)   
            {
                 charge=10;    // For week days
            } 
            else
           {
                charge=20;    // For weekend days
            }
             
             do{	
                 if(charge >balance)    // if balance is less than charge
               {
                    System.out.println("Insufficient Balance :  Do U want to add more Balance (y/n)");
                    char c=sc.next().charAt(0);
                    if(c=='y' || c=='Y')
                   {
                           System.out.println("Enter The Amount");   // For Extra Amount adding
                           amount=sc.nextInt();
                           balance+=amount;
                   }
                   else
                  {
                         
	      System.out.println("You can't Play More ");
                         break;
                   }
               }
               else {
                          balance=balance-charge;   // deduction of charge from balance
                         System.out.println("WELCOME TO THE GAME : G"+g+ "  Charge :-  "+charge);

	    System.out.println("Enjoy Your Game :):):) ");
                        System.out.println("Remaining Balance : "+balance);
                       }
                   }while(charge>balance);
	System.out.println("Do U want to Play More Game ");
                    ch=sc.next().charAt(0);
                    if(flag==true)
                   {   
                         g++;   //for how many game
                    }
                    else //if(flag=false)
                            {
 		g--;
                             }
                   
            }while( (g<=10 && g>0) && (ch=='y' || ch=='Y')  );

      }   
}


class HelpNow
{

    public static void main(String [] s)
   {
      Scanner sc=new Scanner(System.in);
      String day;
      char ans;
      int i=1;
      int balance;
      int ID;
     
       Game g1[]=new Game[10];  // We are taking 10 users initially
       

      do{
                
                System.out.println("Welcome In FunFactory : ");
                System.out.println("Please Add Day &Your Card Details (i.e Balance )  & User iD");
                sc.next();    //It taking input mismatch while adding new User
                day=sc.nextLine();
              
                  balance=sc.nextInt();
                 ID=sc.nextInt();
                 if(balance<10)   // If balance is less than 10;
                    break;
                //Game g1=new Game(day,b);
                g1[ID]=( new Game(balance,day,ID));
              
             

                g1[ID].input();
                g1[ID].playgame();

                 System.out.println("Do Want to check Balance : Add your iD");
                char c=sc.next().charAt(0);
                 if(c=='y'|| c=='Y')
                {
                   try{
                      System.out.println("Add Your User ID : ");
                    int u=sc.nextInt();
                   int rem=g1[u].balance;
                   System.out.println("Your Reamining Balance "+rem);
                    }
                      catch (Exception e)   // If user id did not exsist
                     {
	     System.out.println(e+" User Not Exsist");
                       }
                }
                  
               

                System.out.println("Do u want more To Play  : ");
                ans=sc.next().charAt(0);
              }while(ans=='y' || ans=='Y');
      

     }
}
      
