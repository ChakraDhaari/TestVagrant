import java.io.*;
import java.util.*;

class IPL {
    static class Team {
        String teamName;
        int points;
        boolean results[] = new boolean[5];

        Team(String teamName, int points, boolean results[]) {
            this.teamName = teamName;
            this.points = points;
            this.results = results.clone();
        }

       //small data structure that holds details - Name of the team, points they have earned and result of last 5 matches as per image given

        boolean consecutiveLoss(int num) {
            int maxCon = 0;
            int max = 0;
            for (int i = 0; i < this.results.length; i++) {
                if (!this.results[i]) {
                    maxCon++;
                    if (maxCon > max) {
                        max = maxCon;
                    }
                } else {
                    maxCon = 0;
                }
            }
            if (max >= num) {
                return true;
            }
            return false;
        }

        boolean consecutiveWins(int num) {
            int maxCon = 0;
            int max = 0;
            for (int i = 0; i < this.results.length; i++) {
                if (this.results[i]) {
                    maxCon++;
                    if (maxCon > max) {
                        max = maxCon;
                    }
                } else {
                    maxCon = 0;
                }
            }
            if (max >= num) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.teamName + " " + this.points;
        }

    }

    public static void main(String arga[]) {
        Scanner sc = new Scanner(System.in);
        Team teams[] = new Team[10];
        boolean res0[] = { true, true, false, false, true };
        teams[0] = new Team("GT", 20, res0);
        boolean res1[] = { true, false, false, true, true };
        teams[1] = new Team("LSG", 18, res1);
        boolean res2[] = { true, false, true, false, false };
        teams[2] = new Team("RR", 16, res2);
        boolean res3[] = { true, true, false, true, false };
        teams[3] = new Team("DC", 14, res3);
        boolean res4[] = { false, true, true, false, false };
        teams[4] = new Team("RCB", 14, res4);
        boolean res5[] = { false, true, true, false, true };
        teams[5] = new Team("KKR", 12, res5);
        boolean res6[] = { false, true, false, true, false };
        teams[6] = new Team("PBKS", 12, res6);
        boolean res7[] = { true, false, false, false, false };
        teams[7] = new Team("SRH", 12, res7);
        boolean res8[] = { false, false, true, false, true };
        teams[8] = new Team("CSK", 8, res8);
        boolean res9[] = { false, true, false, true, true };
        teams[9] = new Team("MI", 6, res9);

       //retrieve the teams that have 2 consecutive losses.

        int pointSum = 0;
        System.out.println("Consecutive 2 Loss");

        int c = 0;
        for (Team i : teams) {
            if (i.consecutiveLoss(2)) {
                System.out.println(i);
                pointSum += i.points;
                c++;
            }
        }
        if (c > 0) {
            System.out.println("Average Score : " + (pointSum / c));
        }

       //teams that have n consecutive losses/wins.

        while (true) {
            int ch;
            System.out.println("FILTERS\n1.Get Consecutive Losses\n2.Get Consecutive Wins\n0.EXIT\nEnter Choice : ");
            ch = sc.nextInt();
            if (ch == 0) {
                break;
            }
            if (ch == 1) {
                System.out.println("Enter no. of consecutive losses : ");
                int n = sc.nextInt();
                int sum = 0;
                System.out.println("Consecutive " + n + " losses :");
                int count = 0;
                for (Team i : teams) {
                    if (i.consecutiveLoss(n)) {
                        System.out.println(i);
                        sum += i.points;
                        count++;
                    }
                }
                if (count > 0) {
                    System.out.println("Average Score : " + (sum / count));
                }
            } else if (ch == 2) {
                System.out.println("Enter no. of consecutive wins : ");
                int n = sc.nextInt();
                int sum = 0;
                System.out.println("Consecutive " + n + " wins :");
                int count = 0;
                for (Team i : teams) {
                    if (i.consecutiveWins(n)) {
                        System.out.println(i);
                        sum += i.points;
                        count++;
                    }
                }
   

               //average points of these filtered teams

                if (count > 0) {
                    System.out.println("Average Score : " + (sum / count));
                }

            } else {
                continue;
            }
        }

    }
}