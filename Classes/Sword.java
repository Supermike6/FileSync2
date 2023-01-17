package Experiments.Classes;

import java.util.ArrayList;

public class Sword
{
    private String owner, material;
    private int durability, length;
    private boolean enchanted;
	private boolean traded;
    
	public String toString() {
		return "Sword [owner=" + owner + ", material=" + material + ", durability=" + durability + ", length=" + length
				+ ", enchanted=" + enchanted + ", traded="+traded+"]";
	}

	public Sword(String owner, String material, int durability, int length, boolean enchanted, boolean traded) {
		this.owner = owner;
	      this.material = material;
	      this.durability = durability;
	      this.length = length;
	      this.enchanted = enchanted;
		  this.traded = traded;
	}

	public static void main(String[] args)
	{
		
		ArrayList<Sword> familyAndFriendsSwords = new ArrayList<Sword>();
		
		Sword gpa_Sword = new Sword("Gpa","Diamond", 200, 24, true, false);
		Sword victorViciousSlicer = new Sword ("Victor", "dominoes", 10, 100000000, true, true);
		
		familyAndFriendsSwords.add(gpa_Sword);
		familyAndFriendsSwords.add(victorViciousSlicer);
		
		for (Sword swd : familyAndFriendsSwords) System.out.println(swd);
		
		System.out.println(gpa_Sword.material);
		

	}

}

