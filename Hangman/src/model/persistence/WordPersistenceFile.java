package model.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordPersistenceFile implements IWordPersistence {

	@Override
	public void addWord(String word) {
		System.out.println(word + " added to File");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./DB/words.txt"), true))) {
			bw.write(","+word);
			bw.newLine();
			bw.flush();
		} catch (Exception e) {

		}
	}

	@Override
	public String getWord() {
		StringBuilder text = new StringBuilder();
		File f = new File("./DB/words.txt");
		try (
//		InputStream in = this.getClass().getResourceAsStream("/words.txt");
//		InputStreamReader isr = new InputStreamReader(in);
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);) {
			while (br.ready()) {
				text.append(br.readLine() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> wordlist = new ArrayList<>(List.of(text.toString().split(",")));
		String word = wordlist.get(new Random().nextInt(wordlist.size()));
		System.out.println(word);
		return word;
	}

}
