import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class OnClick implements ActionListener 
{
    private final String CROSS="X";
	private final String CIRCLE="O";

    Cell cell;
    Stage stage;
    public OnClick(Cell cell,Stage stage)
    {
        this.cell = cell;
        this.stage = stage;
    }
    public void actionPerformed(ActionEvent e) {
        if(!stage.state.win){
            if(!cell.marked)
            {
                cell.markCell(CROSS);
                this.stage.state.grid[this.stage.aiMove()].markCell(CIRCLE);
            }
        }
    }
}