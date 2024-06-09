import java.util.Random;

public class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public int rollAttackDice() {
        return rollDice() * this.attack;
    }

    public int rollDefenseDice() {
        return rollDice() * this.strength;
    }

    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public boolean isDead() {
        return !isAlive();
    }
}
