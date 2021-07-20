package com.hillel.homework_23.cache_service;

public class CacheServiceClass {
    public static void showCacheFeatures() throws InterruptedException {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);

        cacheImplClass.put("1", "Ford");
        cacheImplClass.put("2", "Audi");
        cacheImplClass.put("3", "Mustang");
        cacheImplClass.put("4", "Mitsubishi");
        cacheImplClass.put("5", "Lexus");
        cacheImplClass.put("6", "Infinity");

        System.out.println(cacheImplClass.get("1"));
        System.out.println(cacheImplClass.get("2"));
        System.out.println(cacheImplClass.get("3"));
        System.out.println(cacheImplClass.get("4"));
        System.out.println(cacheImplClass.get("5"));
        System.out.println(cacheImplClass.get("6"));

        System.out.println();
        System.out.println("Size before clean(by key): " + cacheImplClass.cacheMap.size());
        cacheImplClass.clear("1");
        System.out.println("Size after cleaning first key: " + cacheImplClass.cacheMap.size());

        System.out.println();
        cacheImplClass.clear();
        System.out.println("Size after cleaning cache: " + cacheImplClass.cacheMap.size());

        cacheImplClass.put("1", "Ford");
        cacheImplClass.put("2", "Audi");
        cacheImplClass.put("3", "Mustang");
        cacheImplClass.put("4", "Mitsubishi");
        cacheImplClass.put("5", "Lexus");
        cacheImplClass.put("6", "Infinity");

        System.out.println();
        System.out.println("Before expire: " + cacheImplClass.cacheMap.size());
        Thread.sleep(10_001L);
        cacheImplClass.clean();
        System.out.println("After expire: " + cacheImplClass.cacheMap.size());
    }
}
