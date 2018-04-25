import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
public class Cell extends JButton
{
    private final String CROSS="X";
	private final String CIRCLE="O";
    static int turn = 0;
    boolean marked;
    String mark;
    int index;
    Stage stage;
    public Cell(Stage stage, int index)
    {
        this.marked=false;
        this.index=index;
        this.stage=stage;
        stage.add(this);
        try
        {
            Image img = ImageIO.read(getClass().getResource("img/empty.png"));
            this.setIcon(new ImageIcon(img));
        }
        catch(IOException ex)
        {
            System.out.println("Image files are missing! Please redownload or recheck the files!");
        }
        this.addActionListener(new OnClick(Cell.turn,this,this.stage));
    }
    public void markCell(int turn)
    {
        try
        {
            Image img;
            if(turn%2==0)
            {
                img = ImageIO.read(getClass().getResource("img/cross.png"));
                this.mark=CROSS;
                this.stage.state[this.index] = CROSS;
            }
            else
            {
                img = ImageIO.read(getClass().getResource("img/circle.png"));
                this.mark=CIRCLE;
                this.stage.state[this.index] = CIRCLE;
            }
            this.setIcon(new ImageIcon(img));
            this.stage.checkWin();
            Cell.turn+=1;
            this.marked=true;
        }
        catch(IOException ex)
        {
            System.out.println("Image files are missing! Please redownload or recheck the files!");
        }
        
    }
}