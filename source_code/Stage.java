import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Stage extends JPanel 
{
    private final String CROSS="X";
	private final String CIRCLE="O";
    State state;
    
    public Stage()
    {
        this.state = new State(this);
        this.setLayout(new GridLayout(3,3));
        if(!this.state.playerTurn)
        {
            this.state.grid[this.aiMove()].markCell(CIRCLE);
        }
    }
    // public ArrayList<Integer> actions(State s)
	// {
	// 	ArrayList <Integer> action = new ArrayList <Integer> ();
	// 	State dummy;
    //     int i;
	// 	for(i=0;i<9;i++)
    //     {
    //         dummy = new State(s);
    //         if(!dummy.grid[i].marked)
    //         {
    //             action.add(i);
    //         }
    //         dummy = null;
    //     }
	// 	return action;  
	// }

    public int aiMove()
    {   
        int i;
        for(i=0;i<9;i++)
        {
            if(!state.grid[i].marked)
            {
                return i;
            }
        }
        return -1;
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