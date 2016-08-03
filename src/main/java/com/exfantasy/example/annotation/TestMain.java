package com.exfantasy.example.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain {

  public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
      TestClass testClz = new TestClass();
    
      Class clz = TestClass.class;
      Method method = clz.getMethod("test", new Class[]{});
      if (method.isAnnotationPresent(MyAnnotation.class)) {
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        
        System.out.println("Prepare to invoke method...");
        method.invoke(testClz, new Object[]{});
        System.out.println("Invoke method done");
        
        String val = myAnnotation.value();
        System.out.println("Try to get MyAnnotation value: " + val);
      }
      Annotation[] annotations = method.getAnnotations();
      for (Annotation annotation : annotations) {
        System.out.println(annotation);
      }
  }
}
