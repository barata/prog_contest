import java.util.Enumeration;
import java.util.Hashtable;
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
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }

	public static void main(String[] args) {
		int n = Integer.parseInt(readLn());
		
		for (int cases = 0; cases < n; cases++) {
			String tournamentName = readLn();
			int numberOfTeams = Integer.parseInt(readLn());
			Hashtable teams = new Hashtable(numberOfTeams);
			
			for (int i = 0; i < numberOfTeams; i++) {
				String teamName = readLn();
				teams.put(teamName, new Team(teamName));
			}
			
			
			
			int numberOfGames = Integer.parseInt(readLn());
			
			for (int i = 0; i < numberOfGames; i++) {
				StringTokenizer tks = new StringTokenizer(readLn(), "#");
				
				String team1name = tks.nextToken();
				String score = tks.nextToken();
				String team2name = tks.nextToken();
				
				Team team1 = (Team) teams.get(team1name);
				Team team2 = (Team) teams.get(team2name);
				
				int index = score.indexOf("@");
				int team1score = Integer.parseInt(score.substring(0, index));
				int team2score = Integer.parseInt(score.substring(index + 1));
				
				team1.goalsScored += team1score;
				team1.goalsAgainst += team2score;
				team2.goalsScored += team2score;
				team2.goalsAgainst += team1score;
				
				if (team1score > team2score) {
					team1.wins++;
					team2.losses++;
				} else if (team2score > team1score) {
					team1.losses++;
					team2.wins++;
				} else {
					team1.ties++;
					team2.ties++;
				}
			}
			
			Vector list = new Vector(numberOfTeams);
			
			Enumeration e = teams.elements();
			while (e.hasMoreElements()) {
				Team t = (Team) e.nextElement();
				list.addElement(t);
			}
			
			ordena(list);
			
			System.out.println(tournamentName);
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println((i + 1) + ") " + list.elementAt(i));
			}
			
			if (cases < n - 1) System.out.println();
		}
	}

	static void ordena(Vector lista) {
		for (int i = 1; i < lista.size(); i++) {
			for (int j = lista.size() - 1; j >= i; j--) {
				Team team1 = (Team) lista.elementAt(j - 1);
				Team team2 = (Team) lista.elementAt(j);
				
				if (team1.compareTo(team2) > 0) {
					lista.setElementAt(team2, j - 1);
					lista.setElementAt(team1, j);
				}
			}
		}
	}

}

class Team {
	
	public String teamName;
	public int wins, ties, losses;
	public int goalsScored, goalsAgainst;

	public Team(String teamName) {
		this.teamName = teamName;
		this.wins = 0;
		this.ties = 0;
		this.losses = 0;
		this.goalsScored = 0;
		this.goalsAgainst = 0;
	}
	
	public int compareTo(Team team) {
		if (this.getTotalPoints() != team.getTotalPoints()) {
			return team.getTotalPoints() - this.getTotalPoints();
		}
		
		if (this.wins != team.wins) {
			return team.wins - this.wins;
		}
		
		if (this.getGoalDifference() != team.getGoalDifference()) {
			return team.getGoalDifference() - this.getGoalDifference();
		}
		
		if (this.goalsScored != team.goalsScored) {
			return team.goalsScored - this.goalsScored;
		}
		
		if (this.getNumberOfGames() != team.getNumberOfGames()) {
			return this.getNumberOfGames() - team.getNumberOfGames();
		}
		
		return this.teamName.toLowerCase().compareTo(team.teamName.toLowerCase());
	}
	
	public int getTotalPoints() {
		return this.wins * 3 + this.ties;
	}
	
	public int getNumberOfGames() {
		return this.wins + this.ties + this.losses;
	}
	
	public int getGoalDifference() {
		return this.goalsScored - this.goalsAgainst;
	}

	public String toString() {
		return this.teamName + " " + this.getTotalPoints() + "p, " + this.getNumberOfGames() + "g ("
			+ this.wins + "-" + this.ties + "-" + this.losses + "), " + this.getGoalDifference() + "gd ("
			+ this.goalsScored + "-" + this.goalsAgainst + ")";
	}

}