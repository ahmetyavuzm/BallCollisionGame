
public class Main {
    public static void main(String[] args) {

        InputIO boardFile = new InputIO(args[0]);
        InputIO moveFile = new InputIO(args[1]);
        OutputIO outputFile = new OutputIO("output.txt");

        Game game = new Game(boardFile.getAsBoard(), moveFile.getAsMoves());
        game.play();
        outputFile.printGameResult(game);
    }
}