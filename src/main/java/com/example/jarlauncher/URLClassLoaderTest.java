package com.example.jarlauncher;

import org.springframework.boot.loader.jar.JarFile;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * <Description> <br>
 *
 * @author yss<br>
 * @version 1.0<br>
 * @createDate 2020/06/13 16:45 <br>
 */
public class URLClassLoaderTest {

    public static void main(String[] args) throws Exception {
        JarFile.registerUrlProtocolHandler();
        URLClassLoader normal=new URLClassLoader(new URL[]{new URL("jar:file:C:/Users/Administrator/Desktop/jarlauncher/target/jarlauncher-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-boot-loader-1.5.10.RELEASE.jar!/")},null);
        Class<?> aClass = normal.loadClass("org.springframework.boot.loader.JarLauncher");
        System.out.println(aClass.getSimpleName());
    }
}
