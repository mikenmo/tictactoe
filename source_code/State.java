import java.util.Random;
public class State
{
    private final String CROSS="X";
	private final String CIRCLE="O";
    Stage stage;
    Cell[] grid = new Cell[9];
    boolean win;
    boolean playerTurn;
    Random rand = new Random();
    boolean draw = false;
    int action;
    public State(Stage stage)
    {
        int i;
        this.win = false;
        this.playerTurn = false; //rand.nextBoolean();
        this.stage=stage;
        this.draw = false;
        for(i=0;i<9;i++)
        {
            this.grid[i] = new Cell(this.stage,i);
        }
    }
    public State(State state)
    {
        int i;
        this.win = state.win;
        this.stage = state.stage;
        this.draw = state.draw;
        for(i=0;i<9;i++)
        {
            this.grid[i] = new Cell(state.grid[i]);
        }
        this.playerTurn = state.playerTurn;
    }
    public State(State state, int action)
    {
        int i;
        this.win = state.win;
        this.stage = state.stage;
        this.draw = state.draw;
        this.playerTurn = !state.playerTurn;
        for(i=0;i<9;i++)
        {
            this.grid[i] = new Cell(state.grid[i]);
        }
        this.grid[action].mark = (this.playerTurn ? CIRCLE : CROSS);
        this.grid[action].marked = true;
        
    }

    public void printGrid()
    {
        int i;
        for(i=0;i<9;i++)
        {
            if(i%3==0)
            {
                System.out.println();
            }
            System.out.print(this.grid[i].mark);
        }
        System.out.println();
    }
    public boolean checkWin()
    {
        //123 456 789 - horizontal win
        //147 258 369 - vertical win
        //159 357 - diagonal win
        // this.printGrid();
        if(this.grid[0].mark!=null && this.grid[1].mark!=null && this.grid[2].mark!=null)
        {
            if(this.grid[0].mark == this.grid[1].mark && this.grid[0].mark == this.grid[2].mark)
            {    
                // System.out.println("win");
                this.win = true;
                return(true);
            }
        }
        if(this.grid[3].mark!=null && this.grid[4].mark!=null && this.grid[5].mark!=null)
        {
            if(this.grid[3].mark == this.grid[4].mark && this.grid[3].mark == this.grid[5].mark)
            {    
                // System.out.println("win");
                this.win = true;
                return(true);
            }
        }
        if(this.grid[6].mark!=null && this.grid[7].mark!=null && this.grid[8].mark!=null)
        {
            if(this.grid[6].mark == this.grid[7].mark && this.grid[6].mark == this.grid[8].mark)
            {    
                // System.out.println("win");
                this.win = true;
                return(true);
            }
        }
        if(this.grid[0].mark!=null && this.grid[3].mark!=null && this.grid[6].mark!=null)
        {
            if(this.grid[0].mark == this.grid[3].mark && this.grid[0].mark == this.grid[6].mark)
            {    
                // System.out.println("win");
                this.win = true;
                return(true);
            }
        }
        if(this.grid[1].mark!=null && this.grid[4].mark!=null && this.grid[7].mark!=null)
        {
            if(this.grid[1].mark == this.grid[4].mark && this.grid[1].mark == this.grid[7].mark)
            {    
                // System.out.println("win");
                this.win = true;
                return(true);
            }
        }
        if(this.grid[2].mark!=null && this.grid[5].mark!=null && this.grid[8].mark!=null)
        {
            if(this.grid[2].mark == this.grid[5].mark && this.grid[2].mark == this.grid[8].mark)
            {    
                // System.out.println("win");
                this.win = true;
                return(true);
            }
        }
        if(this.grid[0].mark!=null && this.grid[4].mark!=null && this.grid[8].mark!=null)
        {
            if(this.grid[0].mark == this.grid[4].mark && this.grid[0].mark == this.grid[8].mark)
            {    
                // System.out.println("win");
                this.win = true;
                return(true);
            }
        }
        if(this.grid[2].mark!=null && this.grid[4].mark!=null && this.grid[6].mark!=null)
        {
            if(this.grid[2].mark == this.grid[4].mark && this.grid[2].mark == this.grid[6].mark)
            {    
                // System.out.println("win");
                this.win = true;
                return(true);
            }
        }
        if(this.grid[0].mark!=null && this.grid[1].mark!=null && this.grid[2].mark!=null && this.grid[3].mark!=null && this.grid[4].mark!=null && this.grid[5].mark!=null && this.grid[6].mark!=null && this.grid[7].mark!=null && this.grid[8].mark!=null)
        {
            // System.out.println("draw");
            this.draw = true;
        }
        return(false);
    }
}