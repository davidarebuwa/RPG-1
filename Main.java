package project1;

import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
        //System objects
		Scanner in = new Scanner(System.in);
		Random rnd = new Random();
		
		//Game variables
		String[] enemies = {"Skeleton","Zombie","Warrior","Assasin"};
		int maxEnemyHealth = 100;
		int damage = 25;
		
		//Player variables
		int health = 100;
		int playerDamage = 50;
		int healthPots = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 40;
		
		boolean running = true;
		
		System.out.println("Welcome to the Jungle");
		
		GAME:
		while(running) {
			System.out.println("-------------------------------------------------------------"); //for formatting purposes
			int enemyHealth = rnd.nextInt(maxEnemyHealth);
			String enemy  = enemies[rnd.nextInt(enemies.length)];
			System.out.println("\t# " + "enemy" + "has appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Atatck");
				System.out.println("\t2. Drink health potion");
				System.out.println("t3. Run!");
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int damageDealt = rnd.nextInt(playerDamage);
					int damageTaken = rnd.nextInt(damage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You struck the " + enemy + "for" +  damageDealt + "damage");
					System.out.println("\t> You recieved " + damageTaken + "in relation!");
					
					if(health < 1){
						System.out.println("\t> You have taken too much damage, you are too weak to go on");
						break;
					}
				}
				if(input.equals("2")) {
					if(healthPots >0){
						health += healthPotionHealAmount;
						healthPots--;
						System.out.println("\t> You drank a health potion, healing yourself for " + healthPots + "\b\t> You now have" + health + "HP." + "\n\t> You have " + healthPots + "health potions left.\n");
					}
				}
						else{
							System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get more potions");
						}
					}
			}
			if(in.equals("3")) {
				System.out.println("\t> You ran away from the" + enemies + "!" );
				continue GAME;
			}
				else{
					System.out.println("\t. Invalid command!");
				}
				if(health < 1){
					System.out.println("You limp out of jungle, weak from battle");
					break;
				}
					System.out.println("------------------------------------------------"); 
					System.out.println(" # " + enemies + "was defeated!");
					System.out.println(" # You have " + health + " HP left. #");
					if(rnd.nextInt(100) < healthPotionDropChance) {
						healthPots++;
						System.out.println(" # The " + enemies + "dropped a health potion! # ");
						System.out.println(" # You now have" + healthPots + "health potion(s)");
					
				}
					System.out.println("------------------------------------------------"); 
					System.out.println("What would you like to do now?");
					System.out.println("1. Continue fighting?");
					System.out.println("2. Exit jungle");
					
					String input = in.nextLine();
					while(!input.equals("1") && !input.equals("2")) {
						System.out.println("Invalid command");
						input = in.nextLine();
						
						
					}
					
					if(input.equals("1")) {
						System.out.println("You continue on your adventure!");
					}
					
					if(input.equals("2")) {
						System.out.print("You exit the dungeon, successful from your adventures");
						break;
					}
					System.out.println("###################");
					System.out.println("# Thanks for playing#");
					System.out.println("###################");
					
					
				
					
			
		
		
}

}