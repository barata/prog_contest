import java.util.StringTokenizer;
import java.util.Vector;


class Main {

	static String readLn() {
        String newLine = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        int car = -1;
        try {
            car = System.in.read();
            while ((car > 0) && (car != newLine.charAt(0))) {
                buffer.append((char)car);
                car = System.in.read();
            }
            if (car == newLine.charAt(0))
            System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null);}
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }
	
	static void sort(Vector vector) {
	    for (int i = 1; i < vector.size(); i++) {
	        for (int j = vector.size() - 1; j >= i; j--) {
	        	Comparable c1 = (Comparable) vector.elementAt(j - 1);
	        	Comparable c2 = (Comparable) vector.elementAt(j);

	            if (c1.compareTo(c2) > 0) {
	                vector.setElementAt(c1, j);
	                vector.setElementAt(c2, j - 1);
	            }
	        }
	    }
	}

	public static void main(String[] args) {
		String line = readLn();
		
		while (line != null) {
			Hand player1 = new Hand();
			Hand player2 = new Hand();
			
			StringTokenizer tks = new StringTokenizer(line);
			
			for (int i = 0; i < 5; i++) {
				player1.addCard(tks.nextToken());
			}
			for (int i = 0; i < 5; i++) {
				player2.addCard(tks.nextToken());
			}
			
			sort(player1.cards);
			sort(player2.cards);
			
			if (player1.compareTo(player2) > 0) System.out.println("Black wins.");
			else if (player1.compareTo(player2) < 0) System.out.println("White wins.");
			else System.out.println("Tie.");
			
			
			
			line = readLn();
		}
	}

}

class Hand implements Comparable {
	public Vector cards;
	
	public Hand() {
		this.cards = new Vector();
	}
	
	public void addCard(String value) {
		this.cards.addElement(new Card(value));
	}
	
	public boolean hasStraightFlush() {
		return this.hasStraight() && this.hasFlush();
	}
	
	public boolean hasFourOfAKind() {
		int[] freq = new int[15];
		
		for (int i = 0; i < this.cards.size(); i++) {
			int currentValue = ((Card) this.cards.elementAt(i)).value;
			freq[currentValue]++;
		}
		
		for (int i = Card.TWO; i <= Card.ACE; i++) {
			if (freq[i] >= 4) return true;
		}
		return false;
	}
	
	public boolean hasFullHouse() {
		int[] freq = new int[15];
		
		for (int i = 0; i < this.cards.size(); i++) {
			int currentValue = ((Card) this.cards.elementAt(i)).value;
			freq[currentValue]++;
		}
		
		boolean foundTwo = false;
		boolean foundThree = false;
		for (int i = Card.TWO; i <= Card.ACE; i++) {
			if (freq[i] == 2) foundTwo = true;
			else if (freq[i] == 3) foundThree = true;
		}
		return foundTwo && foundThree;
	}
	
	public boolean hasFlush() {
		char previousSuit = ((Card) this.cards.elementAt(0)).suit;
		for (int i = 1; i < this.cards.size(); i++) {
			char currentSuit = ((Card) this.cards.elementAt(i)).suit;
			if (currentSuit != previousSuit) return false;
		}
		return true;
	}
	
	public boolean hasStraight() {
		int previousValue = ((Card) this.cards.elementAt(0)).value;
		
		for (int i = 1; i < this.cards.size(); i++) {
			int currentValue = ((Card) this.cards.elementAt(i)).value;
			
			if (currentValue - previousValue != 1) return false;
			previousValue = currentValue;
		}
		
		return true;
	}
	
	public boolean hasThreeOfAKind() {
		int[] freq = new int[15];
		
		for (int i = 0; i < this.cards.size(); i++) {
			int currentValue = ((Card) this.cards.elementAt(i)).value;
			freq[currentValue]++;
		}
		
		for (int i = Card.TWO; i <= Card.ACE; i++) {
			if (freq[i] >= 3) return true;
		}
		return false;
	}
	
	public boolean hasTwoPairs() {
		int[] freq = new int[15];
		
		for (int i = 0; i < this.cards.size(); i++) {
			int currentValue = ((Card) this.cards.elementAt(i)).value;
			freq[currentValue]++;
		}
		
		int countPairs = 0;
		for (int i = Card.TWO; i <= Card.ACE; i++) {
			if (freq[i] == 2) countPairs++;
		}
		return countPairs == 2;
	}
	
	public int hasPair() {
		int[] freq = new int[15];
		
		for (int i = 0; i < this.cards.size(); i++) {
			int currentValue = ((Card) this.cards.elementAt(i)).value;
			freq[currentValue]++;
		}
		
		for (int i = Card.TWO; i <= Card.ACE; i++) {
			if (freq[i] == 2) return i;
		}
		return -1;
	}

	public int compareTo(Object o) {
		Hand other = (Hand) o;
		
		// check "Straight flush"
		if (this.hasStraightFlush() && !other.hasStraightFlush()) {
			return 1;
		}
		if (!this.hasStraightFlush() && other.hasStraightFlush()) {
			return -1;
		}
		if (this.hasStraightFlush() && other.hasStraightFlush()) {
			int thisHighestCard = ((Card) this.cards.elementAt(this.cards.size() - 1)).value;
			int otherHighestCard = ((Card) other.cards.elementAt(this.cards.size() - 1)).value;
			return thisHighestCard - otherHighestCard;
		}
		
		// check "Four of a kind"
		if (this.hasFourOfAKind() && !other.hasFourOfAKind()) {
			return 1;
		}
		if (!this.hasFourOfAKind() && other.hasFourOfAKind()) {
			return -1;
		}
		if (this.hasFourOfAKind() && other.hasFourOfAKind()) {
			int thisMiddleCard = ((Card) this.cards.elementAt(this.cards.size() / 2)).value;
			int otherMiddleCard = ((Card) other.cards.elementAt(this.cards.size() / 2)).value;
			
			return thisMiddleCard - otherMiddleCard;
		}
		
		// check "Full House"
		if (this.hasFullHouse() && !other.hasFullHouse()) {
			return 1;
		}
		if (!this.hasFullHouse() && other.hasFullHouse()) {
			return -1;
		}
		if (this.hasFullHouse() && other.hasFullHouse()) {
			int thisMiddleCard = ((Card) this.cards.elementAt(this.cards.size() / 2)).value;
			int otherMiddleCard = ((Card) other.cards.elementAt(this.cards.size() / 2)).value;
			
			return thisMiddleCard - otherMiddleCard;
		}
		
		// check "Flush"
		if (this.hasFlush() && !other.hasFlush()) {
			return 1;
		}
		if (!this.hasFlush() && other.hasFlush()) {
			return -1;
		}
		if (this.hasFlush() && other.hasFlush()) {
			for (int i = this.cards.size() - 1; i >= 0; i--) {
				int thisCurrentCard = ((Card) this.cards.elementAt(i)).value;
				int otherCurrentCard = ((Card) other.cards.elementAt(i)).value;
				
				if (thisCurrentCard != otherCurrentCard) return thisCurrentCard - otherCurrentCard;
			}
			return 0;
		}
		
		// check "Straight"
		if (this.hasStraight() && !other.hasStraight()) {
			return 1;
		}
		if (!this.hasStraight() && other.hasStraight()) {
			return -1;
		}
		if (this.hasStraight() && other.hasStraight()) {
			int thisHighestCard = ((Card) this.cards.elementAt(this.cards.size() - 1)).value;
			int otherHighestCard = ((Card) other.cards.elementAt(this.cards.size() - 1)).value;
			return thisHighestCard - otherHighestCard;
		}
		
		// check "Three of a Kind"
		if (this.hasThreeOfAKind() && !other.hasThreeOfAKind()) {
			return 1;
		}
		if (!this.hasThreeOfAKind() && other.hasThreeOfAKind()) {
			return -1;
		}
		if (this.hasThreeOfAKind() && other.hasThreeOfAKind()) {
			int thisMiddleCard = ((Card) this.cards.elementAt(this.cards.size() / 2)).value;
			int otherMiddleCard = ((Card) other.cards.elementAt(this.cards.size() / 2)).value;
			
			return thisMiddleCard - otherMiddleCard;
		}
		
		// check "Two Pairs"
		if (this.hasTwoPairs() && !other.hasTwoPairs()) {
			return 1;
		}
		if (!this.hasTwoPairs() && other.hasTwoPairs()) {
			return -1;
		}
		if (this.hasTwoPairs() && other.hasTwoPairs()) {
			int thisHighestPair = ((Card) this.cards.elementAt(this.cards.size() - 2)).value;
			int otherHighestPair = ((Card) other.cards.elementAt(this.cards.size() - 2)).value;
			if (thisHighestPair != otherHighestPair) return thisHighestPair - otherHighestPair;
			
			int thisLowestPair = ((Card) this.cards.elementAt(1)).value;
			int otherLowestPair = ((Card) other.cards.elementAt(1)).value;
			if (thisHighestPair != otherHighestPair) return thisLowestPair - otherLowestPair;
			
			int thisUniqueCard;
			if (((Card) this.cards.elementAt(0)).value !=  ((Card) this.cards.elementAt(1)).value) thisUniqueCard =  ((Card) this.cards.elementAt(0)).value;
			else if (((Card) this.cards.elementAt(this.cards.size() - 2)).value !=  ((Card) this.cards.elementAt(this.cards.size() - 1)).value) thisUniqueCard =  ((Card) this.cards.elementAt(this.cards.size() - 1)).value;
			else thisUniqueCard = ((Card) this.cards.elementAt(this.cards.size() / 2)).value;
			int otherUniqueCard;
			if (((Card) other.cards.elementAt(0)).value !=  ((Card) other.cards.elementAt(1)).value) otherUniqueCard =  ((Card) other.cards.elementAt(0)).value;
			else if (((Card) other.cards.elementAt(other.cards.size() - 2)).value !=  ((Card) other.cards.elementAt(other.cards.size() - 1)).value) otherUniqueCard =  ((Card) other.cards.elementAt(other.cards.size() - 1)).value;
			else otherUniqueCard = ((Card) other.cards.elementAt(other.cards.size() / 2)).value;
			
			return thisUniqueCard - otherUniqueCard;
		}
		
		// check "Pair"
		if (this.hasPair() > 0 && other.hasPair() < 0) {
			return 1;
		}
		if (this.hasPair() < 0 && other.hasPair() > 0) {
			return -1;
		}
		if (this.hasPair() > 0 && other.hasPair() > 0) {
			int thisCard = this.hasPair();
			int otherCard = other.hasPair();
			
			if (thisCard != otherCard) return thisCard - otherCard;
			
			Vector thisCardsVector = new Vector();
			for (int i = 0; i < this.cards.size(); i++) {
				thisCardsVector.addElement(this.cards.elementAt(i));
			}
			for (int i = 0; i < thisCardsVector.size(); i++) {
				int currentCard = ((Card) thisCardsVector.elementAt(i)).value;
				if (currentCard == thisCard) {
					thisCardsVector.removeElementAt(i);
					i--;
				}
			}
			
			Vector otherCardsVector = new Vector();
			for (int i = 0; i < other.cards.size(); i++) {
				otherCardsVector.addElement(other.cards.elementAt(i));
			}
			for (int i = 0; i < otherCardsVector.size(); i++) {
				int currentCard = ((Card) otherCardsVector.elementAt(i)).value;
				if (currentCard == otherCard) {
					otherCardsVector.removeElementAt(i);
					i--;
				}
			}
			
			for (int i = thisCardsVector.size() - 1; i >= 0; i--) {
				int thisCurrentCard = ((Card) thisCardsVector.elementAt(i)).value;
				int otherCurrentCard = ((Card) otherCardsVector.elementAt(i)).value;
				
				if (thisCurrentCard != otherCurrentCard) return thisCurrentCard - otherCurrentCard;
			}
			return 0;
		}
		
		// check "High Card"
		for (int i = this.cards.size() - 1; i >= 0; i--) {
			int thisCurrentCard = ((Card) this.cards.elementAt(i)).value;
			int otherCurrentCard = ((Card) other.cards.elementAt(i)).value;
			
			if (thisCurrentCard != otherCurrentCard) return thisCurrentCard - otherCurrentCard;
		}
		
		return 0;
	}
	
}

class Card implements Comparable {
	public static int TWO = 2;
	public static int THREE = 3;
	public static int FOUR = 4;
	public static int FIVE = 5;
	public static int SIX = 6;
	public static int SEVEN = 7;
	public static int EIGHT = 8;
	public static int NINE = 9;
	public static int TEN = 10;
	public static int JACK = 11;
	public static int QUEEN = 12;
	public static int KING = 13;
	public static int ACE = 14;
	
	public int value;
	public char suit;
	
	public Card(String description) {
		char c = description.charAt(0);
		switch (c) {
			case '2': this.value = TWO; break;
			case '3': this.value = THREE; break;
			case '4': this.value = FOUR; break;
			case '5': this.value = FIVE; break;
			case '6': this.value = SIX; break;
			case '7': this.value = SEVEN; break;
			case '8': this.value = EIGHT; break;
			case '9': this.value = NINE; break;
			case 'T': this.value = TEN; break;
			case 'J': this.value = JACK; break;
			case 'Q': this.value = QUEEN; break;
			case 'K': this.value = KING; break;
			case 'A': this.value = ACE; break;
		}
		this.suit = description.charAt(1);
	}

	public int compareTo(Object o) {
		Card other = (Card) o;
		return this.value - other.value;
	}
	
}