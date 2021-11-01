package week7;

import java.util.Scanner;

public class PlayCrazyEights {
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final double NUM_SUITS = 4;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final double CARDS_PER_SUIT = 13;
    private static final String SINGLEPOINTS = "A2345679";
    private static final String DOUBLEPOINTS = "JQK";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playerHand = "", c1Hand = "", c2Hand = "", topCard = "",
                c1Hand1 = "XX XX XX XX XX", c2Hand2 = "XX XX XX XX XX";
        int c1Number = 1, c2Number = 2, playerPoints = 0, c1Points = 0, c2Points = 0, player = 0;
        for (int i = 0; i < 5; i++) {
            playerHand+= getCard() + " ";
         c1Hand += getCard() + " ";
          c2Hand += getCard() + " ";
        }
        topCard += getCard();
        while (topCard.substring(0, 1).equals("8")) {
            topCard = getCard();
        }
        System.out.println("Player Hand: " + playerHand);
        System.out.println("Computer 1 Hand: " + c1Hand1);
        System.out.println("Computer 2 Hand: " + c2Hand2);
        System.out.println("Top Card: " + topCard);

        // repeats the game until the game is over and sets playerHand, c1Hand, c2Hand,
        // topCard, playerPoints, c1Points, and c2Points to their new values respectively
        while (!gameOver(playerPoints, c1Points, c2Points)) {
            String tempP = "", tempC1H = "", tempC2H = "";
            String temp = player(playerHand, topCard, c1Hand, c1Hand1, c2Hand, c2Hand2, c1Number, c2Number, player, in);
            int dash = temp.indexOf("-");
            playerHand = temp.substring(0, dash);
            topCard = temp.substring(dash + 1);
            String temp1 = points(playerHand, c1Hand, c2Hand, playerPoints, c1Points, c2Points);
            int dash1P = temp1.indexOf("-");
            int dash2P = temp1.lastIndexOf("-");
            playerPoints += Integer.parseInt(temp1.substring(0, dash1P));
            c1Points += Integer.parseInt(temp1.substring(dash1P + 1, dash2P));
            c2Points += Integer.parseInt(temp1.substring(dash2P + 1));
            // checks to see if the round is over, prints who wins, and their scores
            if (playerHand.length() == 0 || c1Hand.length() == 0 || c2Hand.length() == 0) {
                if (playerHand.length() == 0) {
                    System.out.println("Player wins this round!");
                } else if (c1Hand.length() == 0) {
                    System.out.println("Computer 1 wins this round!");
                } else if (c2Hand.length() == 0) {
                    System.out.println("Computer 2 wins this round!");
                }
                System.out.println("Player points: " + playerPoints);
                System.out.println("Computer 1 points: " + c1Points);
                System.out.println("Computer 2 points: " + c2Points);
                // gets new hands
                for (int i = 0; i < 5; i++) {
                    tempP += getCard() + " ";
                    tempC1H += getCard() + " ";
                    tempC2H += getCard() + " ";
                }
                playerHand = tempP;
                c1Hand = tempC1H;
                c2Hand = tempC2H;
                c1Hand1 = "XX XX XX XX XX";
                c2Hand2 = "XX XX XX XX XX";
                // plays new round
                System.out.println("------------------------");
                System.out.println("New Round");
                System.out.println("Player Hand: " + playerHand);
                System.out.println("Computer 1 Hand: " + c1Hand1);
                System.out.println("Computer 2 Hand: " + c2Hand2);
                System.out.println("Top Card: " + topCard);
            }
            String tempC1 = playComputer(c1Hand, topCard, c1Hand1, c2Hand, c2Hand2, playerHand, c2Hand, c1Number,
                    c1Number, c2Number, player, in);
            int dashC1 = tempC1.indexOf("-");
            int dash2C1 = tempC1.lastIndexOf("-");
            c1Hand = tempC1.substring(0, dashC1);
            topCard = tempC1.substring(dashC1 + 1, dash2C1);
            c1Hand1 = tempC1.substring(dash2C1 + 1);
            String temp2 = points(playerHand, c1Hand, c2Hand, playerPoints, c1Points, c2Points);
            int dash1P1 = temp2.indexOf("-");
            int dash2P2 = temp2.lastIndexOf("-");
            playerPoints += Integer.parseInt(temp1.substring(0, dash1P1));
            c1Points += Integer.parseInt(temp1.substring(dash1P1 + 1, dash2P2));
            c2Points += Integer.parseInt(temp1.substring(dash2P2 + 1));
            // checks to see if the round is over, prints who wins, and their scores
            if (playerHand.length() == 0 || c1Hand.length() == 0 || c2Hand.length() == 0) {
                if (playerHand.length() == 0) {
                    System.out.println("Player wins this round!");
                } else if (c1Hand.length() == 0) {
                    System.out.println("Computer 1 wins this round!");
                } else if (c2Hand.length() == 0) {
                    System.out.println("Computer 2 wins this round!");
                }
                System.out.println("Player points: " + playerPoints);
                System.out.println("Computer 1 points: " + c1Points);
                System.out.println("Computer 2 points: " + c2Points);
                // gets new hands
                for (int i = 0; i < 5; i++) {
                    tempP += getCard() + " ";
                    tempC1H += getCard() + " ";
                    tempC2H += getCard() + " ";
                }
                playerHand = tempP;
                c1Hand = tempC1H;
                c2Hand = tempC2H;
                c1Hand1 = "XX XX XX XX XX";
                c2Hand2 = "XX XX XX XX XX";
                // plays new round
                System.out.println("------------------------");
                System.out.println("New Round");
                System.out.println("Player Hand: " + playerHand);
                System.out.println("Computer 1 Hand: " + c1Hand1);
                System.out.println("Computer 2 Hand: " + c2Hand2);
                System.out.println("Top Card: " + topCard);
            }
            String tempC2 = playComputer(c2Hand, topCard, c2Hand2, c1Hand, c1Hand1, playerHand, c1Hand, c2Number,
                    c1Number, c2Number, player, in);
            int dashC2 = tempC2.indexOf("-");
            int dash2C2 = tempC2.lastIndexOf("-");
            c2Hand = tempC2.substring(0, dashC2);
            topCard = tempC2.substring(dashC2 + 1, dash2C2);
            c2Hand2 = tempC2.substring(dash2C2 + 1);
            String temp3 = points(playerHand, c1Hand, c2Hand, playerPoints, c1Points, c2Points);
            int dash1P3 = temp3.indexOf("-");
            int dash2P3 = temp3.lastIndexOf("-");
            playerPoints += Integer.parseInt(temp1.substring(0, dash1P3));
            c1Points += Integer.parseInt(temp1.substring(dash1P3 + 1, dash2P3));
            c2Points += Integer.parseInt(temp1.substring(dash2P3 + 1));
            // checks to see if the round is over, prints who wins, and their scores
            if (playerHand.length() == 0 || c1Hand.length() == 0 || c2Hand.length() == 0) {
                if (playerHand.length() == 0) {
                    System.out.println("Player wins this round!");
                } else if (c1Hand.length() == 0) {
                    System.out.println("Computer 1 wins this round!");
                } else if (c2Hand.length() == 0) {
                    System.out.println("Computer 2 wins this round!");
                }
                System.out.println("Player points: " + playerPoints);
                System.out.println("Computer 1 points: " + c1Points);
                System.out.println("Computer 2 points: " + c2Points);
                // gets new hands
                for (int i = 0; i < 5; i++) {
                    tempP += getCard() + " ";
                    tempC1H += getCard() + " ";
                    tempC2H += getCard() + " ";
                }
                playerHand = tempP;
                c1Hand = tempC1H;
                c2Hand = tempC2H;
                c1Hand1 = "XX XX XX XX XX";
                c2Hand2 = "XX XX XX XX XX";
                // plays new round
                System.out.println("------------------------");
                System.out.println("New Round");
                System.out.println("Player Hand: " + playerHand);
                System.out.println("Computer 1 Hand: " + c1Hand1);
                System.out.println("Computer 2 Hand: " + c2Hand2);
                System.out.println("Top Card: " + topCard);
            }
        } // if the game is over, states who wins
        if (gameOver(playerPoints, c1Points, c2Points)) {
            if (playerPoints < c1Points && playerPoints < c2Points) {
                System.out.println("Player Wins!");
            } else if (c1Points < playerPoints && c1Points < c2Points) {
                System.out.println("Computer 1 Wins! ");
            } else if (c2Points < playerPoints && c2Points < c1Points) {
                System.out.println("Coputer 2 Wins");
            } else {
                System.out.println("Tie");
            }
        }
    }

    // checks and returns if the game is over
    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return (playerPoints >= 100 || c1Points >= 100 || c2Points >= 100);
    }

    // calculates and returns the points
    private static String points(String playerHand, String c1Hand, String c2Hand, int playerPoints, int c1Points,
            int c2Points) {
        String card = "";
        int tempPlayer = playerPoints;
        int tempC1 = c1Points;
        int tempC2 = c2Points;
        if (playerHand.length() == 0 || c1Hand.length() == 0 || c2Hand.length() == 0) {
            // if playerHand's length is bigger than 0, calculates its points
            while (playerHand.length() > 0) {
                int space = playerHand.indexOf(" ");
                card = playerHand.substring(0, space);
                if (card.indexOf("8") >= 0) {
                    tempPlayer += 50;
                } else if (card.substring(0, 1).equals("A") || card.substring(0, 1).equals("2")
                        || card.substring(0, 1).equals("3") || card.substring(0, 1).equals("4")
                        || card.substring(0, 1).equals("5") || card.substring(0, 1).equals("6")
                        || card.substring(0, 1).equals("7") || card.substring(0, 1).equals("9")) {
                    if (card.indexOf(SINGLEPOINTS.substring(SINGLEPOINTS.indexOf(card.substring(0, card.length() - 1)),
                            SINGLEPOINTS.indexOf(card.substring(0, card.length() - 1)) + 1)) >= 0) {
                        if (card.substring(0, 1).equals("A")) {
                            tempPlayer += 1;
                        } else {
                            tempPlayer += Integer.parseInt(card.substring(0, card.length() - 1));
                        }
                    }
                } else if (card.substring(0, 2).equals("10")) {
                    tempPlayer += 10;
                } else if (card
                        .indexOf(DOUBLEPOINTS.substring(DOUBLEPOINTS.indexOf(card.substring(0, card.length() - 1)),
                                DOUBLEPOINTS.indexOf(card.substring(0, card.length() - 1)) + 1)) >= 0) {
                    tempPlayer += 10;
                }
                playerHand = playerHand.substring(space + 1);
            }
            // if c1Hand's length is bigger than 0, calculates its points
            while (c1Hand.length() > 0) {
                int space = c1Hand.indexOf(" ");
                card = c1Hand.substring(0, space);
                if (card.indexOf("8") >= 0) {
                    tempC1 += 50;
                } else if (card.substring(0, 1).equals("A") || card.substring(0, 1).equals("2")
                        || card.substring(0, 1).equals("3") || card.substring(0, 1).equals("4")
                        || card.substring(0, 1).equals("5") || card.substring(0, 1).equals("6")
                        || card.substring(0, 1).equals("7") || card.substring(0, 1).equals("9")) {
                    if (card.indexOf(SINGLEPOINTS.substring(SINGLEPOINTS.indexOf(card.substring(0, card.length() - 1)),
                            SINGLEPOINTS.indexOf(card.substring(0, card.length() - 1)) + 1)) >= 0) {
                        if (card.substring(0, 1).equals("A")) {
                            tempC1 += 1;
                        } else {
                            tempC1 += Integer.parseInt(card.substring(0, card.length() - 1));
                        }
                    }
                } else if (card.substring(0, 2).equals("10")) {
                    tempC1 += 10;
                } else if (card
                        .indexOf(DOUBLEPOINTS.substring(DOUBLEPOINTS.indexOf(card.substring(0, card.length() - 1)),
                                DOUBLEPOINTS.indexOf(card.substring(0, card.length() - 1)) + 1)) >= 0) {
                    tempC1 += 10;
                }
                c1Hand = c1Hand.substring(space + 1);
            }
            // if c2Hand's length is bigger than 0, calculates its points
            while (c2Hand.length() > 0) {
                int space = c2Hand.indexOf(" ");
                card = c2Hand.substring(0, space);
                if (card.indexOf("8") >= 0) {
                    tempC2 += 50;
                } else if (card.substring(0, 1).equals("A") || card.substring(0, 1).equals("2")
                        || card.substring(0, 1).equals("3") || card.substring(0, 1).equals("4")
                        || card.substring(0, 1).equals("5") || card.substring(0, 1).equals("6")
                        || card.substring(0, 1).equals("7") || card.substring(0, 1).equals("9")) {
                    if (card.indexOf(SINGLEPOINTS.substring(SINGLEPOINTS.indexOf(card.substring(0, card.length() - 1)),
                            SINGLEPOINTS.indexOf(card.substring(0, card.length() - 1)) + 1)) >= 0) {
                        if (card.substring(0, 1).equals("A")) {
                            tempC2 += 1;
                        } else {
                            tempC2 += Integer.parseInt(card.substring(0, card.length() - 1));
                        }
                    }
                } else if (card.substring(0, 2).equals("10")) {
                    tempC2 += 10;
                } else if (card
                        .indexOf(DOUBLEPOINTS.substring(DOUBLEPOINTS.indexOf(card.substring(0, card.length() - 1)),
                                DOUBLEPOINTS.indexOf(card.substring(0, card.length() - 1)) + 1)) >= 0) {
                    tempC2 += 10;
                }
                c2Hand = c2Hand.substring(space + 1);
            }
        }
        return tempPlayer + "-" + tempC1 + "-" + tempC2;
    }

    // checks to see if the player can play, returns the new playerHand and topCard
    private static String player(String playerHand, String topCard, String c1Hand, String c1Hand1, String c2Hand,
            String c2Hand2, int c1Number, int c2Number, int player, Scanner in) {
        int numDraws = 0;
        // if the player can't play, draws cards
        while (!canPlay(playerHand, topCard) && numDraws < 5) {
            String card = getCard();
            System.out.println("You can't play, draw a card: [" + card + "]");
            playerHand += card + " ";
            System.out.println("Player Hand: " + playerHand);
            System.out.println("Top Card: " + topCard);
            numDraws++;
        }
        // if the player can't play and 5 cards have been drawn, move on to the next player
        if (!canPlay(playerHand, topCard) && numDraws > 5) {
            System.out.println("You have drawn 5 times and can't play, moving on to computer");
            playComputer(c1Hand, topCard, c1Hand1, c2Hand, c2Hand2, playerHand, c2Hand, c1Number, c1Number, c2Number,
                    player, in);
            return playerHand + "-" + topCard;
            // if the player can play, goes through the playCard method
        } else if (canPlay(playerHand, topCard) && numDraws < 5) {
            String temp = playCard(playerHand, topCard, in);
            return temp;
        } else {
            return playerHand + "-" + topCard;
        }
    }

    // checks to see if the computer can play - does rule 4, then rule 1, rule 2, an
    // rule 3 - returns the computer's new hand, the topCard, and the amount of X's
    // that are displayed
    private static String playComputer(String c1Hand, String topCard, String c1Hand1, String c2Hand, String c2Hand2,
            String oppHand1, String oppHand2, int number, int c1Number, int c2Number, int player, Scanner in) {
        System.out.println("Computer " + number + " is thinking... ");
        String temp = c1Hand;
        String tempCard = "";
        String newHand = "";
        int numDraws = 0;
        String cardNow = "";
        // sees if the computer has to draw cards
        while (!canPlay(c1Hand, topCard) && numDraws < 5) {
            if (numDraws == 0) {
                cardNow = getCard();
                System.out.println("Computer " + number + " drew [" + cardNow + "]");
                c1Hand += cardNow;
                temp = c1Hand;
                c1Hand1 += " " + "XX";
                numDraws++;
            } else {
                cardNow = getCard();
                System.out.println("Computer " + number + " drew [" + cardNow + "]");
                c1Hand += " " + cardNow;
                temp = c1Hand;
                c1Hand1 += " " + "XX";
                numDraws++;
            }
        }
        // if computer has drawn 5 times, moves on to the next person
        if (!canPlay(c1Hand, topCard) && numDraws == 5) {
            System.out.println("Moving on to next player");
            return c1Hand + "-" + topCard + "-" + c1Hand1;
        } else {
            // checks for rule 4
            if ((oppHand1.length() <= 3 || oppHand2.length() <= 3)
                    && (oppHand1.length() != 0 && oppHand2.length() != 0)) {
                oppHand1 = oppHand1.trim();
                oppHand2 = oppHand2.trim();
                boolean validInput = false;
                c1Hand = temp;
                while (c1Hand.length() > 0 && !validInput) {
                    String card = "";
                    int space = c1Hand.indexOf(" ");
                    int space2 = c1Hand1.indexOf(" ");
                    card = c1Hand.substring(0, space);
                    c1Hand = c1Hand.substring(space + 1);
                    if (c1Hand.length() <= 3 && !c1Hand.substring(0, 1).equals("8")
                            && c1Hand.indexOf(topCard.substring(0, topCard.length() - 1)) >= 0) {
                        card = c1Hand;
                    }if(c1Hand.length()<=3){
                        validInput = true;
                    }
                if (temp.indexOf(topCard.substring(0, topCard.length() - (topCard.length() - 1))) >= 0) {
                        card = card.trim();
                        if (!(card.substring(0, 1).equals("8")) && !(card.substring(card.length() - 1) .equals(oppHand1.substring(oppHand1.length() - 1)))) {
                            tempCard = card;
                            newHand = discard(temp, card);
                            newHand = newHand.replaceAll("\\s+", " ");
                            if (newHand.indexOf(" ") == 0) {
                                newHand = newHand.replaceFirst(" ", "");
                            }
                            c1Hand = newHand;
                            c1Hand1 = c1Hand1.substring(space2 + 1);
                            validInput = true;
                            System.out.println("Computer " + number + " Played: [" + card + "]");
                            System.out.println("Computer " + number + " Hand: " + c1Hand1);
                            System.out.println("Top Card: " + tempCard);
                            return c1Hand + "-" + tempCard + "-" + c1Hand1;
                        }
                            else if (!(card.substring(0, 1).equals("8")) && !(card.substring(card.length() - 1).equals(oppHand2.substring(oppHand2.length() - 1)))) {
                                tempCard = card;
                                newHand = discard(temp, card);
                                newHand = newHand.replaceAll("\\s+", " ");
                                if (newHand.indexOf(" ") == 0) {
                                    newHand = newHand.replaceFirst(" ", "");
                                }
                                c1Hand = newHand;
                                c1Hand1 = c1Hand1.substring(space2 + 1);
                                validInput = true;
                                System.out.println("Computer " + number + " Played: [" + card + "]");
                                System.out.println("Computer " + number + " Hand: " + c1Hand1);
                                System.out.println("Top Card: " + tempCard);
                                return c1Hand + "-" + tempCard + "-" + c1Hand1;
                            }
                    }    
                }                    
                    boolean validInput3 = false;
                    c1Hand = temp;
                    while (c1Hand.length() > 0 && !validInput3) {
                        String card = "";
                        int space = c1Hand.indexOf(" ");
                        int space2 = c1Hand1.indexOf(" ");
                        card = c1Hand.substring(0, space);
                        c1Hand = c1Hand.substring(space + 1);
                        if (c1Hand.length() <= 3) {
                            card = c1Hand;
                        }
                        if (temp.indexOf("8") >= 0) {
                            card = card.trim();
                            if (card.substring(0, 1).equals("8")) {
                                newHand = discard(temp, card);
                                if(oppHand1.length()<=3){
                                    String cantPlay = oppHand1.substring(oppHand1.length()-1);
                                    String suits = "DCHS";
                                    suits = suits.replace(cantPlay, "");
                                    suits = suits.trim();
                                    String newSuit = suits.substring(0, 1);
                                newHand = newHand.replaceAll("\\s+", " ");
                                if (newHand.indexOf(" ") == 0) {
                                    newHand = newHand.replaceFirst(" ", "");
                                }
                                c1Hand = newHand;
                                c1Hand1 = c1Hand1.substring(space2 + 1);
                                validInput3 = true;
                                System.out.println("Computer " + number + " Played: [" + card + "]");
                                System.out.println("Computer " + number + " Hand: " + c1Hand1);
                                System.out.println("New Suit: " + newSuit);
                                return c1Hand + "-" + newSuit + "-" + c1Hand1;
                            }else if(oppHand2.length()<=3){
                                String cantPlay = oppHand2.substring(oppHand2.length()-1);
                                String suits = "DCHS";
                                suits = suits.replace(cantPlay, "");
                                suits = suits.trim();
                                String newSuit = suits.substring(0, 1);
                            newHand = newHand.replaceAll("\\s+", " ");
                            if (newHand.indexOf(" ") == 0) {
                                newHand = newHand.replaceFirst(" ", "");
                            }
                            c1Hand = newHand;
                            c1Hand1 = c1Hand1.substring(space2 + 1);
                            validInput3 = true;
                            System.out.println("Computer " + number + " Played: [" + card + "]");
                            System.out.println("Computer " + number + " Hand: " + c1Hand1);
                            System.out.println("New Suit: " + newSuit);
                            return c1Hand + "-" + newSuit + "-" + c1Hand1;
                        }
                            }
                        }
                    } boolean validInput5 = false;
                    c1Hand = temp;
                    while (c1Hand.length() > 0 && !validInput5) {
                        String card = "";
                        int space = c1Hand.indexOf(" ");
                        int space2 = c1Hand1.indexOf(" ");
                        card = c1Hand.substring(0, space);
                        c1Hand = c1Hand.substring(space + 1);
                        if(c1Hand.length()<=3){
                            c1Hand=c1Hand.trim();
                        }
                        if (c1Hand.length() <= 3 && !(c1Hand.substring(0, 1).equals("8"))
                                && c1Hand.indexOf(topCard.substring(0, topCard.length() - 1)) >= 0) {
                            card = c1Hand;
                        }else if (c1Hand.length()<=3){
                            validInput5 = true;
                        }
                if(temp.indexOf(topCard.substring(0, topCard.length() - (topCard.length() - 1))) >= 0) {
                            card = card.trim();
                            if (!(card.substring(0, 1).equals("8"))
                                    && card.indexOf(topCard.substring(0, topCard.length() - 1)) >= 0) {
                                tempCard = card;
                                newHand = discard(temp, card);
                                newHand = newHand.replaceAll("\\s+", " ");
                                if (newHand.indexOf(" ") == 0) {
                                    newHand = newHand.replaceFirst(" ", "");
                                }
                                c1Hand = newHand;
                                c1Hand1 = c1Hand1.substring(space2 + 1);
                                validInput5 = true;
                                System.out.println("Computer " + number + " Played: [" + card + "]");
                                System.out.println("Computer " + number + " Hand: " + c1Hand1);
                                System.out.println("Top Card: " + tempCard);
                                return c1Hand + "-" + tempCard + "-" + c1Hand1;
                            }
                        }
                        // checks for rule 3
                    }
                    boolean validInput4 = false;
                    c1Hand = temp;
                    while (c1Hand.length() > 0 && !validInput4) {
                        String card = "";
                        int space = c1Hand.indexOf(" ");
                        int space2 = c1Hand1.indexOf(" ");
                        card = c1Hand.substring(0, space);
                        c1Hand = c1Hand.substring(space + 1);
                        if (c1Hand.length() <= 3 && !(c1Hand.substring(0, 1).equals("8"))
                                && c1Hand.indexOf(topCard.substring(topCard.length() - 1)) >= 0) {
                            card = c1Hand;
                        }if(c1Hand.length()<=3){
                            validInput4 = true;
                        }if (temp.indexOf(topCard.substring(topCard.length() - 1)) >= 0) {
                            card = card.trim();
                            if (!(card.substring(0, 1).equals("8"))
                                    && card.indexOf(topCard.substring(topCard.length() - 1)) >= 0) {
                                tempCard = card;
                                newHand = discard(temp, card);
                                newHand = newHand.replaceAll("\\s+", " ");
                                if (newHand.indexOf(" ") == 0) {
                                    newHand = newHand.replaceFirst(" ", "");
                                }
                                c1Hand = newHand;
                                c1Hand1 = c1Hand1.substring(space2 + 1);
                                validInput4 = true;
                                System.out.println("Computer " + number + " Played: [" + card + "]");
                                System.out.println("Computer " + number + " Hand: " + c1Hand1);
                                System.out.println("Top Card: " + tempCard);
                                return c1Hand + "-" + tempCard + "-" + c1Hand1;
                            }
                        }
                } 
             }
             //checks for rule 1
            boolean validInput1 = false;
            c1Hand = temp;
            while (c1Hand.length() > 0 && !validInput1) {
                String card = "";
                int space = c1Hand.indexOf(" ");
                int space2 = c1Hand1.indexOf(" ");
                card = c1Hand.substring(0, space);
                c1Hand = c1Hand.substring(space + 1);
                if(c1Hand.length()<=3){
                    c1Hand=c1Hand.trim();
                }
                if (c1Hand.length() <= 3 && !(c1Hand.substring(0, 1).equals("8"))
                        && c1Hand.indexOf(topCard.substring(topCard.length() - 1)) >= 0) {
                    card = c1Hand;
                }else if (c1Hand.length()<=3){
                    validInput1 = true;
                }if (temp.indexOf(topCard.substring(topCard.length() - 1)) >= 0&&!(card.substring(0, 1).equals("8"))) {
                    card = card.trim();
                    if (!(card.substring(0, 1).equals("8"))
                            && card.indexOf(topCard.substring(topCard.length() - 1)) >= 0) {
                        tempCard = card;
                        newHand = discard(temp, card);
                        newHand = newHand.replaceAll("\\s+", " ");
                        if (newHand.indexOf(" ") == 0) {
                            newHand = newHand.replaceFirst(" ", "");
                        }
                        c1Hand = newHand;
                        c1Hand1 = c1Hand1.substring(space2 + 1);
                        validInput1 = true;
                        System.out.println("Computer " + number + " Played: [" + card + "]");
                        System.out.println("Computer " + number + " Hand: " + c1Hand1);
                        System.out.println("Top Card: " + tempCard);
                        return c1Hand + "-" + tempCard + "-" + c1Hand1;
                    }
                }
            }
            // checks for rule 2 
            boolean validInput2 = false;
            c1Hand = temp;
            while (c1Hand.length() > 0 && !validInput2) {
                String card = "";
                int space = c1Hand.indexOf(" ");
                int space2 = c1Hand1.indexOf(" ");
                card = c1Hand.substring(0, space);
                c1Hand = c1Hand.substring(space + 1);
                if(c1Hand.length()<=3){
                    c1Hand=c1Hand.trim();
                }
                if (c1Hand.length() <= 3 && !(c1Hand.substring(0, 1).equals("8"))
                        && c1Hand.indexOf(topCard.substring(0, topCard.length() - 1)) >= 0) {
                    card = c1Hand;
                }else if (c1Hand.length()<=3){
                    validInput2 = true;
                }
        if(temp.indexOf(topCard.substring(0, topCard.length() - (topCard.length() - 1))) >= 0) {
                    card = card.trim();
                    if (!(card.substring(0, 1).equals("8"))
                            && card.indexOf(topCard.substring(0, topCard.length() - 1)) >= 0) {
                        tempCard = card;
                        newHand = discard(temp, card);
                        newHand = newHand.replaceAll("\\s+", " ");
                        if (newHand.indexOf(" ") == 0) {
                            newHand = newHand.replaceFirst(" ", "");
                        }
                        c1Hand = newHand;
                        c1Hand1 = c1Hand1.substring(space2 + 1);
                        validInput2 = true;
                        System.out.println("Computer " + number + " Played: [" + card + "]");
                        System.out.println("Computer " + number + " Hand: " + c1Hand1);
                        System.out.println("Top Card: " + tempCard);
                        return c1Hand + "-" + tempCard + "-" + c1Hand1;
                    }
                }
                // checks for rule 3
            } if (temp.indexOf("8") >= 0) {
                String card = "";
                boolean validInput = false;
                c1Hand = temp;
                while (c1Hand.length() > 0 && !validInput) {
                    int space = c1Hand.indexOf(" ");
                    int space2 = c1Hand1.indexOf(" ");
                    card = c1Hand.substring(0, space);
                    c1Hand = c1Hand.substring(space + 1);
                    if (c1Hand.length() <= 3) {
                        card = c1Hand;
                    }
                    card = card.trim();
                    if (card.substring(0, 1).equals("8")) {
                        newHand = discard(temp, card);
                        newHand = newHand.replaceAll("\\s+", " ");
                        if (newHand.indexOf(" ") == 0) {
                            newHand = newHand.replaceFirst(" ", "");
                        }
                        String newCard = newHand.substring(0, space);
                        tempCard = newCard.substring(newCard.length() - 1);
                        c1Hand = newHand;
                        c1Hand1 = c1Hand1.substring(space2 + 1);
                        validInput = true;
                        System.out.println("Computer " + number + " Played: [" + card + "]");
                        System.out.println("Computer " + number + " Hand: " + c1Hand1);
                        System.out.println("New Suit: " + tempCard);
                        return c1Hand + "-" + tempCard + "-" + c1Hand1;
                    }
                }
            }
            return c1Hand + "-" + tempCard + "-" + c1Hand1;
    }
}

    // checks to see if they can play
    private static boolean canPlay(String check, String topCard) {
        boolean canPlay = false;
        if (check.indexOf(topCardNumber(topCard)) >= 0 || check.indexOf(topCardSuit(topCard)) >= 0) {
            canPlay = true;
        } else if (check.indexOf("8") >= 0) {
            canPlay = true;
        }

        return canPlay;
    }

    // gets the topCard's rank/number
    private static String topCardNumber(String topCard) {
        if (topCard.length() == 1) {
            return topCard;
        }
        return topCard.substring(0, topCard.length() - 1);
    }

    // gets the topCards suit
    private static String topCardSuit(String topCard) {
        if (topCard.length() == 1) {
            return topCard;
        }
        return topCard.substring(topCard.length() - 1);
    }

    // prompts player to play a card, validates the card, returns playerHand and topCard
    private static String playCard(String playerHand, String topCard, Scanner in) {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Player Hand: " + playerHand);
            System.out.print("Which card would you like to play: ");
            String playedCard = in.nextLine().toUpperCase();
            // sees if the playedCard is an 8
            if (playedCard.substring(0, 1).equals("8")) {
                String temp = ifEight(playerHand, topCard, playedCard, in);
                int dash = temp.indexOf("-");
                playerHand = temp.substring(0, dash);
                playerHand = playerHand.replaceAll("\\s+", " ");
                if (playerHand.indexOf(" ") == 0) {
                    playerHand = playerHand.replaceFirst(" ", "");
                }
                String newSuit = temp.substring(dash + 1);
                topCard = newSuit;
                System.out.println("New Hand: " + playerHand);
                validInput = true;
                return playerHand + "-" + topCard;
            } else if (canPlay(playedCard, topCard) && playerHand.indexOf(playedCard) >= 0 && playedCard.length() > 1
                    && suit(playedCard)) {
                String newHand = discard(playerHand, playedCard);
                newHand = newHand.replaceAll("\\s+", " ");
                if (newHand.indexOf(" ") == 0) {
                    newHand = newHand.replaceFirst(" ", "");
                }
                playerHand = newHand;
                topCard = playedCard;
                System.out.println("New Hand: " + playerHand);
                System.out.println("Top Card: " + playedCard);
                validInput = true;
                return playerHand + "-" + topCard;
            } else {
                System.out.println("Invalid Input!");
                System.out.println("Player Hand: " + playerHand);
                System.out.println("Top Card: " + topCard);
            }
        }
        return "";
    }

    // checks to see if the playedCard's suit is allowed
    private static boolean suit(String playedCard) {
        return (playedCard.substring(playedCard.length() - 1).equals("D")
                || playedCard.substring(playedCard.length() - 1).equals("C")
                || playedCard.substring(playedCard.length() - 1).equals("H")
                || playedCard.substring(playedCard.length() - 1).equals("S"));
    }

    // prompts user to change the suit, validates the new suit, returns newHand, and newSuit
    private static String ifEight(String playerHand, String topCard, String playedCard, Scanner in) {
        boolean validInput = false;
        String newHand = discard(playerHand, playedCard);
        System.out.println("Player Hand: " + newHand);
        while (!validInput) {
            System.out.print("Which suit would you like to change into [D] [C] [H] [S]: ");
            try {
                String newSuit = in.nextLine().toUpperCase();
                if (checkSuit(newSuit) && newSuit.length() == 1) {
                    System.out.println("New suit is: " + newSuit);
                    validInput = true;
                    return newHand + "-" + newSuit;
                } else {
                    System.out.println("Invalid Input!");
                    System.out.println("Player Hand: " + newHand);
                    System.out.println("Top Card: " + playedCard);
                }

            } catch (Exception ex) {
                System.out.println("Invalid Input!");
            }
        }
        return "";
    }

    // checks to see if the picked suit is allowed
    private static boolean checkSuit(String suit) {
        return (suit.indexOf("D") >= 0 || suit.indexOf("C") >= 0 || suit.indexOf("H") >= 0 || suit.indexOf("S") >= 0);
    }

    // removes the paramter replace from str, replaces it with an empty string
    private static String discard(String hand, String replace) {
        String card = hand.substring(hand.indexOf(replace), hand.indexOf(replace) + replace.length());
        return hand.replaceFirst(card, "");
    }

    // gets a card by concatenating a getFace and getSuit
    private static String getCard() {
        String card = getFace() + getSuit();
        return card;
    }

    // gets a suit
    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);
        if (suit == 0)
            return HEARTS;
        else if (suit == 1)
            return DIAMONDS;
        else if (suit == 2)
            return CLUBS;
        else
            return SPADES;
    }

    // gets a face
    private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
            return suit + "";
        else if (suit == 1)
            return ACE;
        else if (suit == 11)
            return JACK;
        else if (suit == 12)
            return QUEEN;
        else
            return KING;
    }
}