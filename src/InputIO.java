import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InputIO {

    public String filePath;

    public InputIO(String filePath){
        this.filePath = filePath;
    }

    public ArrayList<String> getLines(){
        try {
            ArrayList<String> lines = new ArrayList<String>();
            lines.addAll(Files.readAllLines(Paths.get(this.filePath)));
            return lines;

        } catch (IOException e) {
            System.exit(1);
            return null;
        }

    }

    public ArrayList<ArrayList<Character>> getAsBoard(){
        ArrayList<String> lines = getLines();
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        for (String line : lines){
            ArrayList<Character> boardLine = new ArrayList<>()  ;
            for (char cha : line.toCharArray()){
                if (cha != ' '){
                    boardLine.add(cha);
                }
            }
            board.add((boardLine));
        }
        return board;
    }

    public ArrayList<Character> getAsMoves(){
        String moveLine = getLines().get(0);
        ArrayList<Character> moves = new ArrayList<>();
        for (char cha : moveLine.toCharArray()){
            if (cha != ' '){
                moves.add(cha);
            }
        }
        return moves;
    }
}
