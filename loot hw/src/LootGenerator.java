import java.util.*;
import java.io.*;

public class LootGenerator {
	public static void main(String[] args) throws IOException {

		Monster monsters = new Monster(new File("monstats.txt"));
		Treasure treasures = new Treasure(new File("TreasureClassEx.txt"));
		Armor armor = new Armor(new File("armor.txt"));
		PreSuf prefixes = new PreSuf(new File("MagicPrefix.txt"));
		PreSuf suffixes = new PreSuf(new File("MagicSuffix.txt"));

		Scanner in = new Scanner(System.in);
		boolean cont = true;
		while (cont) {

			String monster = monsters.pickMonster();
			String treasure = monsters.monTreasure(monster);
			String item = treasures.getbaseItem(treasure);
			int itemBoost = armor.baseStats(item);
			boolean includeP = prefixes.pick();
			boolean includeS = suffixes.pick();


			System.out.println("Fighting " + monster);
			System.out.println("You have slain " + monster + "!");
			System.out.println(monster + " dropped:" + "\n");

			if (includeP && includeS) {
				int randomP = prefixes.randomIndex();
				String prefix = prefixes.randomAffix(randomP);
				String codeP = prefixes.codeName(randomP);
				int boostP = prefixes.boostVal(randomP);

				int randomS = suffixes.randomIndex();
				String suffix = suffixes.randomAffix(randomS);
				String codeS = suffixes.codeName(randomS);
				int boostS = suffixes.boostVal(randomS);

				System.out.println(prefix + " " + item + " " + suffix);
				System.out.printf("Defense: " + itemBoost + "\n");

				System.out.print(boostP + " ");
				System.out.println(codeP);
				System.out.print(boostS + " ");
				System.out.println(codeS);
			} else if (includeP) {

				int randomP = prefixes.randomIndex();
				String prefix = prefixes.randomAffix(randomP);
				String codePref = prefixes.codeName(randomP);
				int boostP = prefixes.boostVal(randomP);
				System.out.printf(prefix + " ");
				System.out.println(item);
				System.out.printf("Defense: ");
				System.out.println(itemBoost);
				System.out.print(boostP + " ");
				System.out.println(codePref);

			} else if (includeS) {
				int randomS = suffixes.randomIndex();
				String suffix = suffixes.randomAffix(randomS);
				String codeSuff = suffixes.codeName(randomS);
				int armorSuff = suffixes.boostVal(randomS);
				System.out.printf(item + " ");
				System.out.println(suffix);
				System.out.printf("Defense: ");
				System.out.println(itemBoost);
				System.out.print(armorSuff + " ");
				System.out.println(codeSuff);
			} else {
				System.out.println(item);
				System.out.printf("Defense: ");
				System.out.println(itemBoost);
			}

			System.out.println("Fight again [y/n]?");
			if (in.nextLine().equalsIgnoreCase("n")) {
				cont = false;
			}
		}
		in.close();

	}
}
