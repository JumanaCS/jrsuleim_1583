import java.util.Scanner;
import java.util.ArrayList;

public class VirtualPet {

    static final int LOW_STAT_THRESHOLD = 5;  //good
    static final int MED_STAT_THRESHOLD = 10; //okay
    static final int HIGH_STAT_THRESHOLD = 15; //bad
    static final int RUNAWAY_STAT_THRESHOLD = 20; //gamee ending bad

    static String name;
    static int age;
    static int currentHunger;
    static int currentDirty;
    static int currentBoredom;
    static int hungerRate;
    static int dirtyRate;
    static int boredomRate;
    //doesn't return anything
    public static void createPet(){
        System.out.println("A mysterious egg hatches before you!");
        System.out.println("What will you name this creature?");

        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        age = 0;
        currentHunger = 2;
        currentDirty = 2;
        currentBoredom = 0;

        hungerRate = 1;
        dirtyRate = 1;
        boredomRate = 1;
    }

    public static void increaseAge(){
        age++;
        System.out.println("******BIRTHDAY UPDATE!******");
        System.out.printf("%s is now %d days old!%n", name, age);
        if(age % 2 == 0){
            hungerRate++;
            System.out.printf("%s gets hungrier faster!%n", name);
        }
        if(age % 3 == 0){
            dirtyRate++;
            System.out.printf("%s gets dirtier faster!%n", name);
        }
        if(age % 5 == 0){
            boredomRate++;
            System.out.printf("%s gets bored faster!%n", name);
        }
    }

    public static void play(){
        Scanner input = new Scanner(System.in);
        System.out.println("1.) Feed");
        System.out.println("2.) Clean");
        System.out.println("3.) Play");
        System.out.printf("What would you like to do with %s?%n", name);
        int choice = input.nextInt();

        if(choice == 1){
            feedingPet();
        }
        else if(choice == 2){
            cleaningPet();
        }
        else if(choice == 3){
            playingPet();
        }

    }

    public static void feedingPet(){
        currentHunger -= hungerRate;
        currentDirty += dirtyRate;
        System.out.printf("You fed %s and it made a mess.%n", name);
    }

    public static void cleaningPet(){
        currentDirty -= dirtyRate;
        System.out.printf("%s is now cleaner.%n", name);
    }

    public static void playingPet(){
        currentBoredom -= boredomRate;
        currentDirty += dirtyRate;
        currentHunger += hungerRate;
        System.out.printf("%s is now less bored, but it's dirtier and hungrier.%n", name);
    }

    public static void petStat(){
        String hungerLevel = checkLevel(currentHunger);
        String dirtyLevel = checkLevel(currentDirty);
        String boredomLevel = checkLevel(currentBoredom);
        System.out.println("******CURRENT STATS******");
        System.out.printf("Hunger Level: %s%n", hungerLevel);
        System.out.printf("Cleanliness Level: %s%n", dirtyLevel);
        System.out.printf("Boredom Level: %s%n", boredomLevel);

    }
        
    public static String checkLevel(int currentLevel){
        String prettyGoodLevel = "pretty good";
        String okLevel = "sublime";
        String badLevel = "bad";
        String horribleLevel = "Extremely horrible.";

        if(currentLevel <= LOW_STAT_THRESHOLD){
            return prettyGoodLevel;
        }
        if(currentLevel <= MED_STAT_THRESHOLD){
            return okLevel;
        }
        if(currentLevel < HIGH_STAT_THRESHOLD){
            return badLevel;
        }
        else {
            return horribleLevel;
        }
    }

    public static boolean checkRanaway(){
        if(currentHunger >= RUNAWAY_STAT_THRESHOLD){
            System.out.println("Your pet was too hungry, it ran away.");
            return true;
        }
        if(currentDirty >= RUNAWAY_STAT_THRESHOLD){
            System.out.println("Your pet was too dirty, it ran away.");
            return true;
        }
        if(currentBoredom >= RUNAWAY_STAT_THRESHOLD){
            System.out.println("Your pet was too bored, it ran away.");
            return true;
        }
        return false;
    }

    public static void playerPerformance(){
        System.out.printf("You took care of %s for %d days!%n", name, age);
        if(age < 5){
            System.out.println("Do better next time.");
        }
        else if(age <= 15){
            System.out.println("Congrats on being a good pet owner.");
        }
        else if(age <= 25){
            System.out.println("Great! You're a great pet owner.");
        }
        else{
            System.out.println("You're ready for a real pet!");
        }
    }

    public static boolean replay(){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to play again");
        System.out.println("1.) yes");
        System.out.println("2.) no");
        int choices = input.nextInt();
        if(choices == 1){
            return true;
        }
        else 
            return false;
    }
   
    public static void main(String[] args) {
        ArrayList<String> pets = new ArrayList<String>();
        createPet();
        boolean ranaway = false;
        while(ranaway == false){
            increaseAge();
            play();
            petStat();
            ranaway = checkRanaway();
            if(ranaway == true){
                String pet =  String.format("%s\t%d days",name,age);
                pets.add(pet);
                playerPerformance();
                boolean playerWantsToPlay = replay();
                if(playerWantsToPlay == true){
                    createPet();
                    ranaway = false;
                }
            }
        }

        System.out.println("Your Pets:");
        for(int i = 0; i < pets.size(); i++){
            System.out.println(pets.get(i));
        }
    }
}