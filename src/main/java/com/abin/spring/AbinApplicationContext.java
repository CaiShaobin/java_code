package com.abin.spring;

import com.abin.spring.config.*;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AbinApplicationContext {

    private Class configClass;

    private ConcurrentHashMap<String,Object> singletonObjects = new ConcurrentHashMap();// 单例池
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap();
    private List<BeanPostProcess> beanPostProcessList = new ArrayList<>();

    public AbinApplicationContext(Class configClass) {

        this.configClass = configClass;

        //解析配置类scan
        // get(@ComponentScan) --> get(Path) --> doScan(Path)
        // BeanDefinition --> BeanDefinitionMap
        scan(configClass);

        //
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if (beanDefinition.getScope().equals("singleton")){
                Object bean = createBean(beanName,beanDefinition);
                singletonObjects.put(beanName,bean);
            }
        }


    }

    private Object createBean(String beanName,BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getClazz();
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // 依赖注入
            for (Field declaredField : clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(Autowired.class)){
                    Object bean = getBean(declaredField.getName());

                    if (bean == null){
                        return new NullPointerException();//无法属性注入
                    }
                    declaredField.setAccessible(true);
                    declaredField.set(instance,bean);
                }
            }

            // Aware回调
            if (instance instanceof BeanNameAware){
                ((BeanNameAware) instance).setBeanName(beanName);
            }
            // 初始化前的beanPostProcess
            for (BeanPostProcess beanPostProcess : beanPostProcessList) {
                instance = beanPostProcess.postProcessBeforeInitialization(instance,beanName);
            }

            // 初始化
            if (instance instanceof InitializingBean){
                ((InitializingBean) instance).afterPropertiesSet();
            }
            // 初始化后的beanPostProcess
            for (BeanPostProcess beanPostProcess : beanPostProcessList) {
                instance = beanPostProcess.postProcessAfterInitialization(instance,beanName);
            }

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void scan(Class configClass) {
        // 取注解
        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        // 取路径
        String path = componentScanAnnotation.value();
        path = path.replace(".","/");
        // 扫描
        /**
         * 类加载机制：
         *      Bootstrap -- jre/lib
         *      Ext -- jre/ext/lib
         *      App -- classPath
         */
        ClassLoader classLoader = AbinApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        File file = new File(resource.getFile());
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File ff : files) {
                String absolutePath = ff.getAbsolutePath();//C:\Java\div-spring\target\classes\com\abin\service\UserService.class
                String className = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));//com\abin\service\UserService
                className = className.replace("\\",".");// com.abin.service.UserService
//                System.out.println(className);
                try {
                    Class<?> clazz = classLoader.loadClass(className);
                    if (BeanPostProcess.class.isAssignableFrom(clazz)) {
                        BeanPostProcess instance = ((BeanPostProcess) clazz.getDeclaredConstructor().newInstance());
                        beanPostProcessList.add(instance);
                    }

                    if (clazz.isAnnotationPresent(Component.class)){
                        //表示当前类是一个Spring.Bean
                        // 解析类 --> BeanDefinition
                        Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                        String beanName = componentAnnotation.value();

                        BeanDefinition beanDefinition = new BeanDefinition();
                        beanDefinition.setClazz(clazz);
                        if (clazz.isAnnotationPresent(Scope.class)){
                            Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                            beanDefinition.setScope(scopeAnnotation.value());
                        }else {
                            beanDefinition.setScope("singleton");
                        }

                        beanDefinitionMap.put(beanName,beanDefinition);
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object getBean(String beanName){
        if(beanDefinitionMap.containsKey(beanName)){
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())){
                Object o = singletonObjects.get(beanName);
                return o;
            }else {
                Object bean = createBean(beanName,beanDefinition);
                return bean;
            }
        }else {
            // 不存在对应的Bean
            throw new NullPointerException();
        }
    }
}
