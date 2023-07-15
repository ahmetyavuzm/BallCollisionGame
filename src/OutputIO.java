import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputIO {
    public String filename;
    public OutputIO(String filename){
        this.filename = filename;
        createOutFile(this.filename);
    }

    private static void createOutFile(String filename){
        FileWriter file;
        try {
            file = new FileWriter(filename);
            file.close();
        } catch (IOException e) {
        }

    }

    public void printGameResult(Game game){
        writeln("Game board:");
        printGameBoard(game.startBoard);
        writeln("");

        writeln("Your movement is:");
        writeln(String.join(" ",convertStringList(game.moves.playedMoves)));
        writeln("");

        writeln("Your output is:");
        printGameBoard(game.board);
        writeln("");
        if(game.gameOver){
            writeln("Game Over!");
        }
        writeln("Score: " + String.valueOf(game.totalPoint));
    }

    private void printGameBoard(Board board){
        for (int i= 0; i< board.height; i++){
            writeln(String.join(" ",convertStringList(board.board.get(i))));
        }
    }

    public <T> void writeln(T text){
        String filePath = "output.txt";
        try {
            FileWriter outFile = new FileWriter(filePath, true);
            outFile.write(String.valueOf(text) + "\n");
            outFile.close();
        } catch (IOException e) {
        }
    }

    private <T> ArrayList<String> convertStringList(ArrayList<T> list){
        ArrayList<String> convertedList = new ArrayList<>();
        for (T item: list){
            convertedList.add(String.valueOf(item));
        }
        return convertedList;
    }
}
