package Redovalnica2;

import java.util.ArrayList;
import java.util.List;

public class Redovalnica {
    private String imePredmeta;
    private List<Test> testi;
    


    public Redovalnica(String imePredmeta){
        this.imePredmeta = imePredmeta;
        this.testi = new ArrayList<>();
    }

    public List<Test> getTesti(){
        return testi;
    }

    public void dodajTest(Test test){
        testi.add(test);
    }

    public String getIme(){
        return imePredmeta;
    }

    public void printOcene() {
        System.out.println("Ocene:");
        for (Test test : testi) {
            System.out.println("Test: " + test.getOcena());
        }
    }


   public String toString(){
        StringBuilder sb = new StringBuilder();

        for(Test test: testi){
            sb.append(Integer.toString(test.getOcena()));
            sb.append(" ");
        }

        return sb.toString().trim();
    }




}
