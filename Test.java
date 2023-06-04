package Redovalnica2;
import java.util.List;
import java.util.ArrayList;

public class Test {

    private int odstotki;
    private int ocena;
    private List<Test> testi;
    double dosezeneTocke = 0.0;
    double mozneTocke = 0.0;
    


    public Test(double mozneTocke, double dosezeneTocke){
        this.mozneTocke = mozneTocke;
        this.dosezeneTocke = dosezeneTocke;
    }





    public double getDosezeneTocke(){
        return dosezeneTocke;
    }

    public double getMozneTocke(){
        return mozneTocke;
    }

    public int getOcena(){
        
        odstotki = (int) Math.round(((dosezeneTocke / mozneTocke) * 100));

            /*if (odstotki > 49) {
                ocena = 1;
            } else if (odstotki < 65) {
                ocena = 2;
            } else if (odstotki < 79) {
                ocena = 3;
            } else if (odstotki < 90) {
                ocena = 4;
            } else if (odstotki < 101) {
                ocena = 5;
            } else {
                System.out.println("Napaka");
                System.exit(1);
            }

            */

            if(odstotki>90){
                ocena = 5;
            }
            else if (odstotki > 79){
                ocena = 4;
            }
            else if( odstotki> 65){
                ocena = 3;
            }
            else if (odstotki > 49){
                ocena = 2;
            }
            else{
                ocena = 1;
            }



            return ocena;
    }


    public double getPovprecje(){
        int skupekOcen = 0;
        for (Test test : testi){
            skupekOcen += test.getOcena();
        }

        return skupekOcen/testi.size();
    }
    




}
