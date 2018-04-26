import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
public class Cell extends JButton
{
    private final String CROSS="X";
	private final String CIRCLE="O";
    boolean marked;
    String mark;
    Stage stage;
    public Cell(Stage stage)
    {
        this.marked=false;
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
        this.addActionListener(new OnClick(this,this.stage));
    }
    public void markCell(String mark)
    {
        try
        {
            if(mark.equals(CROSS))
            {
                Image img;
                img = ImageIO.read(getClass().getResource("img/cross.png"));
                this.mark=mark;
                this.setIcon(new ImageIcon(img));
                this.stage.checkWin();
                this.marked=true;
            }
            else
            {
                Image img;
                img = ImageIO.read(getClass().getResource("img/circle.png"));
                this.mark=mark;
                this.setIcon(new ImageIcon(img));
                this.stage.checkWin();
                this.marked=true;
            }
            
        }
        catch(IOException ex)
        {
            System.out.println("Image files are missing! Please redownload or recheck the files!");
        }
        
    }
}