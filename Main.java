public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);

        Arena arena = new Arena(player1, player2);
        arena.fight();
    }
}

