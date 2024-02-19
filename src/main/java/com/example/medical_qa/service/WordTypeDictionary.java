package com.example.medical_qa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordTypeDictionary {
    private Map<String, List<String>> wordTypeDict;

    public WordTypeDictionary() {
        this.wordTypeDict = new HashMap<>();
    }

    public void addWordType(String word, String type) {
        // 如果词汇已经在字典中，则将类型添加到对应的类型列表中；否则，创建新的类型列表并添加到字典中
        if (wordTypeDict.containsKey(word)) {
            List<String> types = wordTypeDict.get(word);
            types.add(type);
        } else {
            List<String> types = new ArrayList<>();
            types.add(type);
            wordTypeDict.put(word, types);
        }
    }

    public List<String> getWordTypes(String word) {
        // 获取词汇对应的类型列表
        return wordTypeDict.getOrDefault(word, new ArrayList<>());
    }

    public static void main(String[] args) {
        WordTypeDictionary dictionary = new WordTypeDictionary();

        // 添加示例数据
        dictionary.addWordType("头痛", "disease");
        dictionary.addWordType("头痛", "symptom");

        // 获取词汇对应的类型列表
        List<String> types = dictionary.getWordTypes("头痛");
        System.out.println("词汇\"头痛\"的类型列表：" + types);
    }
}
