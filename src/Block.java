// Represents each cell of the board

class Block{
    private int id; // unique color
    private int xcount; // represents if a block is safe or not, 0 - safe, >0 - not safe

    Block(int id){
        this.id = id;
        this.xcount = 0;
    }

    @Override
    public String toString() {
        return "(" + id + "," + xcount + "), ";
    }

    public void addx(){
        xcount++;
    }
    public void delx(){
        if(xcount > 0) xcount--;
    }
    public int getXcount(){
        return xcount; 
    }
    
}