import java.util.ArrayList;

public class Moves {

    public Board gameBoard;

    public ArrayList<Character> playedMoves = new ArrayList<>();

    public Moves(Board board){
        this.gameBoard = board;
    }
    public Character moveHandler(Character move){
        playedMoves.add(move);
        switch (move){
            case 'U':
                return up();
            case 'R':
                return right();
            case 'D':
                return down();
            case 'L':
                return left();
            default:
                return null;
        }
    }
    private Character up(){
        return makeMove(
                this.gameBoard.whitePosition,
                this.gameBoard.whitePosition.offset(0,-1)
                );
    }
    private Character right(){
        return makeMove(
                this.gameBoard.whitePosition,
                this.gameBoard.whitePosition.offset(1,0)
        );
    }
    private Character down(){
        return makeMove(
                this.gameBoard.whitePosition,
                this.gameBoard.whitePosition.offset(0,1)
        );

    }
    private Character left(){
        return makeMove(
                this.gameBoard.whitePosition,
                this.gameBoard.whitePosition.offset(-1,0)
        );
    }
    private Character makeMove(Position pos1, Position pos2){
        if (!isInWidth(pos2)){
            widthEventPosition(pos1,pos2);
             return makeMove(pos1,pos2);

        }else if (!isInHeight(pos2)){
            heightEventPosition(pos1,pos2);
            return makeMove(pos1,pos2);

        } else if (isHole(pos2)) {
            this.gameBoard.setValue(pos1,' ');
            return null;

        } else if (isWall(pos2)) {
            wallEventPosition(pos1,pos2);
            return makeMove(pos1,pos2);
        } else {
            Character ball = this.gameBoard.getValue(pos2);
            changePositions(pos1,pos2);
            if (ball == 'R' || ball == 'B' || ball == 'Y'){
                this.gameBoard.setValue(pos1,'X');
            }
            this.gameBoard.whitePosition = pos2;
            return ball;
        }
    }
    private boolean isInWidth(Position position){
        if (position.x < this.gameBoard.width &&
            position.x >= 0)
        {
            return true;
        }
        return false;
    }
    private boolean isInHeight(Position position){
        if (position.y < this.gameBoard.height &&
            position.y >= 0)
        {
            return true;
        }
        return false;
    }
    private boolean isWall(Position position){
        if (this.gameBoard.getValue(position) == 'W'){
            return true;
        } return false;
    }
    private boolean isHole(Position position){
        if (this.gameBoard.getValue(position) == 'H'){
            return true;
        } return false;
    }
    private void changePositions(Position pos1, Position pos2){
        char pos1Value = this.gameBoard.getValue(pos1);
        char pos2Value = this.gameBoard.getValue(pos2);
        this.gameBoard.setValue(pos1, pos2Value);
        this.gameBoard.setValue(pos2, pos1Value);
    }
    private void wallEventPosition(Position pos1, Position pos2){
        if ((Math.abs(pos2.y - pos1.y) == (this.gameBoard.height- 1)) &&
            (pos2.y == 4 || pos2.y == 0)){
            pos2.y = Math.abs((pos2.y-5));
        }
        if ((Math.abs(pos2.x - pos1.x) == (this.gameBoard.width - 1)) &&
            (pos2.x == 4 || pos2.x == 0)){
            pos2.x = Math.abs((pos2.x-5));
        }
        pos2.x = 2 * pos1.x - pos2.x;
        pos2.y = 2* pos1.y -pos2.y;
    }
    private void widthEventPosition(Position pos1, Position pos2){
        pos2.x = this.gameBoard.width -1- pos1.x;
    }
    private void heightEventPosition(Position pos1, Position pos2){
        pos2.y = this.gameBoard.width -1- pos1.y;
    }



}
