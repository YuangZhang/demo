package com.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {

    public static void main(String[] args) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        ObjectNode node2 = mapper.createObjectNode();
        ObjectNode node3 = mapper.createObjectNode();
        node2.put("name2", "zya2");
        node2.put("name22", "zya22");
        node2.put("name23", "zya23");
        node3.put("name3", "zya3");
        ArrayNode array = mapper.createArrayNode();

        ArrayNode array2 = mapper.createArrayNode();
        array2.add(node2);
        array2.add(node3);

        node.set("110", array2);
        ArrayNode o = mapper.readValue(node.get("110").toString(), ArrayNode.class);
        array.add(node);

        ArrayNode objectNode = mapper.readValue("[[\"UXDbServer\",\"fanghaiqun\"],[\"UXSqlConnection\",\"haiqun\"],[\"originalState=Connecting\",\"1212\"]]", ArrayNode.class);
        JsonNode jsonNode = mapper.readTree("[[\"UXDbServer\",\"fanghaiqun\"],[\"UXSqlConnection\",\"haiqun\"],[\"originalState=Connecting\",\"1212\"]]");
        JSONObject json = new JSONObject();
        json.put("name", "zya");
        json.put("name1", "zya1");


        JSONArray array1 = JSON.parseArray("[[\"UXDbServer\",\"fanghaiqun\"],[\"UXSqlConnection\",\"haiqun\"],[\"originalState=Connecting\",\"1212\"]]");

        array2.forEach(s->{
            System.out.println(s.get("name2").asText());
        });
        System.out.println(array2);
    }
}
