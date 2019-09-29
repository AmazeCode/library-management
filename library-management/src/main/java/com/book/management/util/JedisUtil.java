package com.book.management.util;

import com.google.inject.internal.Lists;
import com.google.inject.internal.Sets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis工具类
 */
public class JedisUtil {

    private static Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static String get(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.get(key);
                value = StringUtils.isNotBlank(value) && !"nil".equalsIgnoreCase(value) ? value : null;
                logger.debug("get {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("get {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Object getObject(String key) {
        Object value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.get(key);
                logger.debug("getObject {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObject {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * 设置缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static String set(String key, String value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.set(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("set {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("set {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * KEY 延期
     * @param key
     * @param cacheSeconds
     */
    public static void expire(String key,int cacheSeconds){
        Jedis jedis = null;
        try{
            jedis = getResource();
            jedis.expire(key,cacheSeconds);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            jedis.close();
        }
    }

    public static String getMapField(String key,String field){
        Jedis jedis = null;
        String hgetResult = null;
        try{
            jedis = getResource();
            hgetResult = jedis.hget(key,field);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            jedis.close();
        }
        return hgetResult;
    }

    /**
     * 设置缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static String setObject(String key, String value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.set(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setObject {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObject {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 获取List缓存
     *
     * @param key 键
     * @return 值
     */
    public static List<String> getList(String key) {
        List<String> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.lrange(key, 0, -1);
                logger.debug("getList {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getList {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * 获取List缓存
     *
     * @param key 键
     * @return 值
     */
    public static List<Object> getObjectList(String key) {
        List<Object> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                List<String> list = jedis.lrange(key, 0, -1);
                value = Lists.newArrayList();
                for (String bs : list) {
                    value.add(bs);
                }
                logger.debug("getObjectList {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObjectList {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * 设置List缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setList(String key, List<String> value, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            result = jedis.rpush(key, (String[]) value.toArray());
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setList {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setList {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 设置List缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setObjectList(String key, List<Object> value, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            List<String> list = Lists.newArrayList();
            for (Object o : value) {
                list.add(o.toString());
            }
            result = jedis.rpush(key, (String[]) list.toArray());
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setObjectList {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObjectList {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 向List缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long listAdd(String key, String... value) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.rpush(key, value);
            logger.debug("listAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("listAdd {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 向List缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long listObjectAdd(String key, Object... value) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            List<String> list = Lists.newArrayList();
            for (Object o : value) {
                list.add(o.toString());
            }
            result = jedis.rpush(key, (String[]) list.toArray());
            logger.debug("listObjectAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("listObjectAdd {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Set<String> getSet(String key) {
        Set<String> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.smembers(key);
                logger.debug("getSet {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getSet {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Set<Object> getObjectSet(String key) {
        Set<Object> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = Sets.newHashSet();
                Set<String> set = jedis.smembers(key);
                for (String bs : set) {
                    value.add(bs);
                }
                logger.debug("getObjectSet {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObjectSet {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * 设置Set缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setSet(String key, Set<String> value, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            result = jedis.sadd(key, (String[]) value.toArray());
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setSet {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setSet {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 设置Set缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setObjectSet(String key, Set<Object> value, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            Set<String> set = Sets.newHashSet();
            for (Object o : value) {
                set.add(o.toString());
            }
            result = jedis.sadd(key, (set.toArray(new String[set.size()])));
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setObjectSet {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObjectSet {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 向Set缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long setSetAdd(String key, String... value) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.sadd(key, value);
            logger.debug("setSetAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setSetAdd {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 向Set缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long setSetObjectAdd(String key, Object... value) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            Set<String> set = Sets.newHashSet();
            for (Object o : value) {
                set.add(o.toString());
            }
            result = jedis.rpush(key,set.toArray(new String [set.size()]));
            logger.debug("setSetObjectAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setSetObjectAdd {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 获取Map缓存
     *
     * @param key 键
     * @return 值
     */
    public static Map<String, String> getMap(String key) {
        Map<String, String> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.hgetAll(key);
                logger.debug("getMap {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getMap {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * 获取Map缓存
     *
     * @param key 键
     * @return 值
     */
    public static Map<String, String> getObjectMap(String key) {
        Jedis jedis = null;
        Map <String,String> value = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.hgetAll(key);
            }
        } catch (Exception e) {
            logger.warn("getObjectMap {} = {}", key,value, e);
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * 设置Map缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static String setMap(String key, Map<String, String> value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            result = jedis.hmset(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setMap {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setMap {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 设置Map缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static String setObjectMap(String key, Map<String, String> value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            result = jedis.hmset(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setObjectMap {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObjectMap {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 向Map缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static String mapPut(String key, Map<String, String> value) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hmset(key, value);
            logger.debug("mapPut {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("mapPut {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 向Map缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static String mapObjectPut(String key, Map<String, String> value) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hmset(key, value);
            logger.debug("mapObjectPut {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("mapObjectPut {} = {}", key, value, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 移除Map缓存中的值
     *
     * @param key   键
     * @param mapKey 值
     * @return
     */
    public static long mapRemove(String key, String mapKey) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hdel(key, mapKey);
            logger.debug("mapRemove {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapRemove {}  {}", key, mapKey, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 移除Map缓存中的值
     *
     * @param key   键
     * @param mapKey 值
     * @return
     */
    public static long mapObjectRemove(String key, String mapKey) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hdel(key, mapKey);
            logger.debug("mapObjectRemove {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapObjectRemove {}  {}", key, mapKey, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 判断Map缓存中的Key是否存在
     *
     * @param key   键
     * @param mapKey 值
     * @return
     */
    public static boolean mapExists(String key, String mapKey) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hexists(key, mapKey);
            logger.debug("mapExists {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapExists {}  {}", key, mapKey, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 判断Map缓存中的Key是否存在
     *
     * @param key   键
     * @param mapKey 值
     * @return
     */
    public static boolean mapObjectExists(String key, String mapKey) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hexists(key, mapKey);
            logger.debug("mapObjectExists {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapObjectExists {}  {}", key, mapKey, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 删除缓存
     *
     * @param key 键
     * @return
     */
    public static long del(String key) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                result = jedis.del(key);
                logger.debug("del {}", key);
            } else {
                logger.debug("del {} not exists", key);
            }
        } catch (Exception e) {
            logger.warn("del {}", key, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 删除缓存
     *
     * @param key 键
     * @return
     */
    public static long delObject(String key) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                result = jedis.del(key);
                logger.debug("delObject {}", key);
            } else {
                logger.debug("delObject {} not exists", key);
            }
        } catch (Exception e) {
            logger.warn("delObject {}", key, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 缓存是否存在
     *
     * @param key 键
     * @return
     */
    public static boolean exists(String key) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.exists(key);
            logger.debug("exists {}", key);
        } catch (Exception e) {
            logger.warn("exists {}", key, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 缓存是否存在
     *
     * @param key 键
     * @return
     */
    public static boolean existsObject(String key) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.exists(key);
            logger.debug("existsObject {}", key);
        } catch (Exception e) {
            logger.warn("existsObject {}", key, e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 获取资源
     *
     * @return
     * @throws JedisException
     */
    public static Jedis getResource() throws JedisException {
        Jedis jedis = null;
        try {
            JedisPool jedisPool = (JedisPool) AppUtil.getBean("jedisPool");
            jedis = jedisPool.getResource();
//			logger.debug("getResource.", jedis);
        } catch (JedisException e) {
            logger.warn("getResource.", e);

            throw e;
        }
        return jedis;
    }
}
