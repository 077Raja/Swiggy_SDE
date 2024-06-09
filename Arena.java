public class Arena {
    private Player player1;
    private Player player2;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void fight() {
        Player attacker = determineFirstAttacker();
        Player defender = (attacker == player1) ? player2 : player1;

        while (!player1.isDead() && !player2.isDead()) {
            attackTurn(attacker, defender);
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        System.out.println("Game Over!");
        System.out.println("Player 1 Health: " + player1.getHealth());
        System.out.println("Player 2 Health: " + player2.getHealth());
    }

    private Player determineFirstAttacker() {
        return (player1.getHealth() <= player2.getHealth()) ? player1 : player2;
    }

    private void attackTurn(Player attacker, Player defender) {
        int attackRoll = attacker.rollAttackDice();
        int defendRoll = defender.rollDefendDice();

        int attackDamage = attackRoll * attacker.getAttack();
        int defendStrength = defendRoll * defender.getStrength();

        int damage = attackDamage - defendStrength;
        if (damage > 0) {
            defender.takeDamage(damage);
        }

        System.out.println("Attacker Roll: " + attackRoll + ", Attack Damage: " + attackDamage);
        System.out.println("Defender Roll: " + defendRoll + ", Defend Strength: " + defendStrength);
        System.out.println("Defender Health after attack: " + defender.getHealth());
    }
}
