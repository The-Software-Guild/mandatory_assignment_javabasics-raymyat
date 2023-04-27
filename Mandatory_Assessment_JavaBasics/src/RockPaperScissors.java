/*
 * Each player chooses Rock, Paper, or Scissors.
 * If both players choose the same thing, the round is a tie.
 * Otherwise:
 * 		Paper [2] wraps Rock [1] to win
 * 		Scissors [3] cut Paper [2] to win
 * 		Rock [1] breaks Scissors [3] to win
 * */
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	public static void main(String[] args) {
		
		boolean gameRun = true;
		
		while(gameRun) {
			
			int maxRound = 10, minRound = 1;
			String[] option = {"Rock","Paper","Scissors"};
			int numOfTies = 0 , userWins = 0 , compWins = 0 ;
			int compChoice, userChoice;
			String currRoundWinner, finalWinner;
			Random random = new Random();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number of rounds (Min 1 - Max 10)");
			int numOfRound = sc.nextInt();
			
			// user asks for something outside this range, 
			// the program prints an error message and quits.
			if(numOfRound < minRound || numOfRound > maxRound) {
				System.out.println("You have enter invalid number.");
				System.out.println("Game exit");
				System.exit(0);
			}
			
			//program plays the number of rounds.
			//1 = Rock, 2 = Paper, 3 = Scissors
			for(int i = 1; i <= numOfRound; i++) {
				System.out.println("Round " + i);
				//get user choice and computer choice
				System.out.println("Enter your choice (1 = Rock, 2 = Paper, 3 = Scissors)");
				userChoice = sc.nextInt();
				while(userChoice > 3 || userChoice == 0) {
					System.out.println("Enter 1 - 3 number only");
					System.out.println("1 = Rock, 2 = Paper, 3 = Scissors");
					userChoice = sc.nextInt();
				}
				//(max - min + 1) + min 
				compChoice = random.nextInt(3 - 1 + 1) + 1;
				
				currRoundWinner = getWinner(userChoice, compChoice);
				//print current round details
				System.out.println("User picked " + option[userChoice - 1]);
				System.out.println("Computer picked " + option[compChoice - 1]);
				System.out.println("Round " + i + " winner: " + currRoundWinner);
				System.out.println("======================================");
				
				//keep track of how many rounds are ties, user wins, or computer wins
				if(currRoundWinner == "User")
					userWins += 1;
				else if(currRoundWinner == "Computer")
					compWins += 1;
				else
					numOfTies += 1;
				
			}
			//get final winner
			if(userWins > compWins) 
				finalWinner = "User";
			else if(compWins > userWins) 
				finalWinner = "Computer";
			else
				finalWinner = "No Winner";
			
			//print overall results
			System.out.println("Result: ");
			System.out.println("Number of user wins: " + userWins );
			System.out.println("Number of computer win: " + compWins );
			System.out.println("Number of ties: " + numOfTies);
			System.out.println("======================================");
			System.out.println("Overall Winner: " + finalWinner );
			System.out.println("======================================");
			
			//ask user if he/she wants to play again
			System.out.println("Would you like to play again? [Yes, No]");
			String userInput = sc.next().toLowerCase();
			if(userInput.equals("no")) {
				gameRun = false;
				System.out.println("Thanks for playing!");
			}
		}
	
		
		
	}
	/*
	 * Paper [2] wraps Rock [1] to win
	 * Scissors [3] cut Paper [2] to win
	 * Rock [1] breaks Scissors [3] to win
	 * */
	public static String getWinner(int userChoice, int compChoice) {
		String winner = "";
		if(userChoice == compChoice) {
			winner = "Ties";
		}else {
			//user selected rock
			if(userChoice == 1) {
				if(compChoice == 3)
					winner = "User";
				else
					winner = "Computer";
			}else if(userChoice == 2) {
				if(compChoice == 1)
					winner = "User";
				else
					winner = "Computer";
				
			}else { //userChoice == 3
				if(compChoice == 2)
					winner = "User";
				else
					winner = "Computer";
			}
		}
		return winner;
	}
	
	

}
