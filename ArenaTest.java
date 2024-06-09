public class ArenaTest {
    public static void main(String[] args) {
        ArenaTest test = new ArenaTest();
        test.testFightScenario();
    }

    public void testFightScenario() {
        Player player1 = new Player("Player A", 50, 5, 10);
        Player player2 = new Player("Player B", 100, 10, 5);

        Arena arena = new Arena(player1, player2);
        arena.start();

        if (player1.isDead() || player2.isDead()) {
            System.out.println("Test passed: One of the players is dead.");
        } else {
            System.out.println("Test failed: Both players are still alive.");
        }
    }
}
