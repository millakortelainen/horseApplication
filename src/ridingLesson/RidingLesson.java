package ridingLesson;

import java.util.ArrayList;

import main.domain.*;
import main.util.MatchCalculator;
import main.util.PairFactory;
import main.util.ScoreCalculator;

public class RidingLesson {

	private int price;
	private Type type;
	private SkillLevel skillLevel;
	private ArrayList<Horse> horses;
	private ArrayList<Rider> riders;
	private ArrayList<Pair> horseRiderList;

	public RidingLesson(int price, Type type, SkillLevel skillLevel) {
		super();
		this.price = price;
		this.type = type;
		this.skillLevel = skillLevel;
		this.horses = new ArrayList<Horse>();
		this.riders = new ArrayList<Rider>();
		this.horseRiderList = new ArrayList<Pair>();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public SkillLevel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}

	public ArrayList<Horse> getHorses() {
		return this.horses;
	}

	public void addHorse(Horse horse) {
		this.horses.add(horse);
	}

	public ArrayList<Rider> getRiders() {
		return riders;
	}

	public void addRider(Rider rider) {
		this.riders.add(rider);
	}

	public void setHorsesToRiders() {
		if (this.horses.size() != this.riders.size()) {
			System.out.println("Number of horses and riders does not match.");
			System.out.println("There are " + this.horses.size() + " horses and " + this.riders.size() + " riders.");
			System.out.println("Please, even out the riders and horses.");
			return;
		}
		Pair[] horsesRider = new MatchCalculator().gsAlgorithmForPairing(
				this.horses.toArray(this.horses.toArray(new Horse[this.horses.size()])),
				this.riders.toArray(new Rider[this.horses.size()]), new ScoreCalculator());
		for (int i = 0; i < horsesRider.length; i++) {
			if (horsesRider[i] == null) {
				continue;
			}
			this.horseRiderList.add(horsesRider[i]);
		}
		System.out.println("Horses and riders:");
		for (Pair p : this.horseRiderList) {
			System.out.println(p);
		}
	}

	public ArrayList<Pair> getHorseRiderList() {
		return this.horseRiderList;
	}

}
