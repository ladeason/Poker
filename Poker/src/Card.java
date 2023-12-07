public record Card(Suit suit, Rank rank) {
    @Override
    public String toString() {
        if (suit.equals(Suit.HEARTS)) {
            return "\u001B[31m" + suit.label + " " + rank.label + "\u001B[0m";
        }
        else if (suit.equals(Suit.CLUBS)) {
            return "\u001B[32m" + suit.label + " " + rank.label + "\u001B[0m";
        }
        else if (suit.equals(Suit.DIAMONDS)) {
            return "\u001B[34m" + suit.label + " " + rank.label + "\u001B[0m";
        }
        return suit.label + " " + rank.label;
    }
}