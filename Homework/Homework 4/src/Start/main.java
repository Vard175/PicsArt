package Start;

import Humans.Writer;

import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        // Bubble Sort Implementation 1
        int[] arr = {1, 0, -7, 4, 2, -68};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Bubble Sort Implementation 2
        arr = new int[]{1, 0, -7, 4, 2, -68};
        boolean b = true;
        int stepsCount = 0;

        while (b) {
            b = false;
            for (int i = 0; i < arr.length - stepsCount - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    b = true;
                }
            }
            stepsCount++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Writer Class
        System.out.println();
        Writer georgeOrwell = new Writer();
        georgeOrwell.setBirthYear(1903);
        georgeOrwell.setDeathYear(1950);
        georgeOrwell.setWorks(new String[]{"1984", "Animal Farm"});
        System.out.println("George Orwell was born in " + georgeOrwell.getBirthYear());
        System.out.println("Orwell's most famous works are: ");
        georgeOrwell.getWorks();

        System.out.println();
        Writer hermannHesse = new Writer();
        hermannHesse.setName("Hermann");
        hermannHesse.setSurName("Hesse");
        hermannHesse.setMarried(true);
        hermannHesse.setGenre("Fiction");
        hermannHesse.setNationality("German");
        hermannHesse.setWorks(new String[]{"Demian", "SteppenWolf", "Siddhartha"});
        hermannHesse.IntroduceYourself();
        hermannHesse.Write();


        System.out.println();
        Writer williamSaroyan = new Writer();
        williamSaroyan.setBirthYear(1908);
        williamSaroyan.setDeathYear(1981);
        williamSaroyan.setMarried(true);
        williamSaroyan.setGenre("Novels,short stories");
        williamSaroyan.setWorks(new String[]{"The Time of Your Life", "Fresno Stories", "Little Children"});
        System.out.println(williamSaroyan.isMarried());
        williamSaroyan.getGenre();
        williamSaroyan.getWorks();
        williamSaroyan.Write();

    }
}
