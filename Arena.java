public class Arena {
    private Player player1;
    private Player player2;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        System.out.println("The battle begins between " + player1.getName() + " and " + player2.getName() + "!");

        while (player1.isAlive() && player2.isAlive()) {
            Player attacker = (player1.getHealth() < player2.getHealth()) ? player1 : player2;
            Player defender = (attacker == player1) ? player2 : player1;

            executeTurn(attacker, defender);

            if (defender.isDead()) {
                System.out.println(defender.getName() + " has died. " + attacker.getName() + " wins!");
                break;
            }

            // Swap roles for the next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;

            executeTurn(attacker, defender);

            if (defender.isDead()) {
                System.out.println(defender.getName() + " has died. " + attacker.getName() + " wins!");
                break;
            }
        }
    }

    private void executeTurn(Player attacker, Player defender) {
        System.out.println(attacker.getName() + " attacks " + defender.getName());

        int attackDamage = attacker.rollAttackDice();
        int defense = defender.rollDefenseDice();

        int actualDamage = attackDamage - defense;
        if (actualDamage < 0) actualDamage = 0;

        defender.reduceHealth(actualDamage);

        System.out.println(attacker.getName() + " rolls attack dice and deals " + attackDamage + " damage.");
        System.out.println(defender.getName() + " rolls defense dice and defends " + defense + " damage.");
        System.out.println(defender.getName() + " receives " + actualDamage + " damage and now has " + defender.getHealth() + " health.");
    }
}
