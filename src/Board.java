import java.util.ArrayList;

public class Board {

    public int width;
    public int height;
    public ArrayList<ArrayList<Character>> board;

    public Position whitePosition;

    public Board(ArrayList<ArrayList<Character>> boardList){
        this.board = boardList;
        this.whitePosition = getWhite();
        setSize();
    }

    public Character getValue(Position position){
        return this.board.get(position.y).get(position.x);
    }

    public void setValue(Position position, Character value){
        this.board.get(position.y).set(position.x, value);
    }

    private Position getWhite(){
        for (ArrayList<Character> row: this.board){
            for (char item : row){
                if (item == '*'){
                    int white_y = this.board.indexOf(row);
                    int white_x = row.indexOf(item);
                    return new Position(white_x,white_y);
                }
            }
        }
        return null;
    }

    private void setSize(){
        this.height = this.board.size();
        this.width = this.board.get(0).size();
    }

    /*
    public ArrayList<Position> findAll(Character item){
        ArrayList<Position> items = new ArrayList<>();
        for (int x=0; x<width; x++){
            for (int y=0; y<height; y++){
                Position pos = new Position(x,y);
                if (getValue(pos) == item){
                    items.add(pos);
                }
            }
        }
        return items;
    }*/

}
