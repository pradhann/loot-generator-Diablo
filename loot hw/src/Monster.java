import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Monster {
	
	private Map<String, String> monster;
	
	public Monster(File file) throws IOException {
		monster = new HashMap<String, String>();

		Scanner in = new Scanner(file);
		while (in.hasNextLine()) {
			String[] columns = in.nextLine().split("\t");
			monster.put(columns[0], columns[3]);
		}
		in.close();
	}
	
	public String pickMonster() {
		Random gen = ThreadLocalRandom.current();
		List<String> monsters = new ArrayList<String>(monster.keySet());
		int index = gen.nextInt(monsters.size());
		String rndMonster = monsters.get(index);
		return rndMonster;
	}

	public String monTreasure(String randomMonster) {
		String ret = monster.get(randomMonster);
		return ret;
	}
}
