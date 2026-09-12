package string.assigment_problems;

import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public boolean isDraftable() {
        return isDraftable(matchesPlayed) || isDraftable(matchesPlayed, injured);
    }

    public double getFantasyPoints() {
        return battingAverage + (matchesPlayed * 0.5);
    }

    @Override
    public int compareTo(Player other) {
        if (this.isDraftable() && !other.isDraftable()) {
            return -1;
        }

        if (!this.isDraftable() && other.isDraftable()) {
            return 1;
        }

        return Double.compare(other.getFantasyPoints(), this.getFantasyPoints());
    }
}

public class FantasyLeagueAutoDraftRankingEngine {

    static String draftAndRank(Player[] players) {
        Arrays.sort(players);

        StringBuilder result = new StringBuilder();
        int rank = 1;

        for (Player player : players) {
            if (player.isDraftable()) {
                if (result.length() > 0) {
                    result.append(" | ");
                }

                result.append(rank)
                      .append(". ")
                      .append(player.getName());

                rank++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}