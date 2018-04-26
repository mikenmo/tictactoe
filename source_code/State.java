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
    int action;
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
    public State(State state)
    {
        int i;
        this.win = state.win;
        this.stage = state.stage;
        for(i=0;i<9;i++)
        {
            grid[i] = new Cell(state.grid[i]);
        }
        this.playerTurn = state.playerTurn;
    }
    public State(State state, int action)
    {
        int i;
        this.win = state.win;
        this.stage = state.stage;
        for(i=0;i<9;i++)
        {
            grid[i] = new Cell(state.grid[i]);
        }
        grid[action].mark = (this.playerTurn ? CROSS : CIRCLE);
        grid[action].marked = true;
        this.playerTurn = !state.playerTurn;
        System.out.println(this.playerTurn);
    }

    public void checkWin()
    {
        //123 456 789 - horizontal win
        //147 258 369 - vertical win
        //159 357 - diagonal win
        if(this.grid[0].mark!=null && this.grid[1].mark!=null && this.grid[2].mark!=null)
        {
            if(this.grid[0].mark == this.grid[1].mark && this.grid[0].mark == this.grid[2].mark)
            {
                // System.out.println("WIN!!");
                this.win=true;
                // JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.grid[0].mark));
                // System.exit(0);
            }
        }
        if(this.grid[3].mark!=null && this.grid[4].mark!=null && this.grid[5].mark!=null)
        {
            if(this.grid[3].mark == this.grid[4].mark && this.grid[3].mark == this.grid[5].mark)
            {
                // System.out.println("WIN!!");
                this.win=true;
                // JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.grid[3].mark));
                // System.exit(0);
            }
        }
        if(this.grid[6].mark!=null && this.grid[7].mark!=null && this.grid[8].mark!=null)
        {
            if(this.grid[6].mark == this.grid[7].mark && this.grid[6].mark == this.grid[8].mark)
            {
                // System.out.println("WIN!!");
                this.win=true;
                // JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.grid[6].mark));
                // System.exit(0);
            }
        }
        if(this.grid[0].mark!=null && this.grid[3].mark!=null && this.grid[6].mark!=null)
        {
            if(this.grid[0].mark == this.grid[3].mark && this.grid[0].mark == this.grid[6].mark)
            {
                // System.out.println("WIN!!");
                this.win=true;
                // JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.grid[0].mark));
                // System.exit(0);
            }
        }
        if(this.grid[1].mark!=null && this.grid[4].mark!=null && this.grid[7].mark!=null)
        {
            if(this.grid[1].mark == this.grid[4].mark && this.grid[1].mark == this.grid[7].mark)
            {
                // System.out.println("WIN!!");
                this.win=true;
                // JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.grid[1].mark));
                // System.exit(0);
            }
        }
        if(this.grid[2].mark!=null && this.grid[5].mark!=null && this.grid[8].mark!=null)
        {
            if(this.grid[2].mark == this.grid[5].mark && this.grid[2].mark == this.grid[8].mark)
            {
                // System.out.println("WIN!!");
                this.win=true;
                // JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.grid[2].mark));
                // System.exit(0);
            }
        }
        if(this.grid[0].mark!=null && this.grid[4].mark!=null && this.grid[8].mark!=null)
        {
            if(this.grid[0].mark == this.grid[4].mark && this.grid[0].mark == this.grid[8].mark)
            {
                // System.out.println("WIN!!");
                this.win=true;
                // JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.grid[0].mark));
                // System.exit(0);
            }
        }
        if(this.grid[2].mark!=null && this.grid[4].mark!=null && this.grid[6].mark!=null)
        {
            if(this.grid[2].mark == this.grid[4].mark && this.grid[2].mark == this.grid[6].mark)
            {
                // System.out.println("WIN!!");
                this.win=true;
                // JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.grid[2].mark));
                // System.exit(0);
            }
        }
        if(this.grid[0].mark!=null && this.grid[1].mark!=null && this.grid[2].mark!=null && this.grid[3].mark!=null && this.grid[4].mark!=null && this.grid[5].mark!=null && this.grid[6].mark!=null && this.grid[7].mark!=null && this.grid[8].mark!=null)
        {
            // JOptionPane.showMessageDialog(null,"DRAW!!!");
            // System.exit(0);
        }
    }
}