package com.funoverflowwebservices.common.core.cache;

import java.util.concurrent.ExecutionException;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;

public class MemCacheClient {

    private Logger logger = Logger.getLogger(MemCacheClient.class);

    @Autowired
    private MemcachedClient memcached;

    public MemCacheClient() {
        super();
    }

    public OperationFuture<Boolean> addObjectToCache(String key, int exp, Object o) {
        logger.debug("Adding an object " + o + " with a key: " + key + " and with an expiry time as: " + exp);
        OperationFuture<Boolean> operationFuture = memcached.add(key, exp, o);
        return operationFuture;
    }

    public Object getObjectFromCache(String key) {
        logger.debug("Trying to fetch the key :" + key + " from memcache..");
        Object object = memcached.get(key);
        logger.debug("The fected object from memcache is: " + object);
        return object;
    }

    public boolean removeMemKey(String memkey) throws FunOverflowBaseException {
        logger.debug("removing the key from memcache :" + memkey);
        try {
            OperationFuture<Boolean> delete = memcached.delete(memkey);
            Boolean status = delete.get();
            return status;
        } catch (InterruptedException e) {
            throw new FunOverflowBaseException(e.getMessage(), "90", e, false);
        } catch (ExecutionException e) {
            throw new FunOverflowBaseException(e.getMessage(), "90", e, false);
        }
    }

}
