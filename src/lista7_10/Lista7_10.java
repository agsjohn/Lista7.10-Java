package lista7_10;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Lista7_10 {
    public static void main(String[] args) {
        final int TIMES = 5;
        String nomes[] = new String [TIMES];
        int pontos[][] = new int [TIMES][TIMES-1];
        int l, c, cont, cont2, gols1, gols2, soma=0;
        for(l = 0; l < TIMES; l++){
            nomes[l] = JOptionPane.showInputDialog("Digite o nome do %iº time: ", l + 1);
        }
        cont = 0;
        cont2 = 1;
        String placares = "";
        for(l = 0; l < TIMES; l++){
            for(c = cont; c < TIMES - 1; c++){
                gols1 = (int) (Math.random() * 5);
                gols2 = (int) (Math.random() * 5);
                placares += "Placar de "+nomes[l]+" contra "+nomes[l + cont2]+ ": "+gols1+" x "+gols2+"\n";
                if(gols1 > gols2){
                    pontos[l][c] = 3;
                    pontos[l + cont2][cont] = 0;
                }
                if(gols1 < gols2){
                    pontos[l][c] = 0;
                    pontos[l + cont2][cont] = 3;
                }
                if(gols1 == gols2){
                    pontos[l][c] = 1;
                    pontos[l + cont2][cont] = 1;
                }
                cont2++;
            }
            cont2 = 1;
            cont++;
        }
        cont = 1;
        cont2 = 1;
        String times = "";
        times += ("Times: \n");
        for(l = 0; l < TIMES; l++){
            times += ((l + 1) +" - "+nomes[l]+" \n");
        }
        times += ("\n");
        for(l = - 2; l < TIMES; l++){
            for(c = - 1; c < TIMES - 1; c++){
                if(l >= 0 && c >= 0){
                    if(c == TIMES - 2){
                        times += (""+pontos[l][c]+"\n");
                    } else{
                        times += (""+pontos[l][c]+"\t");
                    }
                } else{
                    if(l == - 2 && c == - 1){
                        times+=("\t");
                    }   
                    if(l == - 2 && c >= 0){
                        if(c == TIMES - 2){
                            times += ("Jogo"+c + 1+"\n");
                        }else{
                            times += ("Jogo"+c + 1+"\t");
                        }
                    }       
                    if(l == - 1 && c == - 1){
                        times += ("Times\t");
                    }
                    if(l == - 1 && c >= 0){
                        times += (cont2+"\t");
                        cont2++;
                    }
                    if(l >= 0 && c == - 1){
                        if(l == 0){
                            times += ("\n");
                        }
                        times += (cont+"\t");
                        cont++;
                    }
                }
            }
        }
        times += ("\n");
        for(l = 0; l < TIMES; l++){
            for(c = 0; c < TIMES - 1; c++){
                soma +=pontos[l][c];
            }
            times += ("Total de pontos "+nomes[l]+": "+soma+"\n");
            soma = 0;
        }
        JOptionPane.showMessageDialog(null, new JTextArea(placares+times));
    }    
}
