import java.util.ArrayList;
import java.util.List;

public class Calculatrice {
    private List<Float> nombres;
    private float resul;

    public Calculatrice() {
        this.nombres = new ArrayList<>();
        this.resul = 0;
    }

    public float getResult() {
        return resul;
    }

    public void setNombres(List<Float> nombres) {
        this.nombres = new ArrayList<>(nombres);
    }

    public void add() {
        resul = 0;
        for (float num : nombres) {
            resul += num;
        }
    }

    public void mult() {
        if (nombres.isEmpty()) {
            resul = 0;
            return;
        }
        resul = 1;
        for (float num : nombres) {
            resul *= num;
        }
    }

    public static void main(String[] args) {
        Calculatrice calc = new Calculatrice();
        
        // Définition des nombres
        List<Float> nums = new ArrayList<>();
        nums.add(2f);
        nums.add(2f);
        nums.add(2f);
        
        calc.setNombres(nums);

        // Addition
        calc.add();
        System.out.println("Somme : " + calc.getResult());

        // Multiplication
        calc.mult();
        System.out.println("Produit : " + calc.getResult());
    }
}