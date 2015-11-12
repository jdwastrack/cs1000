import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author dillonwastrack
 *
 */
public class WordSearch {
	
	private static int boardSize;

	public ArrayList<Node> readFile(String fileName) throws IOException {
		
		FileReader fr = new FileReader(fileName);
		BufferedReader text = new BufferedReader(fr);
		String line;
		ArrayList<Node> vertices = new ArrayList<Node>();
		int lineCounter = 0;
		
		boardSize = Integer.parseInt(text.readLine());
		System.out.println(boardSize);
		while ((line = text.readLine()) != null){
			String strippedLine = line.replaceAll("\\s","");
			char[] lineChars = strippedLine.toCharArray();
			//System.out.println(Arrays.toString(lineChars));
			lineCounter += 1;
			for (int i = 0; i <= lineChars.length - 1; i++){
				Node vertex = new Node(lineChars[i], i, lineCounter);
				vertices.add(vertex);
			}
		}
		fr.close();
		text.close();
		return vertices;
	}
	
	public static void printPuzzle(ArrayList<Node> puzzle){
		int linesToPrint = boardSize;
		int boardIndeces = puzzle.size();
		int i = 0;
		while (linesToPrint > 0 && i <= boardIndeces){
			System.out.print(puzzle.get(i).getLetter() + " ");
			i++;
			linesToPrint--;
		}
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		WordSearch search = new WordSearch();
		ArrayList<Node> wordList = search.readFile("puzzle.txt");
		search.printPuzzle(wordList);

	}

}
