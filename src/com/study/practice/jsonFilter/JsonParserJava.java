package com.study.practice.jsonFilter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonParserJava {

    public static void main(String[] args){
        System.out.println("-- Test --");
        List<String> inputs = new ArrayList<>();
        inputs.add("address");
        inputs.add("EQUALS");
        inputs.add("Mumbai");
        System.out.println(apiResponseParse(inputs, 3));

    }

    public static List<Integer> apiResponseParse(List<String> inputList, int size){
        List<Integer> finalOutPut = new ArrayList<>();
        String operationEqual = "EQUALS";
        String operationIn = "IN";
        String fieldName = inputList.get(0);
        String opeType = inputList.get(1);
        String inputValue = inputList.get(2);
        JSONArray array = apiJsonData();

        if(operationEqual.equals(opeType)){
            finalOutPut.add(filterByEqualOpe(array, fieldName, inputValue));
        } else if(operationIn.equals(opeType)){

        } else {
            finalOutPut.add(-1);
        }
        return finalOutPut;
    }

    public static int filterByEqualOpe(JSONArray array, String fieldName, String inputValue){
        int val = -1;
        String[] strAr = fieldName.split("\\.");
        if(strAr.length > 1){
            int size = strAr.length;
            for(int x = size; x < size; x++){

            }


        }
        for(int i =0; i < array.size(); i++){
            JSONObject objs = (JSONObject) array.get(i);
           // JSONObject jsonChildObject = (JSONObject)objs.get("");
            if(objs.containsKey(fieldName) && objs.get(fieldName).equals(inputValue)){
                val  = 1;
                break;
            }
        }
        return val;
    }

    public static Object getObjByFiledName(JSONArray array, String fieldName){
        Object obj = null;
        for(int i =0; i < array.size(); i++){
            JSONObject objs = (JSONObject) array.get(i);
            if(objs.containsKey(fieldName)){
                return obj = objs.get(fieldName);
            }
        }
        return obj;
    }





    public static JSONArray apiJsonData(){
        JSONArray array = new JSONArray();
        JSONParser jsonParser = new JSONParser();
            String path = "D:/Hemakanta/JavaXmlIntellij/java-program-practice/json-api-data.json";
        try {
            FileReader reader = new FileReader(path);
            Object obj = jsonParser.parse(reader);
            array = (JSONArray)obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
}
