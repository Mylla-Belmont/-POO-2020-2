import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class sacolaPresente  {       //Classe para caracterizar os presentes
    String nomePresente;
    int resistencia;
    int qtdPresentes;

    sacolaPresente (String nomePresente, int resistencia, int qtdPresentes){   
        this.nomePresente = nomePresente;
        this.resistencia = resistencia;
        this.qtdPresentes = qtdPresentes;
    }

    int pacotePresente(Random random){    //Especificar qual presente

        ArrayList<String> conteudoPresente = new ArrayList<String>();

        conteudoPresente.add("palito de dente");
        conteudoPresente.add("poster do Felipe Neto");
        conteudoPresente.add("Iphone 12 pro max");
        conteudoPresente.add("fone de ouvido");
        conteudoPresente.add("estojo de maquiagem");
        conteudoPresente.add("1k de arroz");
        conteudoPresente.add("frigobar da polishop");
        conteudoPresente.add("Play Station 5");




        // int objeto = random.nextInt(7);         //Usar array
            
            // if(objeto == 0){        //Adicionar resistencia depois
            //     nomePresente = "palito de dente";
            //     qtdPresentes = 7;
            //     return 0;
            // }
            // if(objeto == 1){
            //     nomePresente = "Iphone 12 pro max";
            //     qtdPresentes = 6;
            //     return 1;
            // }
            // if(objeto == 2){
            //     nomePresente = "fone de ouvido";
            //     qtdPresentes = 5;
            //     return 2;
            // }
            // if(objeto == 3){
            //     nomePresente = "1k de arroz";
            //     qtdPresentes = 4;
            //     return 3;
            // }
            // if(objeto == 4){        //Adicionar resistencia depois
            //     nomePresente = "poster do Felipe Neto";
            //     qtdPresentes = 3;
            //     return 0;
            // }
            // if(objeto == 5){
            //     nomePresente = "estojo de maquiagem";
            //     qtdPresentes = 2;
            //     return 1;
            // }
            // if(objeto == 6){
            //     nomePresente = "frigobar da polishop";
            //     qtdPresentes = 1;
            //     return 2;
            // }
            // if(objeto == 7){
            //     nomePresente = "Play Station 5";
            //     qtdPresentes = 1;
            //     return 3;
            // }
        return 0;
    }

    public String toString() {
        return nomePresente + ": " + qtdPresentes;
    }

    public static void main(String[] args) {

        sacolaPresente presente = new sacolaPresente("", 0, 0);
        System.out.println(presente);
    }
}

class Cachorro  {       //Classe para caracterizar cachorro
    int barriga;
    int maxBarriga;

    Cachorro (int barriga, int maxBarriga){
        this.barriga = barriga;
        this.maxBarriga = maxBarriga;
    }

    void comer(){
        if(barriga <= maxBarriga){
            System.out.println("Já estou cheio!");
        }else
            System.out.println("Presentes! Delicius!!!");
    }

    boolean vomitar(){
        if(barriga != 0){
            System.out.println("O cachorro vomitou o presente");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
        Cachorro cachorro = new Cachorro(0, 0);

        System.out.println(cachorro);
    }
}

class Personagens  {        //Classe para caracterizar personagens
    int vida;
    boolean recurso;
    int poderRecurso;
    
    Personagens(int vida, int energia, Boolean recurso, int poderRecurso){
        this.vida = vida;
        this.recurso = recurso;
        this.poderRecurso = poderRecurso;
    }

    void brigar(Personagens other){     //FALTA adicionar entrada de parametros na main
        if(this.poderRecurso > other.poderRecurso){
            other.vida -= this.poderRecurso;
            this.recurso = false;
        }
        if(other.poderRecurso > this.poderRecurso){
            this.vida -= other.poderRecurso;
            other.recurso = false;
        }
    }

    public String toString() {
        return "Vida: " + vida + "/100";
    }

    public static void main(String[] args) {

        Personagens papaiNoel = new Personagens(100, 0, false, 0);
        Personagens grinch = new Personagens(100, 0, false, 0);
        sacolaPresente presente = new sacolaPresente("", 0, 0);

        System.out.println(papaiNoel);
        System.out.println(grinch);
        System.out.println(presente);
    }
}

public class felizNatal {       //Classe interativa

    public static void main(String[] args) {

        Personagens papaiNoel = new Personagens(100, 0, false, 0);
        Personagens grinch = new Personagens(100, 0, false, 0);
        sacolaPresente presente = new sacolaPresente("", 0, 0);
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while(true){

            System.out.println("\nO que você vai fazer?");
            String line = scanner.nextLine();
            String[] input = line.split(" ");

            if(input[0].equals("end")){
                System.out.println("\nPAPAI NOEL: - Não me deixe aqui sozinho!");
                break;

            }else if(input[0].equals("presentes")){ 
                System.out.println("Papai Noel: " + papaiNoel);

            }else if(input[0].equals("jogar")){

                System.out.println("\nVocê jogou um presente.");
                System.out.println("\n");
                
                if(!papaiNoel.recurso && random.nextBoolean()){    //Se não tiver recurso nenhum pode pegar presente
                    papaiNoel.recurso = true;
                    papaiNoel.poderRecurso = presente.pacotePresente(random);
                    papaiNoel.brigar(grinch);
                    System.out.println("Papai noel pegou um " + presente.nomePresente);
                    
                }else if(!grinch.recurso){
                    grinch.recurso = true;
                    grinch.poderRecurso = presente.pacotePresente(random);
                    grinch.brigar(papaiNoel);
                    System.out.println("Grinch pegou um " + presente.nomePresente);

                }else{
                    //fazer cachorro comer presente
                    System.out.println("Ninguém pegou o presente");
                }
            }else if(line.equals("vomitar")){

            }else
                System.out.println("Fail: Comano invélido");

            System.out.println("Papai Noel:" + papaiNoel);
            System.out.println("Grinch: " + grinch);
        }
        scanner.close();
    }
}


//Resolver poder dos presentes
//Melhorar metodo personagem
//Melhorar classe presente (adicionar mais atributos - resistencia objetos para que eles se quebrem)
//Fazer classe cachorro
//Melhorar entrada de valores - tornar mais facil
//Sofrer dano
//retirar input