package random;

public class MultiplicationTable {

    public MultiplicationTable(){
        int a = 10;
        int b = 10;
        int charSpacing =  (int)Math.log10(a*b)+2;

        for (int i = 1; i <= a; i++){
            for (int j = 1; j <= b; j++){
                int multiplication = i * j;
                System.out.printf("%"+charSpacing+"d", multiplication);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        MultiplicationTable mt = new MultiplicationTable();
    }
}
