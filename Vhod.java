package Redovalnica2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class Vhod {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        List<Redovalnica> seznamOcen = new ArrayList<>();
        
        ArrayList<Double> povprecja = new ArrayList<>();
        ArrayList<Integer> vseOcene = new ArrayList<>();


     


        while(true){
            System.out.println("Vnesite ime premdeta:");
            String imePredmeta = sc.nextLine();

            Redovalnica ocene = new Redovalnica(imePredmeta);


            System.out.println("Vnesite stevilo testov, ki jih imate pri tem predmetu");

            int stTestov = sc.nextInt();
            sc.nextLine();
            

            for (int j = 0; j<stTestov; j++){
                System.out.println("Vnesite stevilo moznih tock na " +(j+1)+". testu: ");
                double mozneTocke = sc.nextDouble();
                sc.nextLine();
                System.out.println("Vnesite stevilo dosezenih tock na " +(j+1)+". testu: ");
                double dosezeneTocke = sc.nextDouble();
                Test test = new Test(mozneTocke, dosezeneTocke);
                //ocene.dodajTest(test);
                vseOcene.add((Integer)test.getOcena());

            }

            seznamOcen.add(ocene);
            sc.nextLine();

            /*for (int j = 0; j<vseOcene.size(); j++){
                        int skupekOcen = 0;
                        skupekOcen += vseOcene.get(j);

                        povprecja.add((double)(skupekOcen/vseOcene.size()));
                    }
            */
        
        
            System.out.println("Predmet: " + ocene.getIme());
            System.out.println("Ocene: " + vseOcene.toString().replace("[", "").replace("]", ""));
            Double skupek = 0.0;
            for(int i = 0; i<vseOcene.size(); i++){
                
                skupek += vseOcene.get(i);
            }

            System.out.println("Povprecje: "+skupek/(double)vseOcene.size());

            Path pot = Paths.get("ocene.csv");




            try (Writer w = Files.newBufferedWriter(pot, StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE)){ 
                PrintWriter pw = new PrintWriter(w);
                pw.println("Predmet, vse ocene, povprecje");

                pw.println(String.join(", ", new String[]{
                    ocene.getIme(),
                    vseOcene.toString().replace("[", "").replace("]", "") + "",
                    Double.toString(skupek/(double)vseOcene.size())+""
                }));
                
            }catch(IOException e){
                System.out.println("Napaka:" + e.getMessage());
            }


            System.out.println("Zelite dodati nov predmet? J/N");

            if(sc.nextLine().equalsIgnoreCase("N")){
                System.out.println("Nasvidenje");
                break;
            }
            else{
                vseOcene.clear();
            }
        }

    




    }
}
