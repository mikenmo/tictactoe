
public class Player {
    private final int NEGINF = -9999;
    private final int POSINF =  9999;
    String marker;
    Stage stage;
    public Player(Stage stage, String marker)
    {
        this.marker = marker;
        this.stage = stage;
    }
    public int value(String[] state)
    {
        if state.checkWin(){
            return utility(state);
        }
    }
    public int utility(String[] state)
    {

    }
    public int getMin(String[] state)
    {

    }
    public int getMax(String[] state)
    {

    }
}