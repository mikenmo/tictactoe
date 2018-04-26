import java.util.Random;
public class State
{
    Stage stage;
    Cell[] grid = new Cell[9];
    boolean win;
    boolean playerTurn;
    Random rand = new Random();
    
    public State(Stage stage)
    {
        int i;
        this.win = false;
        this.playerTurn = rand.nextBoolean();
        this.stage=stage;
        for(i=0;i<9;i++)
        {
            grid[i] = new Cell(this.stage);
        }
    }
}