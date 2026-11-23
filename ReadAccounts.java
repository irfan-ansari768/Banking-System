package BankingSystem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class ReadAccounts {
    private String url;

    public ReadAccounts(String url) {
        this.url = url;
    }

    public LinkedList<String> getFirstNames() {
        LinkedList<String> firstNames = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                firstNames.add(parts[0].trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return firstNames;
    }

    public LinkedList<String> getLastNames() {
        LinkedList<String> lastNames = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                lastNames.add(parts[1].trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return lastNames;
    }

    public LinkedList<Integer> getAccounts() {
        LinkedList<Integer> accountNums = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                accountNums.add(Integer.parseInt(parts[2].trim()));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return accountNums;
    }

    public LinkedList<Integer> getBalances() {
        LinkedList<Integer> balances = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
				balances.add(Integer.parseInt(parts[3].trim()));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return balances;
    }
}