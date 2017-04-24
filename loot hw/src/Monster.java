import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

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
		Random gen = new Random();
		List<String> monsters = new ArrayList<String>(monster.keySet());
		String rndMonster = monster.get(gen.nextInt(monsters.size()));
		return rndMonster;
		
	}

}
