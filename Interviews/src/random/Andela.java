package random;

public class Andela {

    public Andela(){
        String res = "P..P.";
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        String prev = "";
        boolean isSwitch = false;

        for (String a: res.split("")){
            if (a.equals("P") && !prev.equals("P")){
                if (counter < 5){
                    counter++;
                }
                sb.append(counter);
            }
            else if (a.equals("O") && !prev.equals("O")){
                if (counter > 0){
                    counter--;
                }
                sb.append(counter);
            }
            else if (a.equals(".")){
                if (prev.equals("O")){
                    if (counter > 0){
                        counter--;
                    }
                }
                else if (prev.equals("P")){
                    if (counter < 5){
                        counter++;
                    }
                }
                sb.append(counter);
            }
            else{
                sb.append(counter);
            }
            if (a.equals("P")||a.equals("O")){
                prev = a;
            }

        }

        System.out.println(sb);
    }
    public static void main(String[] args) {
        new Andela();
    }
}
