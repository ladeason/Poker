public enum Rank {
    ACE("A", 13),
    KING("K", 12),
    QUEEN("Q", 11),
    JACK("J", 10),
    TEN("10", 9),
    NINE("9", 8),
    EIGHT("8", 7),
    SEVEN("7", 6),
    SIX("6", 5),
    FIVE("5", 4),
    FOUR("4", 3),
    THREE("3", 2),
    TWO("2", 1);

    public final String label;
    public final int value;

    Rank(String label, int value) {
        this.label = label;
        this.value = value;
    }
}