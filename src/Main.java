import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Kunder k = new Kunder();

        while (true){

            try{
            System.out.print("Skriv in namn eller person nummer: ");
            String kund = scanner.nextLine();

            if (kund.equals("exit")){
                break;
            }
            k.checkKunder(kund);
            }catch (Exception e){
                System.out.println("Försök igen");
            }
        }


    }
}