class Block{
    int x;
    int y;
    private int id;
    private int xcount;

    Block(int x, int y, int id){
        this.x = x;
        this.y = y;
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
    public int getXcount(){ return xcount; }
        
}