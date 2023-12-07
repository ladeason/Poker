import java.util.Scanner;

public class Poker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Deck deck;
        Hand hand, dealer;

        int money = 2000, input, bet, pot;
        int result; // -1 - lose, 0 - tie, 1 - win
        boolean isEnded = false, isValid, isFolded;

        /*
            100bb - $10sb / $20bb
            2 - black ($500) - $1000
            4 - green ($100) - $400
            6 - blue ($50) - $300
            8 - red ($25) - $200
            10 - white ($10) - $100
        */

        System.out.println("Welcome to Poker!\n");
        System.out.println("Money: $" + money + ".00\n");

        while (!isEnded) {
            deck = new Deck();
            bet = 0;
            pot = 0;
            isValid = false;
            isFolded = false;

            if (money < 20) {
                System.out.println("Not enough money to play\n");
                break;
            }

            while (!isValid) {
                System.out.println("Place a bet (min: $20.00): ");
                input = sc.nextInt();

                if (input < 20) {
                    System.out.println("Bet is too small, try again\n");
                }
                else if (input > money) {
                    System.out.println("Not enough money, try again\n");
                }
                else {
                    bet = input;
                    System.out.println("Bet placed: $" + bet + ".00\n");
                    isValid = true;
                }
            }

            money -= bet;
            pot += bet;

            System.out.println("Dealing cards: \n");

            deck.shuffle();
            Card card1 = deck.draw(), card2 = deck.draw();

            System.out.println("Hand: ");
            System.out.println("  Card 1: " + card1);
            System.out.println("  Card 2: " + card2 + "\n");

            Card dealer1 = deck.draw(), dealer2 = deck.draw();

            System.out.println("Dealer: ");
            System.out.println("  Dealer 1: <hidden>");
            System.out.println("  Dealer 2: <hidden>\n");

            isValid = false;

            System.out.println("Money: $" + money + ".00");
            System.out.println("Pot: $" + pot + ".00\n");

            while (!isValid) {
                System.out.println("Call, raise, all-in, or fold?: ");
                System.out.println("  1 - call");
                System.out.println("  2 - raise");
                System.out.println("  3 - all-in");
                System.out.println("  4 - fold");
                input = sc.nextInt();

                if (input == 1) {
                    System.out.println("Called\n");
                    System.out.println("Money: $" + money + ".00");
                    System.out.println("Pot: $" + pot + ".00\n");
                    isValid = true;
                }
                else if (input == 2) {
                    if (money < 20) {
                        System.out.println("Not enough money to raise\n");
                        isValid = true;
                    }
                    else {
                        while (!isValid) {
                            System.out.println("Raise by amount (min: $20.00): ");
                            input = sc.nextInt();

                            if (input < 20) {
                                System.out.println("Bet is too small, try again\n");
                            }
                            else if (input > money) {
                                System.out.println("Not enough money, try again\n");
                            }
                            else {
                                bet = input;
                                System.out.println("Raised by: $" + bet + ".00\n");
                                isValid = true;
                            }
                        }

                        money -= bet;
                        pot += bet;
                    }
                }
                else if (input == 3) {
                    if (money == 0) {
                        System.out.println("Out of money\n");
                    }
                    else {
                        System.out.println("All-in: $" + money + ".00\n");
                        pot += money;
                        money = 0;
                    }
                    isValid = true;
                }
                else if (input == 4) {
                    System.out.println("Folded\n");
                    System.out.println("Money: $" + money + ".00\n");
                    isValid = true;
                    isFolded = true;
                }
                else {
                    System.out.println("Invalid input, try again\n");
                }
            }

            if (!isFolded) {
                System.out.println("Dealing flop: \n");

                Card flop1 = deck.draw(), flop2 = deck.draw(), flop3 = deck.draw();

                System.out.println("Board: ");
                System.out.println("  Flop 1: " + flop1);
                System.out.println("  Flop 2: " + flop2);
                System.out.println("  Flop 3: " + flop3 + "\n");

                System.out.println("Hand: ");
                System.out.println("  Card 1: " + card1);
                System.out.println("  Card 2: " + card2 + "\n");

                System.out.println("Dealer: ");
                System.out.println("  Dealer 1: <hidden>");
                System.out.println("  Dealer 2: <hidden>\n");

                System.out.println("Money: $" + money + ".00");
                System.out.println("Pot: $" + pot + ".00\n");

                isValid = false;

                while (!isValid) {
                    System.out.println("Call, raise, all-in, or fold?: ");
                    System.out.println("  1 - call");
                    System.out.println("  2 - raise");
                    System.out.println("  3 - all-in");
                    System.out.println("  4 - fold");
                    input = sc.nextInt();

                    if (input == 1) {
                        System.out.println("Called\n");
                        isValid = true;
                    }
                    else if (input == 2) {
                        if (money < 20) {
                            System.out.println("Not enough money to raise\n");
                            isValid = true;
                        }
                        else {
                            while (!isValid) {
                                System.out.println("Raise by amount (min: $20.00): ");
                                input = sc.nextInt();

                                if (input < 20) {
                                    System.out.println("Bet is too small, try again\n");
                                }
                                else if (input > money) {
                                    System.out.println("Not enough money, try again\n");
                                }
                                else {
                                    bet = input;
                                    System.out.println("Raised by: $" + bet + ".00\n");
                                    isValid = true;
                                }
                            }

                            money -= bet;
                            pot += bet;
                        }
                    }
                    else if (input == 3) {
                        if (money == 0) {
                            System.out.println("Out of money\n");
                        }
                        else {
                            System.out.println("All-in: $" + money + ".00\n");
                            pot += money;
                            money = 0;
                        }
                        isValid = true;
                    }
                    else if (input == 4) {
                        System.out.println("Folded\n");
                        System.out.println("Money: $" + money + ".00\n");
                        isValid = true;
                        isFolded = true;
                    }
                    else {
                        System.out.println("Invalid input, try again\n");
                    }
                }

                if (!isFolded) {
                    System.out.println("Dealing turn: \n");

                    Card turn = deck.draw();

                    System.out.println("Board: ");
                    System.out.println("  Flop 1: " + flop1);
                    System.out.println("  Flop 2: " + flop2);
                    System.out.println("  Flop 3: " + flop3);
                    System.out.println("  Turn:   " + turn + "\n");

                    System.out.println("Hand: ");
                    System.out.println("  Card 1: " + card1);
                    System.out.println("  Card 2: " + card2 + "\n");

                    System.out.println("Dealer: ");
                    System.out.println("  Dealer 1: <hidden>");
                    System.out.println("  Dealer 2: <hidden>\n");

                    isValid = false;

                    System.out.println("Money: $" + money + ".00");
                    System.out.println("Pot: $" + pot + ".00\n");

                    while (!isValid) {
                        System.out.println("Call, raise, all-in, or fold?: ");
                        System.out.println("  1 - call");
                        System.out.println("  2 - raise");
                        System.out.println("  3 - all-in");
                        System.out.println("  4 - fold");
                        input = sc.nextInt();

                        if (input == 1) {
                            System.out.println("Called\n");
                            isValid = true;
                        }
                        else if (input == 2) {
                            if (money < 20) {
                                System.out.println("Not enough money to raise\n");
                                isValid = true;
                            }
                            else {
                                while (!isValid) {
                                    System.out.println("Raise by amount (min: $20.00): ");
                                    input = sc.nextInt();

                                    if (input < 20) {
                                        System.out.println("Bet is too small, try again\n");
                                    }
                                    else if (input > money) {
                                        System.out.println("Not enough money, try again\n");
                                    }
                                    else {
                                        bet = input;
                                        System.out.println("Raised by: $" + bet + ".00\n");
                                        isValid = true;
                                    }
                                }

                                money -= bet;
                                pot += bet;
                            }
                        }
                        else if (input == 3) {
                            if (money == 0) {
                                System.out.println("Out of money\n");
                            }
                            else {
                                System.out.println("All-in: $" + money + ".00\n");
                                pot += money;
                                money = 0;
                            }
                            isValid = true;
                        }
                        else if (input == 4) {
                            System.out.println("Folded\n");
                            System.out.println("Money: $" + money + ".00\n");
                            isValid = true;
                            isFolded = true;
                        }
                        else {
                            System.out.println("Invalid input, try again\n");
                        }
                    }

                    if (!isFolded) {
                        System.out.println("Dealing river: \n");

                        Card river = deck.draw();

                        System.out.println("Board: ");
                        System.out.println("  Flop 1: " + flop1);
                        System.out.println("  Flop 2: " + flop2);
                        System.out.println("  Flop 3: " + flop3);
                        System.out.println("  Turn:   " + turn);
                        System.out.println("  River:  " + river + "\n");

                        System.out.println("Hand: ");
                        System.out.println("  Card 1: " + card1);
                        System.out.println("  Card 2: " + card2 + "\n");

                        System.out.println("Dealer: ");
                        System.out.println("  Dealer 1: <hidden>");
                        System.out.println("  Dealer 2: <hidden>\n");

                        System.out.println("Money: $" + money + ".00");
                        System.out.println("Pot: $" + pot + ".00\n");

                        isValid = false;

                        while (!isValid) {
                            System.out.println("Call, raise, all-in, or fold?: ");
                            System.out.println("  1 - call");
                            System.out.println("  2 - raise");
                            System.out.println("  3 - all-in");
                            System.out.println("  4 - fold");
                            input = sc.nextInt();

                            if (input == 1) {
                                System.out.println("Called\n");
                                isValid = true;
                            }
                            else if (input == 2) {
                                if (money < 20) {
                                    System.out.println("Not enough money to raise\n");
                                    isValid = true;
                                }
                                else {
                                    while (!isValid) {
                                        System.out.println("Raise by amount (min: $20.00): ");
                                        input = sc.nextInt();

                                        if (input < 20) {
                                            System.out.println("Bet is too small, try again\n");
                                        }
                                        else if (input > money) {
                                            System.out.println("Not enough money, try again\n");
                                        }
                                        else {
                                            bet = input;
                                            System.out.println("Raised by: $" + bet + ".00\n");
                                            isValid = true;
                                        }
                                    }

                                    money -= bet;
                                    pot += bet;
                                }
                            }
                            else if (input == 3) {
                                if (money == 0) {
                                    System.out.println("Out of money\n");
                                }
                                else {
                                    System.out.println("All-in: $" + money + ".00\n");
                                    pot += money;
                                    money = 0;
                                }
                                isValid = true;
                            }
                            else if (input == 4) {
                                System.out.println("Folded\n");
                                System.out.println("Money: $" + money + ".00\n");
                                isValid = true;
                                isFolded = true;
                            }
                            else {
                                System.out.println("Invalid input, try again\n");
                            }
                        }

                        if (!isFolded) {
                            System.out.println("Revealing cards: \n");

                            System.out.println("Board: ");
                            System.out.println("  Flop 1: " + flop1);
                            System.out.println("  Flop 2: " + flop2);
                            System.out.println("  Flop 3: " + flop3);
                            System.out.println("  Turn:   " + turn);
                            System.out.println("  River:  " + river + "\n");

                            System.out.println("Hand: ");
                            System.out.println("  Card 1: " + card1);
                            System.out.println("  Card 2: " + card2 + "\n");

                            System.out.println("Dealer: ");
                            System.out.println("  Dealer 1: " + dealer1);
                            System.out.println("  Dealer 2: " + dealer2 + "\n");

                            hand = new Hand(new Card[]{card1, card2, flop1, flop2, flop3, turn, river});
                            dealer = new Hand(new Card[]{dealer1, dealer2, flop1, flop2, flop3, turn, river});

                            System.out.println("Calculating hands: ");
                            System.out.print("  Hand:   " + hand.getTitle());

                            switch (hand.getRanking()) {
                                case 2, 3, 5, 6, 7, 9, 10:
                                    System.out.println(" " + hand.getHighCards().get(0));
                                    break;
                                case 4, 8:
                                    System.out.println(" " + hand.getHighCards().get(0) + " " + hand.getHighCards().get(1));
                            }

                            System.out.print("  Dealer: " + dealer.getTitle());

                            switch (dealer.getRanking()) {
                                case 1:
                                    System.out.println("\n");
                                case 2, 3, 5, 6, 7, 9, 10:
                                    System.out.println(" " + dealer.getHighCards().get(0) + "\n");
                                    break;
                                case 4, 8:
                                    System.out.println(" " + dealer.getHighCards().get(0) + " " + dealer.getHighCards().get(1) + "\n");
                            }

                            result = 0;

                            if (hand.getRanking() < dealer.getRanking()) {
                                result = 1;
                            }
                            else if (hand.getRanking() > dealer.getRanking()) {
                                result = -1;
                            }
                            else {
                                switch (hand.getRanking()) {
                                    case 2, 5, 6:
                                        if (hand.getHighCards().get(0).rank().value > dealer.getHighCards().get(0).rank().value) {
                                            result = 1;
                                        }
                                        else if (hand.getHighCards().get(0).rank().value < dealer.getHighCards().get(0).rank().value) {
                                            result = -1;
                                        }
                                        break;
                                    case 3, 4:
                                        if (hand.getHighCards().get(0).rank().value > dealer.getHighCards().get(0).rank().value) {
                                            result = 1;
                                        }
                                        else if (hand.getHighCards().get(0).rank().value < dealer.getHighCards().get(0).rank().value) {
                                            result = -1;
                                        }
                                        else {
                                            if (hand.getHighCards().get(1).rank().value > dealer.getHighCards().get(1).rank().value) {
                                                result = 1;
                                            }
                                            else if (hand.getHighCards().get(1).rank().value < dealer.getHighCards().get(1).rank().value) {
                                                result = -1;
                                            }
                                        }
                                        break;
                                    case 7, 8:
                                        if (hand.getHighCards().get(0).rank().value > dealer.getHighCards().get(0).rank().value) {
                                            result = 1;
                                        }
                                        else if (hand.getHighCards().get(0).rank().value < dealer.getHighCards().get(0).rank().value) {
                                            result = -1;
                                        }
                                        else {
                                            if (hand.getHighCards().get(1).rank().value > dealer.getHighCards().get(1).rank().value) {
                                                result = 1;
                                            }
                                            else if (hand.getHighCards().get(1).rank().value < dealer.getHighCards().get(1).rank().value) {
                                                result = -1;
                                            }
                                            else {
                                                if (hand.getHighCards().get(2).rank().value > dealer.getHighCards().get(2).rank().value) {
                                                    result = 1;
                                                }
                                                else if (hand.getHighCards().get(2).rank().value < dealer.getHighCards().get(2).rank().value) {
                                                    result = -1;
                                                }
                                            }
                                        }
                                        break;
                                    case 9:
                                        if (hand.getHighCards().get(0).rank().value > dealer.getHighCards().get(0).rank().value) {
                                            result = 1;
                                        }
                                        else if (hand.getHighCards().get(0).rank().value < dealer.getHighCards().get(0).rank().value) {
                                            result = -1;
                                        }
                                        else {
                                            if (hand.getHighCards().get(1).rank().value > dealer.getHighCards().get(1).rank().value) {
                                                result = 1;
                                            }
                                            else if (hand.getHighCards().get(1).rank().value < dealer.getHighCards().get(1).rank().value) {
                                                result = -1;
                                            }
                                            else {
                                                if (hand.getHighCards().get(2).rank().value > dealer.getHighCards().get(2).rank().value) {
                                                    result = 1;
                                                }
                                                else if (hand.getHighCards().get(2).rank().value < dealer.getHighCards().get(2).rank().value) {
                                                    result = -1;
                                                }
                                                else {
                                                    if (hand.getHighCards().get(3).rank().value > dealer.getHighCards().get(3).rank().value) {
                                                        result = 1;
                                                    }
                                                    else if (hand.getHighCards().get(3).rank().value < dealer.getHighCards().get(3).rank().value) {
                                                        result = -1;
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    default:
                                        if (hand.getHighCards().get(0).rank().value > dealer.getHighCards().get(0).rank().value) {
                                            result = 1;
                                        }
                                        else if (hand.getHighCards().get(0).rank().value < dealer.getHighCards().get(0).rank().value) {
                                            result = -1;
                                        }
                                        else {
                                            if (hand.getHighCards().get(1).rank().value > dealer.getHighCards().get(1).rank().value) {
                                                result = 1;
                                            }
                                            else if (hand.getHighCards().get(1).rank().value < dealer.getHighCards().get(1).rank().value) {
                                                result = -1;
                                            }
                                            else {
                                                if (hand.getHighCards().get(2).rank().value > dealer.getHighCards().get(2).rank().value) {
                                                    result = 1;
                                                }
                                                else if (hand.getHighCards().get(2).rank().value < dealer.getHighCards().get(2).rank().value) {
                                                    result = -1;
                                                }
                                                else {
                                                    if (hand.getHighCards().get(3).rank().value > dealer.getHighCards().get(3).rank().value) {
                                                        result = 1;
                                                    }
                                                    else if (hand.getHighCards().get(3).rank().value < dealer.getHighCards().get(3).rank().value) {
                                                        result = -1;
                                                    }
                                                    else {
                                                        if (hand.getHighCards().get(4).rank().value > dealer.getHighCards().get(4).rank().value) {
                                                            result = 1;
                                                        }
                                                        else if (hand.getHighCards().get(4).rank().value < dealer.getHighCards().get(4).rank().value) {
                                                            result = -1;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                }
                            }

                            if (result == 1) {
                                pot *= 2;
                                money += pot;
                                System.out.println("Won!\n");
                                System.out.println("Total winnings: +$" + pot + ".00");
                                System.out.println("Money: $" + money + ".00\n");
                            }
                            else if (result == -1) {
                                System.out.println("Lost!\n");
                                System.out.println("Total lost: -$" + pot + ".00");
                                System.out.println("Money: $" + money + ".00\n");
                            }
                            else {
                                money += pot;
                                System.out.println("Tied!");
                                System.out.println("Earned back: +$" + pot + ".00");
                                System.out.println("Money: $" + money + ".00\n");
                            }

                            isValid = false;

                            while (!isValid) {
                                System.out.println("Continue playing?: ");
                                System.out.println("  1 - continue");
                                System.out.println("  2 - quit");
                                input = sc.nextInt();

                                if (input == 1) {
                                    System.out.println("Continued\n");
                                    System.out.println("Money: $" + money + ".00\n");
                                    isValid = true;
                                }
                                else if (input == 2) {
                                    System.out.println("Quit\n");
                                    System.out.println("Money: $" + money + ".00\n");
                                    isValid = true;
                                    isEnded = true;
                                }
                                else {
                                    System.out.println("Invalid input, try again\n");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
