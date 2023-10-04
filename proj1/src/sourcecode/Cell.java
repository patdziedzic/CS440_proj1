package sourcecode;

public class Cell {
    //COORDINATES
    private int row;
    private int col;

    //REGARDING OPENNESS
    private int numOpenNeighbors; //increment for each new open neighbor
    private boolean isOpen; //initialized false

    //REGARDING FLAMMABILITY
    private boolean onFire; //initialized false
    private double flammability; //flammability of the cell based on neighbors, initially 0
    private int k; //number of fire neighbours

    //REACHING NEIGHBORS OF CELLS
    public Cell up;
    public Cell down;
    public Cell left;
    public Cell right;
    public boolean isVisited;

    //Default Cell Constructor
    public Cell() {
        this.numOpenNeighbors = 0;
        this.isOpen = false;
        this.onFire = false;
        this.k = 0;
        this.flammability = 1-Math.pow((1-Main.q),k);
        try {
            this.up = Main.ship[row-1][col];
        } catch (ArrayIndexOutOfBoundsException ignore){}
        try {
             this.down = Main.ship[row+1][col];
        } catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            this.left = Main.ship[row][col-1];
        } catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            this.right = Main.ship[row][col+1];
        } catch (ArrayIndexOutOfBoundsException ignore){}
        
        this.isVisited = false;
    }

    //Cell Constructor given row and col
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.numOpenNeighbors = 0;
        this.isOpen = false;
        this.onFire = false;
        this.k = 0;
        this.flammability = 1-Math.pow((1-Main.q),k);
        try {
            this.up = Main.ship[row-1][col];
        } catch (ArrayIndexOutOfBoundsException ignore){}
        try {
             this.down = Main.ship[row+1][col];
        } catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            this.left = Main.ship[row][col-1];
        } catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            this.right = Main.ship[row][col+1];
        } catch (ArrayIndexOutOfBoundsException ignore){}
        
        this.isVisited = false;
    }

    public int getNumOpenNeighbors() {
        return numOpenNeighbors;
    }

    public void incNumOpenNeighbors() {
        this.numOpenNeighbors++;
    }


    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean open) {
        isOpen = open;
    }

    public boolean getOnFire() {
        return onFire;
    }

    public void setOnFire(boolean onFire) {
        this.onFire = onFire;
    }

    public double getFlammability() {
        return flammability;
    }

    public void setFlammability(double flammability) {
        this.flammability = flammability;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void incK(){
        k++;
        flammability = 1-Math.pow((1-Main.q),k);
    }

    public boolean getIsVisited(){ 
        return isVisited;
    }

    public void setIsVisited(boolean setMark){
        isVisited = setMark;
    }
/*
    private void changeNeighborK(int row, int col) {
        try {

        } catch (ArrayIndexOutOfBoundsException ignore) { }
    }
     */


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cell){
            Cell c = (Cell) obj;
            return c.row == this.row && c.col == this.col;
        }
        return false;
    }
}
