import com.hillel.homework_23.cacheService.CacheImplClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class CacheTestClass {
    @Test
    public void testPut() {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);

        boolean isAdded = cacheImplClass.put("1", "Ford");
        Assert.assertTrue(isAdded);
    }

    @Test
    public void testPutNull() {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);

        boolean isAdded = cacheImplClass.put(null, null);
        Assert.assertFalse(isAdded);
    }

    @Test
    public void testClean() throws InterruptedException {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);
        cacheImplClass.put("1", "Ford");
        int expected = 0;
        Thread.sleep(10_001L);
        cacheImplClass.clean();
        int actual = cacheImplClass.mapSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCleanNull() throws InterruptedException {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);
        cacheImplClass.put(null, null);
        int expected = 0;
        Thread.sleep(10_001L);
        cacheImplClass.clean();
        int actual = cacheImplClass.mapSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGet() {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);
        cacheImplClass.put("1", "Ford");

        Optional<String> actual = cacheImplClass.get("1");
        Optional<String> expected = Optional.of("Ford");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNull() {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);
        cacheImplClass.put(null, null);

        Optional<String> actual = cacheImplClass.get(null);
        Optional<String> expected = Optional.empty();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testClear() {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);
        cacheImplClass.put("1", "Ford");

        cacheImplClass.clear();
        int actual = cacheImplClass.mapSize();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testClearNull() {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);
        cacheImplClass.put(null, null);

        cacheImplClass.clear();
        int actual = cacheImplClass.mapSize();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testClearWithParameter() {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);
        cacheImplClass.put("1", "Ford");

        cacheImplClass.clear("1");
        int actual = cacheImplClass.mapSize();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testClearWithParameterNull() {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);
        cacheImplClass.put(null, null);

        cacheImplClass.clear(null);
        int actual = cacheImplClass.mapSize();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapSize() {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);
        cacheImplClass.put("1", "Ford");
        cacheImplClass.put("2", "Ford");
        cacheImplClass.put("3", "Ford");
        cacheImplClass.put("4", "Ford");

        int actual = cacheImplClass.mapSize();
        int expected = 4;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapSizeNull() {
        CacheImplClass<String, String> cacheImplClass = new CacheImplClass<>(10_000L);

        cacheImplClass.put(null, null);
        cacheImplClass.put(null, null);
        cacheImplClass.put(null, null);
        cacheImplClass.put(null, null);

        int actual = cacheImplClass.mapSize();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }
}
