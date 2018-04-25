import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
public class Stage extends JPanel {
    private final String CROSS="X";
	private final String CIRCLE="O";
    String[] state = new String[9];
    boolean win;
    boolean playerTurn;
    public Stage()
    {
        this.win=false;
        this.setLayout(new GridLayout(3,3));
        Cell upperLeft = new Cell(this,0);
        Cell upper = new Cell(this,1);
        Cell upperRight = new Cell(this,2);
        Cell left = new Cell(this,3);
        Cell center = new Cell(this,4);
        Cell right = new Cell(this,5);
        Cell lowerLeft = new Cell(this,6);
        Cell lower = new Cell(this,7);
        Cell lowerRight = new Cell(this,8);
        Player human = new Player(this,CROSS);
        Player ai = new Player(this,CIRCLE);
    }
    public void checkWin()
    {
        //123 456 789 - horizontal win
        //147 258 369 - vertical win
        //159 357 - diagonal win
        if(this.state[0]!=null && this.state[1]!=null && this.state[2]!=null)
        {
            if(this.state[0] == this.state[1] && this.state[0] == this.state[2])
            {
                System.out.println("WIN!!");
                this.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",(Cell.turn%2==0 ? CROSS : CIRCLE)));
                return;
            }
        }
        if(this.state[3]!=null && this.state[4]!=null && this.state[5]!=null)
        {
            if(this.state[3] == this.state[4] && this.state[3] == this.state[5])
            {
                System.out.println("WIN!!");
                this.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",(Cell.turn%2==0 ? CROSS : CIRCLE)));
                return;
            }
        }
        if(this.state[6]!=null && this.state[7]!=null && this.state[8]!=null)
        {
            if(this.state[6] == this.state[7] && this.state[6] == this.state[8])
            {
                System.out.println("WIN!!");
                this.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",(Cell.turn%2==0 ? CROSS : CIRCLE)));
                return;
            }
        }
        if(this.state[0]!=null && this.state[3]!=null && this.state[6]!=null)
        {
            if(this.state[0] == this.state[3] && this.state[0] == this.state[6])
            {
                System.out.println("WIN!!");
                this.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",(Cell.turn%2==0 ? CROSS : CIRCLE)));
                return;
            }
        }
        if(this.state[1]!=null && this.state[4]!=null && this.state[7]!=null)
        {
            if(this.state[1] == this.state[4] && this.state[1] == this.state[7])
            {
                System.out.println("WIN!!");
                this.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",(Cell.turn%2==0 ? CROSS : CIRCLE)));
                return;
            }
        }
        if(this.state[2]!=null && this.state[5]!=null && this.state[8]!=null)
        {
            if(this.state[2] == this.state[5] && this.state[2] == this.state[8])
            {
                System.out.println("WIN!!");
                this.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",(Cell.turn%2==0 ? CROSS : CIRCLE)));
                return;
            }
        }
        if(this.state[0]!=null && this.state[4]!=null && this.state[8]!=null)
        {
            if(this.state[0] == this.state[4] && this.state[0] == this.state[8])
            {
                System.out.println("WIN!!");
                this.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",(Cell.turn%2==0 ? CROSS : CIRCLE)));
                return;
            }
        }
        if(this.state[2]!=null && this.state[4]!=null && this.state[6]!=null)
        {
            if(this.state[2] == this.state[4] && this.state[2] == this.state[6])
            {
                System.out.println("WIN!!");
                this.win=true;
                JOptionPane.showMessageDialog(null,String.format("%s WON!!!",(Cell.turn%2==0 ? CROSS : CIRCLE)));
                return;
            }
        }
        if(this.state[0]!=null && this.state[1]!=null && this.state[2]!=null && this.state[3]!=null && this.state[4]!=null && this.state[5]!=null && this.state[6]!=null && this.state[7]!=null && this.state[8]!=null)
        {
            JOptionPane.showMessageDialog(null,"DRAW!!!");
        }
    }
}