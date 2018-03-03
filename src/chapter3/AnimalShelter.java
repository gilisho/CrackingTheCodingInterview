package chapter3;

import java.util.LinkedList;

public class AnimalShelter {
	
	class Animal {
		boolean isDog;
		int arrivalTime;
		
		public Animal(boolean isDog){
			this.isDog = isDog;
			this.arrivalTime = currTime;
		}
	}
	
	static int currTime = 0;
	static LinkedList<Animal> dogs = new LinkedList<Animal>();
	static LinkedList<Animal> cats = new LinkedList<Animal>();
	
	void enqueue(boolean isDog){
		Animal animal = new Animal(isDog);
		if (isDog)
			dogs.add(animal);
		else
			cats.add(animal);
		currTime++;
	}
	
	Animal dequeueAny(){
		if (dogs.isEmpty())
			return (!cats.isEmpty()) ? dequeueCat() : null;			
		if (cats.isEmpty())
			return dequeueDog();
		boolean getDog = dogs.getFirst().arrivalTime < cats.getFirst().arrivalTime;
		return (getDog) ? dequeueDog() : dequeueCat();
	}
	
	Animal dequeueDog(){
		return dogs.poll();
	}
	
	Animal dequeueCat(){
		return cats.poll();
	}

}
