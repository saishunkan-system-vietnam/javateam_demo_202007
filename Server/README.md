# Server
Xây dựng RestAPI

## Cài đặt
### IDE
Cài đặt phiên bản [Eclipse IDE 2020‑06](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2020-06/R/eclipse-inst-win64.exe).
### Plug-in
Chọn **Help** -> **Eclipse Marketplace** sau đó tìm kiếm và cài đặt các plug-in dưới đây.
- Spring Tools 4
- Mybatipse
- SpotBugs
### Maven
#### Lombok
```
<dependencies>
	<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>
		<version>1.18.12</version>
		<scope>provided</scope>
	</dependency>
</dependencies>
```

## Code convention
Sử dụng [Google Java Style](https://google.github.io/styleguide/javaguide.html).

Chọn **Window** -> **Preferences** -> **Java** -> **Code Style** -> **Formatter**.

Sau đó **Import** file [eclipse-java-google-style.xml](https://github.com/google/styleguide/blob/gh-pages/eclipse-java-google-style.xml).
