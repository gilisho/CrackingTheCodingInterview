package chapter1;

//question 1.6
class CharacterCount {
	char character;
	int count;
	
	public CharacterCount(char character, int count){
		this.character = character;
		this.count = count;
	}
	
	public String toString(){
		return (Character.toString(character)+Integer.toString(count));
	}
}