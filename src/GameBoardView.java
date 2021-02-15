

public class GameBoardView {
    public static final int height = 800, width = 800;
    public static final int grid_size = 10;


    public GameBoardView() {
        new GameWindow(height, width, grid_size,"Minesweeper", this);

    }

    public static void main(String[] args) {
        new GameBoardView();
    }


    }
