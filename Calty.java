class Calculatrice {
    public float nombre1; // premiere valeur
    public float nombre2; // deuxieme valeur
    public float resultat; // Ttroisieme valeur

    public float add(){
            resultat = nombre1 + nombre2; // Addition
            return resultat;
    }

    public float sub(){
            resultat = nombre1 - nombre2; // Soustraction
            return resultat;
    }

    public float div(){
            resultat = nombre1 / nombre2; // Division
            return resultat;
    }

    public float mult(){
            resultat = nombre1 * nombre2; // Multiplication
            return resultat;
    }


    public static void main(String[] args){
            Calculatrice calc = new Calculatrice();
            calc.nombre1 = 12;
            calc.nombre2 = 4;
            calc.add();
            System.out.println(calc.resultat);

}
public static void main(String[] args){
            Calculatrice calc = new Calculatrice();
            calc.nombre1 = 12;
            calc.nombre2 = 4;
            calc.sub();
            System.out.println(calc.resultat);

}
public static void main(String[] args){
            Calculatrice calc = new Calculatrice();
            calc.nombre1 = 12;
            calc.nombre2 = 4;
            calc.mult();
            System.out.println(calc.resultat);

}
public static void main(String[] args){
            Calculatrice calc = new Calculatrice();
            calc.nombre1 = 12;
            calc.nombre2 = 4;
            calc.div();
            System.out.println(calc.resultat);

}



}