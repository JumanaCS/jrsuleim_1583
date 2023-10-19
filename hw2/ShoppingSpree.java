import java.util.Scanner;
import java.util.Random;

public class ShoppingSpree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Declare all needed variables 
        double money = 1000.0;
        double firstItem = 10.0;
        int amountBought1 = 0;
        double secondItem = 22.5;
        int amountBought2 = 0;
        double thirdItem = 14.6;
        int amountBought3 = 0;
        double total = 0;
        boolean keepShopping = true; //keeps track of user's choice to stop shopping
        int totalBought = 0; //for bonus 1

        Random rdm = new Random();

        while (keepShopping == true) { //loop to keep shopping, leaves loop if the user chooses option 4
            System.out.printf("Buy 9 items, get the 10th half off%nYou have %d left till discount%n",9-totalBought);
            if (totalBought == 9) { //bonus one, if it is the 10th item, discounted half off
                System.out.println("your discount is active, your next item is half off."); 
            }
            System.out.printf("Type the number of options you would like%nYou currently have $%f%n", money);
            System.out.println("1.) item ($" + firstItem + ") or negotiate");
            System.out.println("2.) item ($" + secondItem + ") or negotiate");
            System.out.println("3.) item ($" + thirdItem + ") or negotiate");
            System.out.println("4.) Complete Order");
            System.out.println("Negotiation prices are permenent if I get angry");

            int userChoice = input.nextInt(); //asks for the user's choice of price

            boolean negotiate = false; //aks the user if they want the negotiate in the first place
            boolean gobackToMainMenu = false; 
            if (userChoice == 1) { 
                double currentItemPrice = firstItem;
                System.out.println("Do you want to negotiate, yes or no?");
                String yesOrNo = input.next();
                if(yesOrNo.equals( "yes")){ //goes into if statment if the user says yes 
                    negotiate = true;
                }
                else //if no, continues with normal prices
                    negotiate = false;
                if(negotiate == true){ //for negoatiating  
                    boolean acceptPrice = false;
                    boolean angry = false; 
                    while(acceptPrice == false){
                        if(angry == true){
                            currentItemPrice *= 2;
                            firstItem = currentItemPrice;
                            System.out.printf("I am angry the price now is $%f%n",currentItemPrice);
                            System.out.println("Do you want to take this price or go back to the old menu?");
                            System.out.println("1.) take it");
                            System.out.println("2.) stop negotiating and go back to origianl menu");
                            int negotiatingChoice = input.nextInt();
                            if(negotiatingChoice == 2){ //stops negotiating, leaves the loop/breaks it
                                gobackToMainMenu = true;
                                break;
                            }
                            else if(negotiatingChoice == 1){ 
                                break;
                            }
                        }
                        else { 
                            System.out.println("what price do you want?");
                            double userPrice =  input.nextDouble();
                            acceptPrice = rdm.nextBoolean();
                            if(acceptPrice == true){
                                System.out.println("I will take the price");
                                currentItemPrice = userPrice;
                            }
                            
                        }
                        angry = rdm.nextBoolean(); //randomly gets angry
                        if (angry == false){ //if I'm not angry, allows the user to try again and give a price
                            System.out.println("Try again");
                        }
                    }
                }
                if (gobackToMainMenu == false){
                    if (totalBought == 9) {
                        if (money - (currentItemPrice / 2) <= 0) {
                            keepShopping = false;
                        } else {
                            amountBought1++;
                            money -= (currentItemPrice / 2);
                            totalBought = 0;
                        }
                    } else {
                        if (money - currentItemPrice <= 0) {
                            keepShopping = false;
                        }

                        else {
                            amountBought1++;
                            money -= currentItemPrice;
                            totalBought++;
                        }
                    }
                }
                
            } 

            else if (userChoice == 2) { // same process as the first item choice
                double currentItemPrice = secondItem;
                System.out.println("Do you want to negotiate, yes or no?");
                String yesOrNo = input.next();
                if(yesOrNo.equals( "yes")){
                    negotiate = true;
                }
                else 
                    negotiate = false;
                if(negotiate == true){  
                    boolean acceptPrice = false; 
                    boolean angry = false;
                    while(acceptPrice == false){
                        if(angry == true){
                            currentItemPrice *= 2;
                            secondItem = currentItemPrice;
                            System.out.printf("I am angry the price now is $%f%n",currentItemPrice);
                            System.out.println("Do you want to take this price or go back to the old menu?");
                            System.out.println("1.) take it");
                            System.out.println("2.) stop negotiating and go back to origianl menu");
                            int negotiatingChoice = input.nextInt();
                            if(negotiatingChoice == 2){
                                gobackToMainMenu = true;
                                break;
                            }
                            else if(negotiatingChoice == 1){
                                break;
                            }
                        }
                        else {
                            System.out.println("what price do you want?");
                            double userPrice =  input.nextDouble();
                            acceptPrice = rdm.nextBoolean();
                            if(acceptPrice == true){
                                System.out.println("I will take the price");
                                currentItemPrice = userPrice;
                            }
                        }
                        angry = rdm.nextBoolean();
                        if (angry == false){
                            System.out.println("Try again");
                        }
                    }
                }
                if (gobackToMainMenu == false){
                    if (totalBought == 9) {
                        if (money - (currentItemPrice / 2) <= 0) {
                            keepShopping = false;
                        } else {
                            amountBought2++;
                            money -= (currentItemPrice / 2);
                            totalBought = 0;
                        }
                    } else {
                        if (money - currentItemPrice <= 0) {
                            keepShopping = false;
                        } else {
                            amountBought2++;
                            money -= currentItemPrice;
                            totalBought++;
                        }
                    }
                }
            } 

            else if (userChoice == 3) { // same process as the other items
              double currentItemPrice = thirdItem;
              System.out.println("Do you want to negotiate, yes or no?");
              String yesOrNo = input.next();
              if(yesOrNo.equals( "yes")){
                negotiate = true;
            }
            else 
                negotiate = false;
            if(negotiate == true){  
                boolean acceptPrice = false; 
                boolean angry = false;
                while(acceptPrice == false){
                    if(angry == true){
                        currentItemPrice *= 2;
                        thirdItem = currentItemPrice;
                        System.out.printf("I am angry the price now is $%f%n",currentItemPrice);
                        System.out.println("Do you want to take this price or go back to the old menu?");
                        System.out.println("1.) take it");
                        System.out.println("2.) stop negotiating and go back to origianl menu");
                        int negotiatingChoice = input.nextInt();
                        if(negotiatingChoice == 2){
                            gobackToMainMenu = true;
                            break;
                        }
                        else if(negotiatingChoice == 1){
                            break;
                        }
                    }
                    else {
                        System.out.println("what price do you want?");
                        double userPrice =  input.nextDouble();
                        acceptPrice = rdm.nextBoolean();
                        if(acceptPrice == true){
                            System.out.println("I will take the price");
                            currentItemPrice = userPrice;
                            break;
                        }

                    }
                    angry = rdm.nextBoolean();
                    if (angry == false){
                        System.out.println("Try again");
                    }
                }
            }
            if (gobackToMainMenu == false){
                if (totalBought == 9) {
                    if (money - (currentItemPrice / 2) <= 0) {
                        keepShopping = false;
                    } else {
                        amountBought3++;
                        money -= (currentItemPrice / 2);
                        totalBought = 0;
                    }
                } else {
                    if (money - currentItemPrice <= 0) {
                        keepShopping = false;
                    } else {
                        amountBought3++;
                        money -= currentItemPrice;
                        totalBought++;
                    }
                }
            } 
        }
        else if (userChoice == 4) { //whne the user is done shopping leaves the loop
            keepShopping = false;
        }

    }

    System.out.println("Thank you for shopping with us!"); //thanks the user 
    System.out.printf("You have purchased item one %d times%n", amountBought1);
    System.out.printf("You have purchased item two %d times%n", amountBought2);
    System.out.printf("You have purchased item three %d times%n", amountBought3);
    System.out.printf("You have $%f%n", money);
    System.out.println("Goodbye"); //goodbye
}
}