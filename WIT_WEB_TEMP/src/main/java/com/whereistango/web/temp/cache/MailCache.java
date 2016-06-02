/**
 * 
 */
package com.whereistango.web.temp.cache;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.reflect.TypeToken;
import com.whereistango.common.gson.GsonUtility;
import com.whereistango.common.io.file.FileUtility;

/**
 * @author resulav
 *
 */
public class MailCache {

	private static File FILE = new File("whereistango_mail_list.txt");
	private static File FILE_COUNT = new File("whereistango_count.txt");

	private static final TypeToken<ArrayList<String>> TYPE_MAIL = new TypeToken<ArrayList<String>>() {
	};
	private static final TypeToken<ArrayList<VisitCount>> TYPE_VISIT = new TypeToken<ArrayList<VisitCount>>() {
	};
	private static final MailCache instance = new MailCache();

	private Set<String> mailSet = new HashSet<>();
	private volatile Map<String, VisitCount> visitMap = new HashMap<String, VisitCount>();

	public static MailCache getInstance() {
		return instance;
	}

	public synchronized boolean add(String mail) {
		return mailSet.add(mail);
	}

	public synchronized void increase() {
		String date = VisitCount.getDateStr();

		VisitCount count = visitMap.get(date);
		if (count == null) {
			visitMap.put(date, VisitCount.newInstance(date));
			return;
		}

		count.increase();

		visitMap.put(date, count);
	}

	public void writeToFile() {
		try {
			System.out.println(">>>> mail list written");
			FileUtility.write(FILE, GsonUtility.getGson().toJson(mailSet, TYPE_MAIL.getType()), false, false);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			FileUtility.write(FILE_COUNT, GsonUtility.getGson().toJson(visitMap.values(), TYPE_VISIT.getType()), false,
					false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readFromFile() {

		String content = null;

		try {
			if (FILE.exists()) {
				System.out.println(">>>> mail list read");

				content = FileUtility.readStringBuilder(FILE.getAbsolutePath(), "UTF-8").toString();

				mailSet = new HashSet<>(GsonUtility.getGson().fromJson(content, TYPE_MAIL.getType()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (FILE_COUNT.exists()) {
				System.out.println(">>>> visit count read");
				content = FileUtility.readStringBuilder(FILE_COUNT.getAbsolutePath(), "UTF-8").toString().trim();
				ArrayList<VisitCount> visitCounts = GsonUtility.getGson().fromJson(content, TYPE_VISIT.getType());

				visitCounts.stream().forEach(a -> visitMap.put(a.getDate(), a));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
