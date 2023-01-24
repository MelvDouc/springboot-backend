# Sprint Boot

## Create a project

- [Sprint Initializr](https://start.spring.io/)
- Project Metadata
  - Group: _com.project1_
  - Name: _subproject1_
  - Leave rest untouched
- Packaging: Jar
- Dependencies:
  - (optional) Spring Web

### Extracting

- Click "Generate" button.
- Extract ZIP to usual Java folder.
- Open in IntelliJ
- --> src/main/com.project1.subproject1/MySubprojectApplication.java
  - right-click and "Run MySubprojectApplication.main()"

- [tutorial](https://youtu.be/slTUtTSwRKU?t=9205)

### Dependencies

#### Maven
- pom.xml -> project.dependencies[() => artifactId ===
  "spring-boot-starter"].artifactId += "-web"
- click "Load Maven changes" floating button

#### Gradle

- /External Libraries

## Syntax

### Annotations

#### @SpringBootApplication

Scan files in the package.

#### @org.springframework.stereotype.Component

Treat class as component.

#### @RestController

Use class as a rest controller.

#### @RequestMapping("/prefix")

- on a controller class: add a url prefix to controller methods
- on a controller method:

```java
@RequestMapping(value="{id}", method=RequestMethod.GET)
public ResponseEntity<User> getUser(@PathVariable long id) {
    return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
}
```

#### @(Get|Post|etc...)Mapping

Set HTTP method.

```java
@PostMapping
public ResponseEntity<User> saveUser(@RequestBody User user) {
    return new ResponseEntity<>(this.userUservice.saveUser(user), HttpStatus.CREATED);
}
```

### Controllers

#### Create

In MyApplication.java folder:

```java
package com.springboot.project1;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }
}
```
