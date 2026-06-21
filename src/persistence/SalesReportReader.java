package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SalesReportReader {
    
    public static int readTransactions(String fileName){

        int transactions = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Enquanto houver linhas para ler, incrementa o contador
            while (br.readLine() != null) {
                transactions++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public static double readRevenue(String fileName){

        double revenue = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Enquanto houver linhas para ler, incrementa o contador
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                revenue = revenue + Double.parseDouble(data[4].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return revenue;
    }
}
