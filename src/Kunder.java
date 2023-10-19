import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Kunder {
    String temp;
    String name;
    String personNumber;
    LocalDate localDate = LocalDate.now();
    Boolean isValidKund = false;
    Boolean isKund = false;
    LocalDate localDateKund = null;
    String filePathKunder = "src/kunder.txt";
    String filePathPT = "src/PT.txt";
    String txt;


    public Kunder() {
    }

    public void checkKunder(String kund){

    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathKunder))){

         temp = bufferedReader.readLine();
        while (temp != null){
            if (temp.length() > 12){
                this.personNumber = temp.substring(0,10);
                temp = temp.substring(12);
            }
            if (temp.contains(kund) || kund.equals(this.personNumber)){
                isKund = true;
                this.name = temp;
                temp = bufferedReader.readLine();
                localDateKund = LocalDate.parse(temp);
                checkDate(localDateKund);

            break;

            }else {
            temp = bufferedReader.readLine();
            temp = bufferedReader.readLine();
            }
        }} catch (FileNotFoundException e) {
            System.out.println("Filen kunde inte hittas");
            } catch (IOException e) {
            System.out.println("IOException");
             }


    if (isKund == false){
        checkDate(localDateKund);
    }
        nollställ();


    }


    public void checkDate(LocalDate localDatekund){

if (localDatekund == null){
        System.out.println("Personen finns inte i filen och har sålunda aldrig varit medlem och är obehörig");
}else if (ChronoUnit.DAYS.between(localDatekund, localDate) > 365){
            System.out.println("Kunden är en före detta kund");
            this.isKund = true;

        } else if (ChronoUnit.DAYS.between(localDatekund, localDate) <= 365) {
            System.out.println("Kunden är en nuvarande medlem ");
            Path p = Paths.get(filePathPT);
            txt = "Namn: " + this.name + "\tPersonNummer: " + this.personNumber + "\tDatum: " + localDate;
            this.isValidKund = true;
            this.isKund = true;

            try (FileWriter fileWriter = new FileWriter(filePathPT, true);){


                fileWriter.write(txt);
                fileWriter.write("\n");

            } catch (IOException e) {
                System.out.println("Kunde inte skapa filen: " + e.getMessage());
            }


        }


    }

    public void nollställ(){
        this.localDateKund = null;
        this.isKund = false;

    }


}
