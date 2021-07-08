package com.hillel.homework_16.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ConvertingUtilClass {
    private static ArrayList<String> parseValidNames(String path) {
        File dir = new File(path);
        String[] fileNames = dir.list();
        ArrayList<String> jsonYamlFiles_2 = new ArrayList<>();
        assert fileNames != null;
        for (String name : fileNames) {
            if (name.endsWith(".json") || name.endsWith(".yaml")) {
                assert false;
                jsonYamlFiles_2.add(name);
            }
        }
        return jsonYamlFiles_2;
    }

    public static ArrayList<String> getValidFileNames(String path) {
        return parseValidNames(path);
    }

    public static void jsonAsYaml(String path) throws Exception {
        if (!path.equals(FileUtilClass.getCurrentWorkingDirectory())) {
            String json;
            ArrayList<String> validNames = getValidFileNames(path);
            validNames.removeIf(string -> string.endsWith(".yaml"));
            Object[] names = validNames.toArray();
            for (Object o : names) {
                json = readToString(path + "/" + o);
                JsonNode jsonNodeTree = new ObjectMapper().readTree(json);
                String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
                String filePath = FileUtilClass.createFile(o, ".yaml");
                try (FileWriter writer = new FileWriter(filePath, false)) {
                    writer.write(jsonAsYaml);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        } else jsonAsYamlCurrentDir();
    }

    private static void jsonAsYamlCurrentDir() throws Exception {
        String json;
        String path = FileUtilClass.getCurrentWorkingDirectory();
        ArrayList<String> validNames = getValidFileNames(path);
        validNames.removeIf(string -> string.endsWith(".yaml"));
        Object[] names = validNames.toArray();
        for (Object o : names) {
            json = readToString(path + "/" + o);
            JsonNode jsonNodeTree = new ObjectMapper().readTree(json);
            String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
            String filePath = FileUtilClass.createFile(o, ".yaml");
            try (FileWriter writer = new FileWriter(filePath, false)) {
                writer.write(jsonAsYaml);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static void yamlAsJson(String path) throws Exception {
        if (!path.equals(FileUtilClass.getCurrentWorkingDirectory())) {
            String yaml;
            ArrayList<String> validNames = getValidFileNames(path);
            validNames.removeIf(string -> string.endsWith(".json"));
            Object[] names = validNames.toArray();
            for (Object o : names) {
                yaml = readToString(path + "/" + o);
                ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
                Object obj = yamlReader.readValue(yaml, Object.class);
                ObjectMapper jsonWriter = new ObjectMapper();
                String yamlAsJson = jsonWriter.writeValueAsString(obj);
                String filePath = FileUtilClass.createFile(o, ".json");
                try (FileWriter writer = new FileWriter(filePath, false)) {
                    writer.write(yamlAsJson);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        } else {
            yamlAsJsonCurrentDir();
        }
    }

    private static void yamlAsJsonCurrentDir() throws Exception {
        String yaml;
        String path = FileUtilClass.getCurrentWorkingDirectory();
        ArrayList<String> validNames = getValidFileNames(path);
        validNames.removeIf(string -> string.endsWith(".json"));
        Object[] names = validNames.toArray();
        for (Object o : names) {
            yaml = readToString(path + "/" + o);
            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
            Object obj = yamlReader.readValue(yaml, Object.class);
            ObjectMapper jsonWriter = new ObjectMapper();
            String yamlAsJson = jsonWriter.writeValueAsString(obj);
            String filePath = FileUtilClass.createFile(o, ".json");
            try (FileWriter writer = new FileWriter(filePath, false)) {
                writer.write(yamlAsJson);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static String readToString(String path) {
        StringBuilder content = new StringBuilder();
        try {
            Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                    .forEach(s -> content.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
