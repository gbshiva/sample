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

public class 	 {

	static Logger logger = Logger.getLogger(FileUpload2Cache.class);

	public static void main(String[] args) {

		if (args.length < 1) {
			logger.error("Usage: FileUpload2Cache <csv file to load to cache> ");
			System.exit(1);
		}

		try {
			BufferedReader in = new BufferedReader(new FileReader((new File(
					ClassLoader.getSystemResource(args[0]).toURI()))));
			if (in == null) {
				logger.error("Unable to read CSV  File. " + args[1]);
				System.exit(1);
			}

			// Connect to Terracotta
			CacheManager cmgr = new CacheManager();
			Cache dataStore = cmgr.getCache("cache1");

			String line = null;

			while ((line = in.readLine()) != null) {
				logger.info(line);
				String fields[] = line.split(",");
				Element data = new Element(fields[0], fields[1]);
				dataStore.put(data);

			}
			in.close();
		} catch (Exception ex) {
			logger.error(ex);
		}
		logger.info("Completed  loading data to cache");

	}

}
