# Servlet 

## Servlet的生命周期

- 加载Servlet类
- 创建Servlet对象
- 调用init方法
- 调用service方法
- 调用destroy方法
- 卸载Servlet类
- Servlet对象被垃圾回收

## Servlet的配置

- web.xml

  ```xml
  <servlet>
      <servlet-name>ServletName</servlet-name>
      <servlet-class>ServletClass</servlet-class>
  </servlet>
  <servlet-mapping>
      <servlet-name>ServletName</servlet-name>
      <url-pattern>/ServletPath</url-pattern>
  </servlet-mapping>
  ```
