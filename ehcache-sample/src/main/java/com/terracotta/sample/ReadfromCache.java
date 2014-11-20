package com.terracotta.sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

public class ReadfromCache {

	static Logger logger = Logger.getLogger(ReadfromCache.class);

	public static void main(String[] args) {

					// Connect to Terracotta
			CacheManager cmgr = new CacheManager();
			Cache dataStore = cmgr.getCache("cache1");
			for (int i=1;i<10;i++){
				Element e = dataStore.get(""+i);
				if (e != null){
					logger.info("Found key= "+e.getObjectKey() +" with value= "+e.getObjectValue());
				}
				
			}
			boolean ever=true;
			while (ever){
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
	}

}
