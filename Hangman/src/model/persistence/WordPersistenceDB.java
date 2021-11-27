package model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordPersistenceDB implements IWordPersistence {

	@Override
	public void addWord(String word) {
		System.out.println(word + " added to File DB");
	}

	@Override
	public String getWord() {
		String word = "Datenbank";
		String url = "jdbc:sqlite:./DB/Hangman.db";
		try (Connection c = DriverManager.getConnection(url)) {
			String stm = "SELECT * FROM word";
			Statement s = c.createStatement();
			ResultSet results = s.executeQuery(stm);
			List<String> wordList = new ArrayList<>();
			while (results.next()) {
				wordList.add(results.getString(2));
			}
			word = wordList.get(new Random().nextInt(wordList.size()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return word;
	}

}
