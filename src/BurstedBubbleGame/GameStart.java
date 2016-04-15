package BurstedBubbleGame;

public class GameStart {

	public static void main(String[] args) {
		
			Game newGame = new Game();
			newGame.display();
			
			System.out.println();
			
			newGame.burst(2, 2);
			newGame.display();
			System.out.println();
			
			newGame.gravity();
			newGame.display();
			System.out.println();
			
			
		

	}

}
