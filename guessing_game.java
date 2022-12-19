import java.util.Random;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String[] spellingWords = { "Nauseous", "Dilate", "Fuchsia", "Minuscule", "Ingenious", "Sacrilegious",
				"Orangutan", "Paraphernalia", "Epitome", "Slough" };

		String prompt = "Type a letter to complete the spelling of ";

//		User input
		String input;
//		Let's add a counter
		int count = 3; // The user has 3 tries to guess
		
		int min = 0;
		int max = spellingWords.length - 1;

		String randomWord = spellingWords[randInt(min, max)];

		max = randomWord.length() - 1;
		int randomInt = randInt(min, max);

		String replacedWord = randomWord.replaceFirst("" + randomWord.charAt(randomInt), "_");

		System.out.println(prompt + replacedWord);
		while(count > 0) {
			input = scnr.next();
			char convert = input.charAt(0);
			if(convert == randomWord.toLowerCase().charAt(randomInt)) {
				System.out.println(randomWord + "\nAwesome! You did it!");
				break;
			}
			if(count > 1){				
				System.out.println("Try again");
			}
			count--;
		}
		if(count == 0) {
			System.out.println("The answer was " + randomWord);
		}

	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		
		return rand.nextInt(max - min + 1) + min;
	}
	
}