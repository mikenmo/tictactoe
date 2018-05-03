import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Stage extends JPanel 
{
    private final String CROSS="X";
	private final String CIRCLE="O";
    private final int neg_inf=-9999;
	private final int pos_inf=9999;
    State state;
    public Stage()
    {
        this.state = new State(this);
        this.setLayout(new GridLayout(3,3));
        if(!this.state.playerTurn)
        {
            this.state.grid[4].markCell(CIRCLE);
            this.state.playerTurn = true;
        }
    }
    public ArrayList<Integer> actions(State s)
	{
		ArrayList <Integer> action = new ArrayList <Integer> ();
		State dummy;
        int i;
		for(i=0;i<9;i++)
        {
            dummy = new State(s);
            if(!dummy.grid[i].marked)
            {
                action.add(i);
            }
            dummy = null;
        }
		return action;  
	}

    public int aiMove()
    {   
        System.out.println("wait");
        this.state.playerTurn = false;
        int i;
        Value val = value(this.state);
        System.out.println("Next move: "+val.nextMove);
        System.out.println("Score: "+val.score);
        this.state.playerTurn = true;
        System.out.println("done");
        return val.nextMove;
    }
    public Value value(State s)
    {
        if (s.checkWin())
        {
            return(!s.playerTurn ? new Value(-10,s.action) : new Value(10,s.action));
        }
        if (s.draw==true)
        {
            return(new Value(0,s.action));
        }
        if (!s.playerTurn)
        {
            return(max_value(s));
        }
        else
        {
            return(min_value(s));
        }
    }
    public Value max_value(State s)
    {
        Value m = new Value(neg_inf,9);

        for(int a : actions(s))
        {
            Value v = value(new State(s,a));
            m.nextMove = ( (v.score>m.score) ? a : m.nextMove);
            m.score = ( (v.score>m.score) ? v.score : m.score );
        }
        return m;
    }
    public Value min_value(State s)
    {
        Value m = new Value(pos_inf,9);
        for(int a : actions(s))
        {
            Value v = value(new State(s,a));
            m.nextMove = ( (v.score<m.score) ? a : m.nextMove);
            m.score = ( (v.score<m.score) ? v.score : m.score );
        }
        return m;
    }
    public void checkWin()
    {
        //123 456 789 - horizontal win
        //147 258 369 - vertical win
        //159 357 - diagonal win
        if(this.state.grid[0].mark!=null && this.state.grid[1].mark!=null && this.state.grid[2].mark!=null)
        {
            if(this.state.grid[0].mark == this.state.grid[1].mark && this.state.grid[0].mark == this.state.grid[2].mark)
            {
                System.out.println("WIN!!");
                this.state.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.state.grid[0].mark));
                System.exit(0);
            }
        }
        if(this.state.grid[3].mark!=null && this.state.grid[4].mark!=null && this.state.grid[5].mark!=null)
        {
            if(this.state.grid[3].mark == this.state.grid[4].mark && this.state.grid[3].mark == this.state.grid[5].mark)
            {
                System.out.println("WIN!!");
                this.state.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.state.grid[3].mark));
                System.exit(0);
            }
        }
        if(this.state.grid[6].mark!=null && this.state.grid[7].mark!=null && this.state.grid[8].mark!=null)
        {
            if(this.state.grid[6].mark == this.state.grid[7].mark && this.state.grid[6].mark == this.state.grid[8].mark)
            {
                System.out.println("WIN!!");
                this.state.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.state.grid[6].mark));
                System.exit(0);
            }
        }
        if(this.state.grid[0].mark!=null && this.state.grid[3].mark!=null && this.state.grid[6].mark!=null)
        {
            if(this.state.grid[0].mark == this.state.grid[3].mark && this.state.grid[0].mark == this.state.grid[6].mark)
            {
                System.out.println("WIN!!");
                this.state.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.state.grid[0].mark));
                System.exit(0);
            }
        }
        if(this.state.grid[1].mark!=null && this.state.grid[4].mark!=null && this.state.grid[7].mark!=null)
        {
            if(this.state.grid[1].mark == this.state.grid[4].mark && this.state.grid[1].mark == this.state.grid[7].mark)
            {
                System.out.println("WIN!!");
                this.state.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.state.grid[1].mark));
                System.exit(0);
            }
        }
        if(this.state.grid[2].mark!=null && this.state.grid[5].mark!=null && this.state.grid[8].mark!=null)
        {
            if(this.state.grid[2].mark == this.state.grid[5].mark && this.state.grid[2].mark == this.state.grid[8].mark)
            {
                System.out.println("WIN!!");
                this.state.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.state.grid[2].mark));
                System.exit(0);
            }
        }
        if(this.state.grid[0].mark!=null && this.state.grid[4].mark!=null && this.state.grid[8].mark!=null)
        {
            if(this.state.grid[0].mark == this.state.grid[4].mark && this.state.grid[0].mark == this.state.grid[8].mark)
            {
                System.out.println("WIN!!");
                this.state.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.state.grid[0].mark));
                System.exit(0);
            }
        }
        if(this.state.grid[2].mark!=null && this.state.grid[4].mark!=null && this.state.grid[6].mark!=null)
        {
            if(this.state.grid[2].mark == this.state.grid[4].mark && this.state.grid[2].mark == this.state.grid[6].mark)
            {
                System.out.println("WIN!!");
                this.state.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",this.state.grid[2].mark));
                System.exit(0);
            }
        }
        if(this.state.grid[0].mark!=null && this.state.grid[1].mark!=null && this.state.grid[2].mark!=null && this.state.grid[3].mark!=null && this.state.grid[4].mark!=null && this.state.grid[5].mark!=null && this.state.grid[6].mark!=null && this.state.grid[7].mark!=null && this.state.grid[8].mark!=null)
        {
            JOptionPane.showMessageDialog(null,"DRAW!!!");
            System.exit(0);
        }
    }
}