package proj4;

public abstract class Zombie {

    protected Zombie(int life, int reward, String desc) {
	this.life = life;
	this.reward = reward;
	this.desc = desc;
    }

    public static Zombie makeZombie(char c) {
	switch (c) {
	    case 'A': return new ArmoredZombie();
	    case 'G': return new GiantZombie();
	    case 'I': return new InfectedZombie();
	    case 'R': return new RadioactiveZombie();
	    case 'Z': return new StandardZombie();
	    case 'V': return new VoodooZombie();
	    case 'N': return new ZombieNinja();
	    case 'S': return new ZombieScientist();
	}
	return null;
    }

    public int getLife() {
	return life;
    }

    public int getReward() {
	return reward;
    }

    public String getDesc() {
	return desc;
    }

    public void takeDamage(int amount) {
	life -= amount;
    }

    public abstract void attack(Game g);

    private int life;
    private int reward;
    private String desc;
}