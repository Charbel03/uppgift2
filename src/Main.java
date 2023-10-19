import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Kunder k = new Kunder();

        while (true){
            try{
            System.out.println("Skriv 'exit' för att avsluta");
            System.out.print("Skriv in namn eller person nummer: ");
            String kund = scanner.nextLine();

            if (kund.equals("exit")){
                break;
            }
            k.checkKunder(kund);
            }catch (Exception e){
                System.out.println("Error");
            }
            System.out.print("\n");

        }

// https://github.com/Charbel03/uppgift2

    }
}