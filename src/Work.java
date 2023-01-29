import java.util.*;

public class Work {
    public static void ork() {
        Random rand = new Random();
        List<Integer> list = randNumbers(rand);
        System.out.println(list);
        double[] dich = mathMethod(list);
        /* System.out.println(evenNumbers(list));
         */ // Пусть дан произвольный список целых чисел, удалить из него четные числа

        /*
        System.out.println("Минимальное значение в списке - " + (int) (dich[0]) + ". Максимальное значение в списке - " +
                (int) (dich[1]) + ". Cреднее арифметическое всех элементов в списке - " + dich[2]);
         */ // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.

//        long endTime = System.currentTimeMillis();
//        Collections.sort(list);
//        System.out.println(list);
//        long endTime2 = System.currentTimeMillis();
//        System.out.println("Скорость встроенного сортировщика для коолекций: " + (endTime2 - endTime));

        /*
        long endTime = System.currentTimeMillis();
        List<List<Integer>> seplist = listSeparation(list);
        System.out.println(mergeList(seplist));
        long endTime2 = System.currentTimeMillis();
        System.out.println("Скорость сортировки слиянием: " + (endTime2 - endTime));
         */ // Реализовать алгоритм сортировки слиянием
    }
    static List<Integer> randNumbers(Random random) {
        List<Integer> list1 = new ArrayList<>();
        int size = 10000;
        for (int i = 0; i < size; i++) {
            list1.add(i, random.nextInt(9999));
        }
        return list1;
    }

    static List<Integer> evenNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                --i;
            }
        }
        return list;
    }

    static double[] mathMethod(List<Integer> list) {
        int maxValue = Collections.max(list);
        int minValue = Collections.min(list);
        double average = 0;
        for (int i = 0; i < list.size(); i++) {
            average += list.get(i);
        }
        average = average / list.size();
        return new double[] {minValue, maxValue, average};
    }

    static List<List<Integer>> listSeparation(List<Integer> list){
        List<List<Integer>> templist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> templist2 = new ArrayList();
            templist2.add(list.get(i));
            templist.add(templist2);
        }
        return templist;
    }
    static List<List<Integer>> mergeList(List<List<Integer>> templist) {
        if (templist.size() == 1) {
            return templist;
        }
        else {
            List<List<Integer>> merger = new ArrayList<>();
            for (int i = 1; i < templist.size(); i++) {
                List<Integer> templist2 = new ArrayList();
                if ((i%2 == 0) && (i+1 == templist.size())) {
                    merger.add(templist.get(i));
                }
                else {
                    int count = 0;
                    for (int j = 0; j < (templist.get(i)).size(); j++){
                        if (templist.get(i).get(j) > templist.get(i - 1).get(count)) {
                            templist2.add(templist.get(i - 1).get(count));
                            if (count + 1 == templist.get(i-1).size()) {
                                while (j < (templist.get(i)).size()) {
                                    templist2.add(templist.get(i).get(j));
                                    j++;
                                }
                            }
                            count++;
                            j--;
                        } else {
                            templist2.add(templist.get(i).get(j));
                            if (j + 1 == templist.get(i).size()) {
                                while (count < (templist.get(i - 1)).size()) {
                                    templist2.add(templist.get(i - 1).get(count));
                                    count++;
                                }
                            }
                        }
                    }
                    merger.add(templist2);
                }
                if ((i+2) < templist.size()) {i++;} // чтобы переходит ьк след паре для сравненмя, если есть пара
            }
            return mergeList(merger);
        }
    }
}
