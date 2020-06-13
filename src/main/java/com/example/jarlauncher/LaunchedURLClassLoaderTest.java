package com.example.jarlauncher;

import org.springframework.boot.loader.LaunchedURLClassLoader;
import org.springframework.boot.loader.jar.JarFile;

import java.net.URL;

/**
 * <Description> <br>
 *
 * @author yss<br>
 * @version 1.0<br>
 * @createDate 2020/06/13 16:42 <br>
 */
public class LaunchedURLClassLoaderTest {
    public static void main(String[] args) throws Exception {
        // 注册org.springframework.boot.loader.jar.Handler URL协议处理器
        JarFile.registerUrlProtocolHandler();
        // 构造LaunchedURLClassLoader类加载器，这里使用了1个URL，对应jar包中依赖包spring-boot-loader 使用 "!/" 分开，
        // 会使用 org.springframework.boot.loader.jar.Handler 处理器处理
        LaunchedURLClassLoader classLoader = new LaunchedURLClassLoader(
                new URL[]{
                        new URL("jar:file:C:/Users/Administrator/Desktop/jarlauncher/target/jarlauncher-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-boot-loader-1.5.10.RELEASE.jar!/")
                },
                LaunchedURLClassLoaderTest.class.getClassLoader());
        // 加载类
        Class<?> aClass = classLoader.loadClass("org.springframework.boot.loader.JarLauncher");
        System.out.println(aClass.getSimpleName());
    }
}

