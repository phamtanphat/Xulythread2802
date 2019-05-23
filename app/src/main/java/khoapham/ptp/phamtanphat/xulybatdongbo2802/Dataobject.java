package khoapham.ptp.phamtanphat.xulybatdongbo2802;

public class Dataobject {
    private int a;
    private int b;
    private int laco;
    public Dataobject(int a, int b , int laco) {
        this.a = a;
        this.b = b;
        this.laco = laco;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getLaco() {
        return laco;
    }

    public void setLaco(int laco) {
        this.laco = laco;
    }
    public int tinhTong(){
        return  a + b;
    }
}
