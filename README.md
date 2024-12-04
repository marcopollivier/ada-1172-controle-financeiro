# Financial Control

## Infra

- Base Dependencies 

```groovy
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
```

```
org.hamcrest:hamcrest:2.1 -> 2.2
|    +--- org.hamcrest:hamcrest:2.2
```

## Rest Assured 
[Documentation](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)

```groovy
	testImplementation 'io.rest-assured:rest-assured:5.5.0'
```

> [!IMPORTANT]
> 
> Segundo a própria documentação é necessário que a dependência do `rest-assured`venha antes da declaração de 
> dependência`JUnit` em seu `pom.xml / build.gradle` para garantir que a versão correta do `Hamcrest` seja usada.

- É possível verificar a versão da dependência por meio do comando 
```bash 
./gradlew dependencies 
```

- No fim suas dependências vão ficar parecidas com essas
```groovy
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'io.rest-assured:rest-assured:5.5.0'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
```



## Help

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.0/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.0/gradle-plugin/packaging-oci-image.html)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

