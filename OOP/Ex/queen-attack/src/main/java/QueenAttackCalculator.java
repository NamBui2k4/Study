class Queen{
    private int row;
    private int column;

    public Queen(int row, int column) throws IllegalArgumentException{
        
        this.row = row;
        this.column = column;
        
        if (row >= 8)
            throw new IllegalArgumentException("Queen position must have row <= 7.");    
        if (row < 0)
            throw new IllegalArgumentException("Queen position must have positive row.");
        if (column >= 8)
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        if (column < 0)
            throw new IllegalArgumentException("Queen position must have positive column.");
        
    }

    
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }

    
   
}

public class QueenAttackCalculator{

    private Queen WhiteQueen;
    private Queen BlackQueen;
    
    public QueenAttackCalculator(Queen WhiteQueen, Queen BlackQueen) throws IllegalArgumentException, NullPointerException{
        try{
            this.WhiteQueen = WhiteQueen;
            this.BlackQueen = BlackQueen;

            if (QueensOccupyTheSameSquare(WhiteQueen, BlackQueen)) 
                throw new IllegalArgumentException("Queens cannot occupy the same position.");
            if (BlackQueen.equals( null ) || WhiteQueen.equals( null) ) 
                throw new NullPointerException();
        }catch(NullPointerException e){
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        
        
    }
    

    public boolean QueensOccupyTheSameSquare(Queen whiteQueen, Queen blackQueen){
        if (whiteQueen.getRow() == blackQueen.getRow() && whiteQueen.getColumn() == blackQueen.getColumn())
            return true;
        return false;
    }
    
    public boolean canQueensAttackOneAnother(){
        if (BlackQueen.getColumn() == WhiteQueen.getColumn())
            return true;
        else if (BlackQueen.getRow() == WhiteQueen.getRow())
            return true;
        else{
            //new Queen(1, 7), new Queen(0, 6)
            for(int i = 0 ; i < 8; i++){
                int x1 = WhiteQueen.getRow(); // WhiteQueen(x1, y1)
                int y1 = WhiteQueen.getColumn(); 

                int x2 = BlackQueen.getRow(); // BlackQueen(x2, y2)
                int y2 = BlackQueen.getColumn(); 

                if ((x1 - i) == x2 && (y1 + i) == y2 )
                    return true;
                else if ((x1 + i) == x2 && ( y1 + i) == y2)
                    return true;
                else if ((x1 + i) == x2 && ( y1 - i) == y2)
                    return true;
                else if ((x1 - i) == x2 && ( y1 -i) == y2)
                     return true;
            }
        }
            return false;
    }
        
}