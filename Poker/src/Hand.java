import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> highCards;
    private int ranking;
    private String title;

    public Hand(Card[] cards) {
        ArrayList<Card> hand, hand2;
        highCards = new ArrayList<>();

        // Royal Flush

        for (Card card : cards) {
            if (card.rank().equals(Rank.ACE)) {
                for (Card card2 : cards) {
                    if (card2.rank().equals(Rank.KING) && card2.suit().equals(card.suit())) {
                        for (Card card3 : cards) {
                            if (card3.rank().equals(Rank.QUEEN) && card3.suit().equals(card.suit())) {
                                for (Card card4 : cards) {
                                    if (card4.rank().equals(Rank.JACK) && card4.suit().equals(card.suit())) {
                                        for (Card card5 : cards) {
                                            if (card5.rank().equals(Rank.TEN) && card5.suit().equals(card.suit())) {
                                                ranking = 1;
                                                title = "Royal Flush";
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Straight Flush

        for (Rank rank : Rank.values()) {
            for (Card card : cards) {
                if (card.rank().equals(rank)) {
                    for (Card card2 : cards) {
                        if (card2.rank().value == card.rank().value - 1 && card2.suit().equals(card.suit())) {
                            for (Card card3 : cards) {
                                if (card3.rank().value == card.rank().value - 2 && card3.suit().equals(card.suit())) {
                                    for (Card card4 : cards) {
                                        if (card4.rank().value == card.rank().value - 3 && card4.suit().equals(card.suit())) {
                                            for (Card card5 : cards) {
                                                if (card5.rank().value == card.rank().value - 4 && card5.suit().equals(card.suit())) {
                                                    ranking = 2;
                                                    title = "Straight Flush";
                                                    highCards.add(card);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        // Four of a Kind

        for (Rank rank : Rank.values()) {
            hand = new ArrayList<>();

            for (Card card : cards) {
                if (card.rank().equals(rank)) {
                    hand.add(card);
                }
            }

            if (hand.size() >= 4) {
                ranking = 3;
                title = "Four of a Kind";
                highCards.add(hand.get(0));

                for (Rank rank2 : Rank.values()) {
                    for (Card card : cards) {
                        if (card.rank().equals(rank2) && !card.rank().equals(rank)) {
                            highCards.add(card);
                            return;
                        }
                    }
                }
            }
        }

        // Full House

        for (Rank rank : Rank.values()) {
            hand = new ArrayList<>();

            for (Card card : cards) {
                if (card.rank().equals(rank)) {
                    hand.add(card);
                }
            }

            if (hand.size() >= 3) {
                for (Rank rank2 : Rank.values()) {
                    hand2 = new ArrayList<>();

                    for (Card card : cards) {
                        if (card.rank().equals(rank2) && !card.rank().equals(rank)) {
                            hand2.add(card);
                        }
                    }

                    if (hand2.size() >= 2) {
                        ranking = 4;
                        title = "Full House";
                        highCards.add(hand.get(0));
                        highCards.add(hand2.get(0));
                    }
                }
            }
        }

        // Flush

        for (Suit suit: Suit.values()) {
            hand = new ArrayList<>();

            for (Card card: cards) {
                if (card.suit().equals(suit)) {
                    hand.add(card);
                }
            }

            if (hand.size() >= 5) {
                ranking = 5;
                title = "Flush";

                for (Rank rank: Rank.values()) {
                    for (Card card: hand) {
                        if (card.rank().equals(rank)) {
                            highCards.add(card);
                            return;
                        }
                    }
                }
            }
        }

        // Straight

        for (Rank rank : Rank.values()) {
            for (Card card : cards) {
                if (card.rank().equals(rank)) {
                    for (Card card2 : cards) {
                        if (card2.rank().value == card.rank().value - 1) {
                            for (Card card3 : cards) {
                                if (card3.rank().value == card.rank().value - 2) {
                                    for (Card card4 : cards) {
                                        if (card4.rank().value == card.rank().value - 3) {
                                            for (Card card5 : cards) {
                                                if (card5.rank().value == card.rank().value - 4) {
                                                    ranking = 6;
                                                    title = "Straight";
                                                    highCards.add(card);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Three of a Kind

        for (Rank rank : Rank.values()) {
            hand = new ArrayList<>();

            for (Card card : cards) {
                if (card.rank().equals(rank)) {
                    hand.add(card);
                }
            }

            if (hand.size() >= 3) {
                ranking = 7;
                title = "Three of a Kind";
                highCards.add(hand.get(0));

                for (Rank rank2 : Rank.values()) {
                    for (Card card : cards) {
                        if (card.rank().equals(rank2) && !card.rank().equals(rank)) {
                            highCards.add(card);

                            if (highCards.size() >= 3) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        // Two Pair

        for (Rank rank : Rank.values()) {
            hand = new ArrayList<>();

            for (Card card : cards) {
                if (card.rank().equals(rank)) {
                    hand.add(card);
                }
            }

            if (hand.size() >= 2) {
                for (Rank rank2 : Rank.values()) {
                    hand2 = new ArrayList<>();

                    for (Card card : cards) {
                        if (card.rank().equals(rank2) && !card.rank().equals(rank)) {
                            hand2.add(card);
                        }
                    }

                    if (hand2.size() >= 2) {
                        ranking = 8;
                        title = "Two Pair";
                        highCards.add(hand.get(0));
                        highCards.add(hand2.get(0));

                        for (Rank rank3 : Rank.values()) {
                            for (Card card : cards) {
                                if (card.rank().equals(rank3) && !card.rank().equals(rank)  && !card.rank().equals(rank2)) {
                                    highCards.add(card);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        // Pair

        for (Rank rank : Rank.values()) {
            hand = new ArrayList<>();

            for (Card card : cards) {
                if (card.rank().equals(rank)) {
                    hand.add(card);
                }
            }

            if (hand.size() >= 2) {
                ranking = 9;
                title = "Pair";
                highCards.add(hand.get(0));

                for (Rank rank2 : Rank.values()) {
                    for (Card card : cards) {
                        if (card.rank().equals(rank2) && !card.rank().equals(rank)) {
                            highCards.add(card);

                            if (highCards.size() >= 4) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        // High Card

        ranking = 10;
        title = "High Card";

        for (Rank rank : Rank.values()) {
            for (Card card : cards) {
                if (card.rank().equals(rank)) {
                    highCards.add(card);

                    if (highCards.size() >= 5) {
                        return;
                    }
                }
            }
        }
    }

    public ArrayList<Card> getHighCards() {
        return highCards;
    }

    public int getRanking() {
        return ranking;
    }

    public String getTitle() {
        return title;
    }
}
