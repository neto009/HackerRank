import java.io.IOException;
import java.util.*;

public class NewSolution {

    public static void main(String[] args) throws IOException {
        List<List<String>> debts = new ArrayList<>();
        int tamanho = 1;
        List<String> current1  = new ArrayList<>();
        List<String> current2  = new ArrayList<>();
        List<String> current3  = new ArrayList<>();
        List<String> current4  = new ArrayList<>();
        List<String> current5  = new ArrayList<>();
        List<String> current6  = new ArrayList<>();

        for (int i = 0; i < tamanho; i++) {
            current1.add(0, "Alex");
            current1.add(1, "Blake");
            current1.add(2, "2");
        }

        for (int i = 0; i < tamanho; i++) {
            current2.add(0, "Blake");
            current2.add(1, "Alex");
            current2.add(2, "2");
        }

        for (int i = 0; i < tamanho; i++) {
            current3.add(0, "Casey");
            current3.add(1, "Alex");
            current3.add(2, "5");
        }

        for (int i = 0; i < tamanho; i++) {
            current4.add(0, "Blake");
            current4.add(1, "Casey");
            current4.add(2, "7");
        }

        for (int i = 0; i < tamanho; i++) {
            current5.add(0, "Alex");
            current5.add(1, "Blake");
            current5.add(2, "4");
        }

        for (int i = 0; i < tamanho; i++) {
            current6.add(0, "Alex");
            current6.add(1, "Casey");
            current6.add(2, "4");
        }

        debts.add(current1);
        debts.add(current2);
        debts.add(current3);
        debts.add(current4);
        debts.add(current5);
        debts.add(current6);

//        debts.forEach(i -> {
//            System.out.println(i);
//        });

        System.out.println("------------------------------------------------");

        System.out.println(smallestNegativeBalance(debts));
    }

    public static List<String> smallestNegativeBalance(List<List<String>> debts) {

        List<String> currentDebts = new ArrayList<>();

        Map<String, Integer> finalMap = new HashMap<>();
        for(int i = 0; i < debts.size(); i++) {
            finalMap.put(debts.get(i).get(0), 0);
        }

        for(int i = 0; i < debts.size(); i++) {
            for (Map.Entry<String, Integer> entrada : finalMap.entrySet()) {
                if (entrada.getKey().equals(debts.get(i).get(0))) {
                    int saldoNegativo = Integer.valueOf(entrada.getValue()) - Integer.valueOf(debts.get(i).get(2));
                    finalMap.put(debts.get(i).get(0), saldoNegativo);
                }
                if (entrada.getKey().equals(debts.get(i).get(1))) {
                    int saldoPositivo = Integer.valueOf(entrada.getValue()) + Integer.valueOf(debts.get(i).get(2));
                    finalMap.put(debts.get(i).get(1), saldoPositivo);
                }
            }
        }
        //System.out.println(finalMap);

        int currentValue = Collections.min(finalMap.values());

        for (Map.Entry<String, Integer> entrada : finalMap.entrySet()) {
            if (entrada.getValue() < 0 && entrada.getValue() == currentValue) {
                currentDebts.add(entrada.getKey());
            }
        }

        if (currentValue >= 0) {
            currentDebts.add("Ninguém está negativo!");
        }
        //System.out.println(currentDebts);

        return currentDebts;
    }
}
