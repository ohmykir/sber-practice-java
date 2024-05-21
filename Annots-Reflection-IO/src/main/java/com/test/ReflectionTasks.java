package com.test;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.nio.file.Files.newDirectoryStream;

public class ReflectionTasks {
    private static final List<ParentClass> LIST = new ArrayList<>();
    private static final String PATH = "C:\\JAVALEARNING\\sber-practice-java\\Annots-Reflection-IO\\src\\main\\java\\com\\test";

    public static void init() throws ClassNotFoundException, IOException {
        LIST.add(new ChildClassOne());
        LIST.add(new ChildClassTwo());
        LIST.add(new ChildClassThree());

        Path directoryPath = Path.of(PATH + "\\log");
        if (!Files.exists(directoryPath)){
            Files.createDirectory(directoryPath);
        }

        for (ParentClass object : LIST) {
            int day = object.getClass().getAnnotation(Inheritance.class).dayOfWeek();
            createInstance(day, 1, "Hey!", true);
        }
    }

    private static void createInstance(int day, int value, String message, boolean isImportant) throws IOException {
        DataContainer instance;
        if (day == 1) {
            instance = new DataContainer(value * day, message, isImportant);
        } else if (day == 2) {
            instance = new DataContainer(value * day, message + message, !isImportant);
        } else {
            instance = new DataContainer(value * day, message, !(isImportant && day > 4));
        }
        goThroughMethods(instance);
    }

    private static void goThroughMethods(DataContainer data) throws IOException {
        ArrayList<Method> methods = new ArrayList<>();
        //набираем методы из всех классов
        for (ParentClass object : LIST) {
            Method[] ms = object.getClass().getDeclaredMethods();
            methods.addAll(Arrays.asList(ms));
        }

        //сортируем методы по приоритету
        methods.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                int priorOne = o1.getAnnotation(RepeatableAnnotation.class).priority();
                int priorTwo = o2.getAnnotation(RepeatableAnnotation.class).priority();
                return priorOne > priorTwo ? 1 : -1;
            }
        });

        refreshDirectory(PATH + "\\log");
        String date = LocalDateTime.now().toString().replace(":", "-");
        String filename = PATH + "\\log\\" + date + ".txt";
        Files.createFile(Path.of(filename));

        //запускаем методы и проверяем что поменялось
        for (Method method : methods) {
            Field[] fields = data.getClass().getDeclaredFields();
            try {
                data = (DataContainer) method.invoke(0, data);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e);
            }
            Field[] fieldsAfterMethod = data.getClass().getDeclaredFields();
            try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
                out.write("Method done, data changed - " + !Arrays.equals(fieldsAfterMethod, fields) + "\n");
            } catch (IOException e) {
                System.out.println("Error!");
            }
        }
    }

    private static void refreshDirectory(String path) throws IOException {
        int numberOfFiles = 0;
        try (DirectoryStream<Path> files = newDirectoryStream(Path.of(path))) {
            for (Path file : files) {
                numberOfFiles++;
            }
        }
        if (numberOfFiles > 2) {
            try (DirectoryStream<Path> files = newDirectoryStream(Path.of(path))) {
                for (Path file : files) {
                    Files.delete(file);
                }
            }
        }
    }
}
