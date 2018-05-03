import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame
{
	public MyFrame ()
	{
        this.setPreferredSize(new Dimension(300,300));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        Container container = this.getContentPane();
        Stage stage = new Stage();
        container.add(stage, BorderLayout.CENTER);
        
        stage.setFocusable(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
}