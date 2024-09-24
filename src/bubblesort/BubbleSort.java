/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fabri
 */
public class BubbleSort {
    static int trocas=0;
    static int comparacoes=0;
    
    static void troca(Integer[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
    static void bSort(Integer v[], int n){
        for(int fase=1;fase<n;fase++)
            for(int j=0;j<n-fase;j++)
                if(v[j]>v[j+1])
                    troca(v,j,j+1);
    }
    
     static void bSortComentado(Integer v[]){
        int n = v.length;
        boolean flagTroca;
        for(int fase=1;fase<n;fase++){
            flagTroca = false;
            System.out.println("Fase:"+fase);
            mostrarVetor(v);
            for(int j=0;j<n-fase;j++){
                System.out.printf("[%d]>[%d]\n",v[j],v[j+1]);
                comparacoes++;
                if(v[j]>v[j+1]){
                    System.out.println("Trocou");
                    trocas++;
                    troca(v,j,j+1);
                    mostrarVetor(v);
                    flagTroca=true;
                }// fim for if
            }// fim for j
            if(flagTroca==false){
                System.out.println("Vetor ja esta ordenado.");
                break;
            }
        }// fim for fase
    }

    
    static Integer[] gerarVetor(int n, int max){
        Random rand = new Random();
        Integer[] vetor = new Integer[n];
        for(int i=0;i<n;i++)
            vetor[i] = rand.nextInt(max)+1;
        
        return vetor;
    }
    
    static void mostrarVetor(Integer[] v){
          int tamanho = v.length;
          for(int i=0;i<tamanho;i++)
              System.out.print(v[i]+ "|");
          System.out.println("");
    }


    public static void main(String[] args) {
        //Integer[] meuVetor = gerarVetor(10, 100);
        Scanner scanner = new Scanner(System.in);
        Integer[] meuVetor = new Integer[5];
        System.out.println("Dados para o vetor");
        for(int i=0;i<5;i++)
            meuVetor[i] = scanner.nextInt();
        System.out.println("Vetor Gerado");
        mostrarVetor(meuVetor);
        bSortComentado(meuVetor);
        System.out.println("Vetor Ordenado");
        mostrarVetor(meuVetor);
        System.out.println("Comparacoes:"+comparacoes);
        System.out.println("Trocas:"+trocas);
    }
    

    
}
