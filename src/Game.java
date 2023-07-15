import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Game {
    public Board board;
    public Board startBoard;
    public Moves moves;

    public ArrayList<Character> playerMoves;
    public int totalPoint = 0;
    public boolean gameOver = false;
    private Dictionary<Character, Integer> points = new Hashtable<>();


    public Game(ArrayList<ArrayList<Character>> board, ArrayList<Character> playerMoves) {
        this.startBoard = new Board(Utilities.deepCopy(board));
        this.board = new Board(board);
        this.moves = new Moves(this.board);
        this.playerMoves = playerMoves;

        setPoints();
    }

    public void play() {
        for (Character move : this.playerMoves) {
            if (!move(move)) {
                this.gameOver = true;
                break;
            }
            ;
        }
    }

    private boolean move(Character move) {
        try {
            char ball = this.moves.moveHandler(move);
            updatePoints(ball);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    private void setPoints() {
        this.points.put('R', 10);
        this.points.put('Y', 5);
        this.points.put('B', -5);
    }

    private void updatePoints(char ball) {
        try {
            this.totalPoint += points.get(ball);
        } catch (NullPointerException e) {
        }

    }
}
