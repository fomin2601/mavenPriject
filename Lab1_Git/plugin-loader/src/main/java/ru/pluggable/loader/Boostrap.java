package ru.pluggable.loader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Boostrap
{
	public static void main(String[] args) throws Exception
	{
		File commonsDir = new File("commons");

		File[] entries = commonsDir.listFiles();
		URL[] urls = new URL[entries.length];

		for (int i = 0; i < entries.length; i++)
			urls[i] = entries[i].toURI().toURL();

		URLClassLoader loader;
		loader = new URLClassLoader(urls, null);

//		URL url = new File("bin").toURI().toURL();
		
        File file = new File(".");
        String path = "jar:file:/" + file.getCanonicalPath();
        URL url = new URL(path+"/plugin-loader.jar!/");
		
		URLClassLoader appLoader;
		appLoader = new URLClassLoader(new URL[]{url}, loader);

		Class<?> appClass = appLoader.loadClass("ru.pluggable.loader.PluginLoader");
		Object appInstance = appClass.newInstance();
		Method m = appClass.getMethod("start");
		m.invoke(appInstance);
	}
}
