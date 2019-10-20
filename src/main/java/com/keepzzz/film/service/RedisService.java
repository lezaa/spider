package com.keepzzz.film.service;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Set;

public interface RedisService {

     boolean setBit(String key, long offset, boolean isShow);

     boolean getBit(String key,long offset);

     boolean set(final String key,Object value);

     boolean set(final String key,Object value,Long expireTime);

     void remove(final String ...keys);

     void remove(final String key);

     boolean exists(final String key);

     Object get(final String key);

     void hmSet(String key,Object hashKey,Object value);

     Object hmGet(String key,Object hashKey);

     void lPush(String k, Object v);

     List<Object> lRange(String k,long l,long l1);

     void add(String key,Object value);

     Set<Object> setMembers(String key);

     void zAdd(String key,Object value,double source);

     Set<Object> rangeByScore(String key, double scoure, double scoure1);

     void saveDataToRedis(String name);

     boolean getDataToRedis(String name);

     Long zRank(String key, Object value);

     Set<ZSetOperations.TypedTuple<Object>> zRankWithScore(String key, long start, long end);

     Double zSetScore(String key, Object value);

     void incrementScore(String key, Object value, double scoure);

     Set<ZSetOperations.TypedTuple<Object>> reverseZRankWithScore(String key, long start,long end);

     Set<ZSetOperations.TypedTuple<Object>> reverseZRankWithRank(String key, long start, long end);
}
