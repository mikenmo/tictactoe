import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class OnClick implements ActionListener 
{
    int turn; 
    Cell cell;
    Stage stage;
    public OnClick(Cell cell,Stage stage)
    {
        this.cell = cell;
        this.stage = stage;
    }
    public void actionPerformed(ActionEvent e) {
        if(!stage.win){
            if(!cell.marked)
            {
                cell.markCell(Stage.playerTurn);
            }
        }
    }
}