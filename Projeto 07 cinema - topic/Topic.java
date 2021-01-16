import java.util.ArrayList;

class Passageiros{

    String nome;
    int idade;

    Passageiros(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String toString(){
        return nome + ":" + idade;
    }
}

class Carro{

    ArrayList<Passageiros> cadeiras;
    int qtdPreferencial;

    Carro(int qtd, int qtdPreferencial){
        this.qtdPreferencial = qtdPreferencial;
        this.cadeiras = new ArrayList<>();

        for(int i=0; i < qtd; i++)
            cadeiras.add(null);
    }

    // boolean descer(String nome){
    //     return true;
    // }

    void subir(String nome, int idade){
        
        for(int i=0; i < cadeiras.size(); i++){
            
            if(idade >= 60 && (i < qtdPreferencial) && cadeiras.get(i) == null){
                cadeiras.set(i, new Passageiros(nome, idade));
                System.out.println("1");
                return;
            }

            if(idade >= 60 && (i > qtdPreferencial) && cadeiras.get(i) == null){
                cadeiras.set(i, new Passageiros(nome, idade));
                System.out.println("2");
                return;
            }

            if(i >= qtdPreferencial && cadeiras.get(i) == null){
                cadeiras.set(i, new Passageiros(nome, idade));
                System.out.println("3");
                return;
            }
        }
    }

    public String toString(){
        String saida = "[";
        int preferencial = qtdPreferencial;

        for(Passageiros cadeiras : cadeiras){

            if(preferencial != 0 && cadeiras == null){
                saida += " @ ";
                preferencial -= 1;
            }else

            if(preferencial == 0 && cadeiras == null){
                saida += " = ";
            }else
         
                saida += " " + cadeiras + " ";
        }
        return saida + "]";
    }
}

public class Topic{
    public static void main(String[] args){

        Carro carro = new Carro(5, 2);

        carro.subir("davi", 17);
        carro.subir("joão", 103);
        carro.subir("maria", 92);
        carro.subir("jorge", 18);

        System.out.println(carro);
    }
}


// for(int i=0; i < qtdPreferencial; i++){
//     if(cadeiras == null)
//         saida += " @ ";
// }

// for(Passageiros cadeiras : cadeiras){
//     if(preferencial != 0 && cadeiras == null){
//         saida += " @ ";
//         preferencial -= 1;

//     }else if(preferencial == 0 && cadeiras == null){
//         saida += " = ";
//     }else 
//         saida += " " + cadeiras + " ";
// }