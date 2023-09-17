/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.singleton.DataCache;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Augusto
 */
public class DataCacheTest {
    private DataCache cache;
    
    @BeforeAll
    public void setUp() {
        cache = DataCache.getInstance();
        cache.addToCache("key1", "value1");
    }

    @Test
    public void testGetFromCache() {
        assertEquals("value1", cache.getFromCache("key1"));
    }

    @Test
    public void testAddToCache() {
        cache.addToCache("key2", "value2");
        assertEquals("value2", cache.getFromCache("key2"));
    }

    @Test
    public void testClearCache() {
        cache.clearCache();
        assertNull(cache.getFromCache("key1"));
    }

    @Test
    public void testSingletonInstance() {
        DataCache anotherCache = DataCache.getInstance();
        assertSame(cache, anotherCache);
    }
}
